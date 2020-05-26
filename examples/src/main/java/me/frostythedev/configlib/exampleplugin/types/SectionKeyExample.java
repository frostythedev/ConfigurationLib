package me.frostythedev.configlib.exampleplugin.types;

import me.frostythedev.configlib.exampleplugin.ExampleConfig;
import me.frostythedev.configlib.exampleplugin.ExamplePlugin;

public class SectionKeyExample {

  public SectionKeyExample(ExamplePlugin plugin) {

    ExampleConfig config = plugin.getExampleConfig();

    for (String key : config.getSectionKeys()) {
      System.out.printf("Key: %s", key);
    }
    System.out.println(" ");
  }

}
