package com.github.mrzhqiang.sample3;

public class Elvis {
  public static final Elvis INSTANCE = new Elvis();

  private Elvis() {
  }

  public void show() {
    System.out.println(this.getClass().getSimpleName());
  }
}
