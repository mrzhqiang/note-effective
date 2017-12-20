package com.github.mrzhqiang.sample3;

/** 单元素的枚举类型，已成为最佳的单实例方案 */
public enum Singleton {
  INSTANCE();

  private String name;

  Singleton() {
    name = "default";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
