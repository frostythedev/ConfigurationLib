package me.frostythedev.configlib.exampleplugin;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import me.frostythedev.configlib.bukkit.BukkitConfig;
import me.frostythedev.configlib.bukkit.NullConfigSection;
import me.frostythedev.configlib.core.annotations.ConfigInfo;
import me.frostythedev.configlib.core.annotations.OnLoadVariable;
import me.frostythedev.configlib.core.annotations.OnLoadVariable.Type;
import org.bukkit.configuration.ConfigurationSection;

@ConfigInfo(name = "config.yml")
public class ExampleConfig extends BukkitConfig<ExamplePlugin> {

  @OnLoadVariable(path = "config-version", type = Type.VARIABLE)
  private int configVersion = 1;

  @OnLoadVariable(path = "string-list", type = Type.COLLECTION)
  private List<String> stringList = Lists.newArrayList();

  @OnLoadVariable(path = "section", type = Type.COLLECTION)
  private Set<String> sectionKeys = Sets.newHashSet();

  @OnLoadVariable(path = "section", type = Type.SECTION)
  private ConfigurationSection section = new NullConfigSection();

  public int getConfigVersion() {
    return this.configVersion;
  }

  public List<String> getStringList() {
    return stringList;
  }

  public ConfigurationSection getSection() {
    return section;
  }

  public Set<String> getSectionKeys() {
    return sectionKeys;
  }

}
