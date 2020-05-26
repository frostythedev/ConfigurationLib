package me.frostythedev.configlib.exampleplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ExampleCommand implements CommandExecutor {

  private ExamplePlugin plugin;

  public ExampleCommand(ExamplePlugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel,
      String[] args) {

    if(cmd.getName().equalsIgnoreCase("configversion")){
      if(args.length  == 1){
        int version = 1;
        version = Integer.parseInt(args[0]);

        if(plugin.getExampleConfig().getConfigVersion() < version){
          plugin.getConfigManager().offerVariable(ExampleConfig.class, "config-version", version);
        }
      }
    }
    return false;
  }
}
