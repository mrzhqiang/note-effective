package com.github.mrzhqiang.sample3;

public class RealClient implements NumberOff {

  private static NumberOff INSTANCE;

  private RealClient() {
  }

  public static NumberOff getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new RealClient();
    }
    return INSTANCE;
  }

  @Override public void show(int number) {
    System.out.println(this.getClass().getSimpleName() + ":" + number);
  }
}
