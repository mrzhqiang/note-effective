package com.github.mrzhqiang;

import com.github.mrzhqiang.sample5.Person;
import java.util.Date;

/** 避免创建不必要的对象 */
public class Note5 {
  public static void main(String[] args) {
    Person p = new Person(new Date());

    int i = 0;
    long startTime = System.currentTimeMillis();
    while (i < 10000000) {
      p.isBabyBoomer();
      i++;
    }
    System.out.println("END:" + (System.currentTimeMillis() - startTime) + " ms");

    startTime = System.currentTimeMillis();
    //Long sum = 0L;
    long sum = 0L;
    for (long j = 0; j < Integer.MAX_VALUE; j++) {
      sum += j;
    }
    System.out.println(sum);
    System.out.println("END:" + (System.currentTimeMillis() - startTime) + " ms");
  }
}
