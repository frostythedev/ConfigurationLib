package me.frostythedev.configlib.bukkit;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class NullConfigSection implements ConfigurationSection {

  @Override
  public Set<String> getKeys(boolean b) {
    return null;
  }

  @Override
  public Map<String, Object> getValues(boolean b) {
    return null;
  }

  @Override
  public boolean contains(String s) {
    return false;
  }

  @Override
  public boolean contains(String s, boolean b) {
    return false;
  }

  @Override
  public boolean isSet(String s) {
    return false;
  }

  @Override
  public String getCurrentPath() {
    return null;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public Configuration getRoot() {
    return null;
  }

  @Override
  public ConfigurationSection getParent() {
    return null;
  }

  @Override
  public Object get(String s) {
    return null;
  }

  @Override
  public Object get(String s, Object o) {
    return null;
  }

  @Override
  public void set(String s, Object o) {

  }

  @Override
  public ConfigurationSection createSection(String s) {
    return null;
  }

  @Override
  public ConfigurationSection createSection(String s, Map<?, ?> map) {
    return null;
  }

  @Override
  public String getString(String s) {
    return null;
  }

  @Override
  public String getString(String s, String s1) {
    return null;
  }

  @Override
  public boolean isString(String s) {
    return false;
  }

  @Override
  public int getInt(String s) {
    return 0;
  }

  @Override
  public int getInt(String s, int i) {
    return 0;
  }

  @Override
  public boolean isInt(String s) {
    return false;
  }

  @Override
  public boolean getBoolean(String s) {
    return false;
  }

  @Override
  public boolean getBoolean(String s, boolean b) {
    return false;
  }

  @Override
  public boolean isBoolean(String s) {
    return false;
  }

  @Override
  public double getDouble(String s) {
    return 0;
  }

  @Override
  public double getDouble(String s, double v) {
    return 0;
  }

  @Override
  public boolean isDouble(String s) {
    return false;
  }

  @Override
  public long getLong(String s) {
    return 0;
  }

  @Override
  public long getLong(String s, long l) {
    return 0;
  }

  @Override
  public boolean isLong(String s) {
    return false;
  }

  @Override
  public List<?> getList(String s) {
    return null;
  }

  @Override
  public List<?> getList(String s, List<?> list) {
    return null;
  }

  @Override
  public boolean isList(String s) {
    return false;
  }

  @Override
  public List<String> getStringList(String s) {
    return null;
  }

  @Override
  public List<Integer> getIntegerList(String s) {
    return null;
  }

  @Override
  public List<Boolean> getBooleanList(String s) {
    return null;
  }

  @Override
  public List<Double> getDoubleList(String s) {
    return null;
  }

  @Override
  public List<Float> getFloatList(String s) {
    return null;
  }

  @Override
  public List<Long> getLongList(String s) {
    return null;
  }

  @Override
  public List<Byte> getByteList(String s) {
    return null;
  }

  @Override
  public List<Character> getCharacterList(String s) {
    return null;
  }

  @Override
  public List<Short> getShortList(String s) {
    return null;
  }

  @Override
  public List<Map<?, ?>> getMapList(String s) {
    return null;
  }

  @Override
  public <T> T getObject(String s, Class<T> aClass) {
    return null;
  }

  @Override
  public <T> T getObject(String s, Class<T> aClass, T t) {
    return null;
  }

  @Override
  public <T extends ConfigurationSerializable> T getSerializable(String s, Class<T> aClass) {
    return null;
  }

  @Override
  public <T extends ConfigurationSerializable> T getSerializable(String s, Class<T> aClass, T t) {
    return null;
  }

  @Override
  public Vector getVector(String s) {
    return null;
  }

  @Override
  public Vector getVector(String s, Vector vector) {
    return null;
  }

  @Override
  public boolean isVector(String s) {
    return false;
  }

  @Override
  public OfflinePlayer getOfflinePlayer(String s) {
    return null;
  }

  @Override
  public OfflinePlayer getOfflinePlayer(String s, OfflinePlayer offlinePlayer) {
    return null;
  }

  @Override
  public boolean isOfflinePlayer(String s) {
    return false;
  }

  @Override
  public ItemStack getItemStack(String s) {
    return null;
  }

  @Override
  public ItemStack getItemStack(String s, ItemStack itemStack) {
    return null;
  }

  @Override
  public boolean isItemStack(String s) {
    return false;
  }

  @Override
  public Color getColor(String s) {
    return null;
  }

  @Override
  public Color getColor(String s, Color color) {
    return null;
  }

  @Override
  public boolean isColor(String s) {
    return false;
  }

  @Override
  public Location getLocation(String s) {
    return null;
  }

  @Override
  public Location getLocation(String s, Location location) {
    return null;
  }

  @Override
  public boolean isLocation(String s) {
    return false;
  }

  @Override
  public ConfigurationSection getConfigurationSection(String s) {
    return null;
  }

  @Override
  public boolean isConfigurationSection(String s) {
    return false;
  }

  @Override
  public ConfigurationSection getDefaultSection() {
    return null;
  }

  @Override
  public void addDefault(String s, Object o) {

  }
}
