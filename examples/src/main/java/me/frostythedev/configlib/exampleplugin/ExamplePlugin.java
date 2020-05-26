package me.frostythedev.configlib.exampleplugin;

import me.frostythedev.configlib.core.ConfigManager;
import me.frostythedev.configlib.exampleplugin.types.ConfigSectionExample;
import me.frostythedev.configlib.exampleplugin.types.SectionKeyExample;
import me.frostythedev.configlib.exampleplugin.types.StringListExample;
import me.frostythedev.configlib.exampleplugin.types.UpdateVariablesExample;
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

    new UpdateVariablesExample(this);
    new StringListExample(this);
    new SectionKeyExample(this);
    new ConfigSectionExample(this);
  }

  public ExampleConfig getExampleConfig() {
    return config;
  }

  public ConfigManager<ExamplePlugin> getConfigManager() {
    return configManager;
  }
}
