package me.frostythedev.configlib.examples.types;

import me.frostythedev.configlib.examples.ExampleConfig;
import me.frostythedev.configlib.examples.ExamplePlugin;

public class StringListExample {

  public StringListExample(ExamplePlugin plugin) {

    ExampleConfig config = plugin.getExampleConfig();

    for (String key : config.getStringList()) {
      System.out.printf("Index: %d, Value: %s\n", config.getStringList().indexOf(key), key);
    }
    System.out.println(" ");
  }

}
