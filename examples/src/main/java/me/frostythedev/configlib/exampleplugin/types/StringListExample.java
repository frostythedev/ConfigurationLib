package me.frostythedev.configlib.exampleplugin.types;

import me.frostythedev.configlib.exampleplugin.ExampleConfig;
import me.frostythedev.configlib.exampleplugin.ExamplePlugin;

public class StringListExample {

  public StringListExample(ExamplePlugin plugin) {

    ExampleConfig config = plugin.getExampleConfig();

    for (String key : config.getStringList()) {
      System.out.printf("Index: %d, Value: %s\n", config.getStringList().indexOf(key), key);
    }
    System.out.println(" ");
  }

}
