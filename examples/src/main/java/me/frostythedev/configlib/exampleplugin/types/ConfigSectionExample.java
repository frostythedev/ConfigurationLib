package me.frostythedev.configlib.exampleplugin.types;

import me.frostythedev.configlib.exampleplugin.ExampleConfig;
import me.frostythedev.configlib.exampleplugin.ExamplePlugin;

public class ConfigSectionExample {

  public ConfigSectionExample(ExamplePlugin plugin){

    ExampleConfig config = plugin.getExampleConfig();

    for(String key : config.getSection().getKeys(false)){

      for(String value : config.getSection("section." + key).getKeys(false)){

        System.out.printf("Key: %s, Value: %s", key, config.get("section." + key + "." + value));

      }

      System.out.println(" ");
    }
  }

}
