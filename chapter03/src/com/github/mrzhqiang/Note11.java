package com.github.mrzhqiang;

/** 谨慎地覆盖clone */
public class Note11 {
  public static void main(String[] args) {
    // 使用静态工厂方法，去拷贝/转换一个类，比实现Cloneable接口要舒服得多
    // 不建议实现Cloneable接口和覆盖Object.clone方法
  }
}
