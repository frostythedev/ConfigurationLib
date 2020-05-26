package me.frostythedev.configlib.examples.types;

import me.frostythedev.configlib.examples.ExampleConfig;
import me.frostythedev.configlib.examples.ExamplePlugin;

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
