package com.github.mrzhqaing.sample18;

import java.util.AbstractList;
import java.util.List;

public class Test18 {

  public static List<Integer> intArrayAsList(final int[] a) {
    if (a == null) {
      throw new NullPointerException("a null");
    }

    return new AbstractList<Integer>() {
      @Override public Integer get(int index) {
        return a[index];
      }

      @Override public Integer set(int index, Integer element) {
        int oldVal = a[index];
        a[index] = element;
        return oldVal;
      }

      @Override public int size() {
        return a.length;
      }
    };
  }
}
