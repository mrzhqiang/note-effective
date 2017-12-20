package com.github.mrzhqiang;

import com.github.mrzhqiang.sample6.Stack;
import java.util.Date;

/** 消除过期的对象引用 */
public class Note6 {
  public static void main(String[] args) {
    Stack stack = new Stack();
    for (int i = 0; i < 1000; i++) {
      stack.push("1");
      stack.push(new Date());
    }
    for (int i = 1000 * 2; i > 0; i--) {
      System.out.println(stack.pop());
    }
  }
}
