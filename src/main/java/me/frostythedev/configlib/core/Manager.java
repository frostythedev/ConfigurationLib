package me.frostythedev.configlib.core;

import me.frostythedev.configlib.bukkit.BaseConfig;
import org.bukkit.plugin.java.JavaPlugin;

public interface Manager<T extends JavaPlugin> {

  BaseConfig<T> getConfigClass(Class<? extends BaseConfig<T>> clazz);
  void registerConfigClass(Class<? extends BaseConfig<T>> configClass);

  default void reloadFields(Class<? extends BaseConfig<T>> configClass) {
    if (getConfigClass(configClass) != null) {
      reloadFields(configClass, getConfigClass(configClass));
    }
  }

  void reloadFields(Class<? extends BaseConfig<T>> configClass, BaseConfig<T> configObject);

  boolean offerVariable(Class<? extends BaseConfig<T>> clazz, String path, Object value);
}
