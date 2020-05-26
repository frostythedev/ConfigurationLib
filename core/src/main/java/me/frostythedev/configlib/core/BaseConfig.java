package me.frostythedev.configlib.core;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public interface BaseConfig<T extends JavaPlugin> {
  
  void setPlugin(T t);
  T getPlugin();
  void createConfig(boolean load);
  void loadConfig();
  boolean saveConfig();
  void unloadConfig();

  default Object get(String path) {
    return null;
  }

  default Object get(String path, Object def) {
    return null;
  }

  default String getString(String path) {
    return null;
  }

  default String getString(String path, String def) {
    return null;
  }

  default int getInteger(String path) {
    return -1;
  }

  default int getInteger(String path, int def) {
    return -1;
  }

  default boolean getBoolean(String path) {
    return false;
  }

  default boolean getBoolean(String path, boolean def) {
    return false;
  }

  default void createSection(String path) {
  }

  default ConfigurationSection getSection(String path) {
    return null;
  }

  default boolean isSection(String path) {
    return this.getSection(path) == null;
  }

  default boolean createSectionIfNotExists(String path) {
    if (isSection(path)) {
      return false;
    }
    this.createSection(path);
    return true;
  }

  default Map<String, Object> getValues(boolean deep) {
    return null;
  }

  default double getDouble(String path) {
    return -1;
  }

  default double getDouble(String path, double def) {
    return -1;
  }

  default long getLong(String path) {
    return -1;
  }

  default long getLong(String path, long def) {
    return -1;
  }

  default List<?> getList(String path) {
    return null;
  }

  default List<?> getList(String path, List<?> def) {
    return null;
  }

  default boolean contains(String path) {
    return false;
  }

  default void removeKey(String path) {

  }

  default Set<String> getKeys(Boolean deep) {
    return null;
  }

  default Set<String> getKeys(boolean deep) {
    return null;
  }

  default List<String> getStringList(String path) {
    return null;
  }

  default void set(String path, Object value) {

  }

}
