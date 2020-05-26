package me.frostythedev.configlib.examples.types;

import me.frostythedev.configlib.examples.ExampleConfig;
import me.frostythedev.configlib.examples.ExamplePlugin;

public class SectionKeyExample {

  public SectionKeyExample(ExamplePlugin plugin) {

    ExampleConfig config = plugin.getExampleConfig();

    for (String key : config.getSectionKeys()) {
      System.out.printf("Key: %s", key);
    }
    System.out.println(" ");
  }

}
