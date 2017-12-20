package com.github.mrzhqiang;

import com.github.mrzhqiang.sample9.PhoneNumber;
import java.util.HashMap;
import java.util.Map;

/** 覆盖equals时总要覆盖hashCode */
public class Note9 {
  public static void main(String[] args) {

    Map<PhoneNumber, String> m = new HashMap<>();
    m.put(new PhoneNumber(408, 867, 5309), "Jenny");

    System.out.println(m.get(new PhoneNumber(408, 867, 5309)));
    // 当没有覆盖hashCode方法时，打印的是null

    // 当覆盖了之后，就正常返回了Jenny

  }
}
