package com.wenky.集合类.map类.hashMap数扩容;

import java.util.regex.Pattern;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-01-03 14:41
 */
public class MapKey {
  private static final String REG = "[0-9]+";

  private String key;

  public MapKey(String key) {
    this.key = key;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;

    if (obj == null || getClass() != obj.getClass()) return false;

    MapKey mapKey = (MapKey) obj;

    return !(key != null ? !key.equals(mapKey.key) : mapKey.key != null);
    // return (key == null ? mapKey.key == null : key.equals(mapKey.key));
  }

  @Override
  public int hashCode() {
    if (key == null) return 0;
    Pattern pattern = Pattern.compile(REG);
    if (pattern.matcher(key).matches()) return 1;
    else return 2;
  }

  @Override
  public String toString() {
    return key;
    // return super.toString();
  }
}
