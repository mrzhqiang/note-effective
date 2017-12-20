package com.github.mrzhqiang;

import com.github.mrzhqiang.sample3.Client;
import com.github.mrzhqiang.sample3.Elvis;
import com.github.mrzhqiang.sample3.NumberOff;
import com.github.mrzhqiang.sample3.RealClient;
import com.github.mrzhqiang.sample3.Singleton;

/** 用私有构造器或者枚举类型强化Singleton属性 */
public class Note3 {
  public static void main(String[] args) {
    Elvis.INSTANCE.show();

    // 由于Elvis唯一的构造器是私有的，因此下面的代码无法通过编译
    //new Elvis();

    int number = 1;
    NumberOff numberOff;
    do {
      if (number % 2 == 0) {
        numberOff = Client.getInstance();
      } else {
        numberOff = RealClient.getInstance();
      }
      numberOff.show(number++);
    } while (number < 100);

    System.out.println(Singleton.INSTANCE.getName());

    Singleton.INSTANCE.setName("newName");

    System.out.println(Singleton.INSTANCE.getName());
  }
}
