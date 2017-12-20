package com.github.mrzhqiang;

import com.github.mrzhqiang.sample2.NutritionFacts;

/** 遇到多个构造器参数时要考虑用构建器 */
public class Note2 {
  public static void main(String[] args) {
    // 无法很好地扩展到大量的可选参数
    // 包装食品外面显示的营养成分
    NutritionFacts facts = new NutritionFacts(1, 2, 12, 22, 12, 12);
    System.out.println(facts);
  }
}
