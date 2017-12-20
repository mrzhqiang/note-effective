package com.github.mrzhqiang.sample8;

public class Relation {

  private String name;
  private boolean isLike;

  private double lat;
  private double lon;
  private float x;
  private float y;

  public Relation(String name) {
    this.name = name;
  }

  /** 一个高质量的equals方法 */
  @Override public boolean equals(Object obj) {
    // 1.使用==操作符检查“参数是否为这个对象的引用”——这只不过是一种性能优化，如果比较操作很昂贵，就值得这么做
    // 理解：如果相比较的类，它们的结构很复杂，需要逐个比较所包含的成员，那么可以做下面的性能优化
    if (this == obj) {
      return true;
    }

    // 2.使用instanceof操作符检查“参数是否为正确的类型”——一般情况下是当前类，也可以检查是否实现接口，如果此接口
    // 改进了equals方法的话；比如List/Set/Map/Map.Entry
    if (!(obj instanceof Relation)) {
      return false;
    }

    // 3.把参数转换成正确的类型。——因为已经检查过不符合转换类型的变量，因此确保成功
    Relation relation = (Relation) obj;

    // 4.对于该类中的每个“关键”域，检查参数中的域是否与该对象中对于的域相匹配。
    // float或double类型，必须要用对应类的静态比较方法
    // 其他的基本类型，可以使用==
    // 对象的话，使用递归的equals方法
    return (name != null && name.equals(relation.name))
        && isLike == relation.isLike
        && Double.compare(lat, relation.lat) == 0
        && Double.compare(lon, relation.lon) == 0
        && Float.compare(x, relation.x) == 0
        && Float.compare(y, relation.y) == 0;
  }
}
