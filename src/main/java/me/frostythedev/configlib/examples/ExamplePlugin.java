package me.frostythedev.configlib.examples;

import me.frostythedev.configlib.bukkit.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

  private ExampleConfig config;
  private ConfigManager<ExamplePlugin> configManager;

  @Override
  public void onLoad() {

    this.configManager = new ConfigManager<>(this);
    this.configManager.registerConfigClass(ExampleConfig.class);
    this.config = (ExampleConfig) this.configManager.getConfigClass(ExampleConfig.class);
  }

  @Override
  public void onEnable() {

    this.config.loadConfig();

    //new UpdateVariablesExample(this);
    //new StringListExample(this);
    //new SectionKeyExample(this);
    //new ConfigSectionExample(this);
  }

  public ExampleConfig getExampleConfig() {
    return config;
  }

  public ConfigManager<ExamplePlugin> getConfigManager() {
    return configManager;
  }
}
