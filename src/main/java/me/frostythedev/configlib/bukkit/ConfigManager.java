package me.frostythedev.configlib.bukkit;

import com.google.common.collect.Maps;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.frostythedev.configlib.core.Manager;
import me.frostythedev.configlib.core.annotations.OnLoadVariable;
import me.frostythedev.configlib.core.annotations.OnLoadVariable.Type;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager<T extends JavaPlugin> implements Manager<T> {

  private Map<Class<? extends BaseConfig<T>>, BaseConfig<T>> configMap;

  private JavaPlugin plugin;

  public ConfigManager(JavaPlugin plugin) {
    this.plugin = plugin;

    this.configMap = Maps.newHashMap();
  }

  @Override
  public BaseConfig<T> getConfigClass(Class<? extends BaseConfig<T>> clazz) {
    if (this.configMap.containsKey(clazz)) {
      return this.configMap.get(clazz);
    }

    return null;
  }

  @Override
  public void registerConfigClass(Class<? extends BaseConfig<T>> configClass) {

    if (getConfigClass(configClass) != null) {
      return;
    }

    BaseConfig<T> clazzInstance = null;

    try {
      clazzInstance = configClass.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }

    if (clazzInstance != null) {

      clazzInstance.setPlugin((T) this.plugin);

      clazzInstance.createConfig(true);

      reloadFields(configClass, clazzInstance);

      clazzInstance.unloadConfig();
    }

    this.configMap.put(configClass, clazzInstance);
  }

  @Override
  public void reloadFields(Class<? extends BaseConfig<T>> configClass, BaseConfig<T> configObject) {
    for (Field field : configClass.getDeclaredFields()) {
      if (field.isAnnotationPresent(OnLoadVariable.class)) {
        try {
          field.setAccessible(true);

          OnLoadVariable onLoadVariable = field.getAnnotation(OnLoadVariable.class);
          String path = onLoadVariable.path();

          Object value = field.get(configObject);

          if(onLoadVariable.type() == Type.VARIABLE){
            if (value instanceof String) {
              field.set(configObject, configObject.getConfig().getString(path));
            } else if (value instanceof Integer) {
              field.set(configObject, configObject.getConfig().getInt(path));
            } else if (value instanceof Double) {
              field.set(configObject, configObject.getConfig().getDouble(path));
            } else if (value instanceof Boolean) {
              field.set(configObject, configObject.getConfig().getBoolean(path));
            } else {
              field.set(configObject, configObject.getConfig().get(path));
            }
          }else if (onLoadVariable.type() == Type.SECTION){

            field.set(configObject, configObject.getConfig().getConfigurationSection(path));
          }else {
            if (value instanceof List<?>) {
              List<?> genericList = configObject.getList(path);
              if (genericList != null && !genericList.isEmpty()) {
                if (genericList.get(0) instanceof String) {
                  field.set(configObject, genericList);
                }
              }
            }else if (value instanceof Set<?>) {
              Set<String> genericList = configObject.getSection(path).getKeys(false);
              if (!genericList.isEmpty()) {
                field.set(configObject, genericList);
              }
            }
          }

          field.setAccessible(false);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Override
  public boolean offerVariable(Class<? extends BaseConfig<T>> clazz, String path, Object value) {

    BaseConfig<T> config = getConfigClass(clazz);

    config.loadConfig();
    config.set(path, value);
    if (config.save()) {
      reloadFields(clazz);
      return true;
    }

    return false;
  }
}
