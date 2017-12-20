package com.github.mrzhqaing;

import com.github.mrzhqaing.sample18.Test18;
import java.util.List;

/** 接口优于抽象 */
public class Note18 {
  public static void main(String[] args) {
    int[] ints = new int[10];
    List<Integer> list = Test18.intArrayAsList(ints);
    System.out.println(list.set(0, 0));
    System.out.println(list.set(1, 1111));
    System.out.println(list.set(2, 2222));
    System.out.println(list.set(0, 9999));
    System.out.println(list);
  }
}
