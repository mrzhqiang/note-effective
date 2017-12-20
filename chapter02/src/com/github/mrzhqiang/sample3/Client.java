package com.github.mrzhqiang.sample3;

public class Client implements NumberOff {
  private static final NumberOff INSTANCE = new Client();

  private Client() {
  }

  public static NumberOff getInstance() {
    return INSTANCE;
  }

  @Override public void show(int number) {
    System.out.println(this.getClass().getSimpleName() + ":" + number);
  }
}
