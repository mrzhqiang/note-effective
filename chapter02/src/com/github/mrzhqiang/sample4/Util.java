package com.github.mrzhqiang.sample4;

public class Util {
  private Util() {
    throw new AssertionError("No instance.");
  }

  public static void showSomething(Object obj) {
    System.out.println(obj);
  }
}
