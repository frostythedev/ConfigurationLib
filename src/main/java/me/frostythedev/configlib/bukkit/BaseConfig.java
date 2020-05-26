package me.frostythedev.configlib.bukkit;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.frostythedev.configlib.core.annotations.ConfigInfo;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BaseConfig<T extends JavaPlugin> {

  private T plugin;

  private File configFile;
  private YamlConfiguration yamlFile;

  private boolean loaded = false;

  public void createConfig(boolean load){

    if (this.getClass().isAnnotationPresent(ConfigInfo.class)) {

      String name = this.getClass().getAnnotation(ConfigInfo.class).name();

      if (!plugin.getDataFolder().exists()) {
        plugin.getDataFolder().mkdir();
      }

      this.configFile = new File(plugin.getDataFolder(), name);
      if (!this.configFile.exists()) {
        try (InputStream in = plugin.getResource(name)) {
          if (in != null) {
            Files.copy(in, this.configFile.toPath());
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      /*if (!this.configFile.exists()) {
        this.configFile.getParentFile().mkdirs();
        try {
          this.configFile.createNewFile();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }*/

      if(load){
        loadConfig();
      }
    }
  }

  public void loadConfig(){
    if(this.plugin == null) return;

    try {
      this.yamlFile = YamlConfiguration.loadConfiguration(this.configFile);
      this.yamlFile.load(this.configFile);
      this.loaded = true;
      //System.out.println("Config has been LOADED");
    } catch (IOException | InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  public boolean save() {
    if(!isLoaded()) return false;

    try {
      this.yamlFile.save(this.configFile);
      return true;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return false;
  }

  protected YamlConfiguration getConfig() {
    return this.yamlFile;
  }

  public void unloadConfig() {
    this.yamlFile = null;
    //this.configFile = null;
    this.loaded = false;
    //System.out.println("File has been UNLOADED");
  }

  public boolean isLoaded() {
    return loaded;
  }


  public void setPlugin(T plugin) {
    this.plugin = plugin;

  }

  protected T getPlugin() {
    return this.plugin;
  }

  protected void setDefault(String key, Object value) {
    if (this.yamlFile.contains(key)) {
      return;
    }
    this.yamlFile.set(key, value);
  }

  public Object get(String path) {
    return this.yamlFile.get(path);
  }

  public Object get(String path, Object def) {
    return this.yamlFile.get(path, def);
  }

  public String getString(String path) {
    return this.yamlFile.getString(path);
  }

  public String getString(String path, String def) {
    return this.yamlFile.getString(path, def);
  }

  public int getInteger(String path) {
    return this.yamlFile.getInt(path);
  }

  public int getInteger(String path, int def) {
    return this.yamlFile.getInt(path, def);
  }

  public boolean getBoolean(String path) {
    return this.yamlFile.getBoolean(path);
  }

  public boolean getBoolean(String path, boolean def) {
    return this.yamlFile.getBoolean(path, def);
  }

  public void createSection(String path) {
    this.yamlFile.createSection(path);
  }

  public ConfigurationSection getSection(String path) {
    return this.yamlFile.getConfigurationSection(path);
  }

  public boolean isSection(String path) {
    return this.getSection(path) == null;
  }

  public boolean createSectionIfNotExists(String path) {
    if (isSection(path)) {
      return false;
    }
    this.createSection(path);
    return true;
  }

  public Map<String, Object> getValues(boolean deep) {
    return this.yamlFile.getValues(deep);
  }

  public double getDouble(String path) {
    return this.yamlFile.getDouble(path);
  }

  public double getDouble(String path, double def) {
    return this.yamlFile.getDouble(path, def);
  }

  public long getLong(String path) {
    return this.yamlFile.getLong(path);
  }

  public long getLong(String path, long def) {
    return this.yamlFile.getLong(path, def);
  }

  public List<?> getList(String path) {
    return this.yamlFile.getList(path);
  }

  public List<?> getList(String path, List<?> def) {
    return this.yamlFile.getList(path, def);
  }

  public boolean contains(String path) {
    return this.yamlFile.contains(path);
  }

  public void removeKey(String path) {
    this.yamlFile.set(path, null);
  }

  public Set<String> getKeys(Boolean deep) {
    return this.yamlFile.getKeys(deep);
  }

  public Set<String> getKeys(boolean deep) {
    return this.yamlFile.getKeys(deep);
  }

  public List<String> getStringList(String path) {
    return this.yamlFile.getStringList(path);
  }

  public void createStringListIfNotExists(String path){
    if(this.getStringList(path) == null){
      List<String> empty = Lists.newArrayList();
      this.yamlFile.set(path, empty);
    }
  }

  public void set(String path, Object value) {
    this.yamlFile.set(path, value);
  }
}
