package com.github.mrzhqiang;

import com.github.mrzhqiang.sample8.Relation;
import java.security.Timestamp;
import java.security.cert.CertificateException;
import java.util.AbstractSet;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import sun.security.provider.certpath.X509CertPath;

/** 覆盖equals时请遵守通用约定 */
public class Note8 {
  public static void main(String[] args) throws CertificateException {
    // equals 比较方法，用来比较当前对象与其他对象是否完全相同，因此假若不重写的话，有可能导致比较的结果不一致
    // 但若是完全用不到比较方法，那么实际上也不是很大的问题，只是应该也必须养成一个良好的习惯
    // 因为比较方法是生来具有，假若每一个实例都是唯一的存在，最好在扩展时都将之重写

    // 类的每个实例本质上都是唯一的
    Thread thread = new Thread();
    // 线程类并没有去覆盖equals

    // 不关心类是否提供了“逻辑相等(logical equality)”的测试功能
    Random random = new Random();
    random.equals(random);

    // 超类已经覆盖了equals，从超类继承过来的行为对于子类也是合适的
    Set s = new AbstractSet() {
      @Override public Iterator iterator() {
        return null;
      }

      @Override public int size() {
        return 0;
      }
    };

    // 类是私有的或是包级私有的，可以确定它的equals方法永远不会被调用

    // 什么时候类应该覆盖Object.equals呢？
    // 如果类具有自己特有的“逻辑相等”概念(不同于对象等同的概念)，而且超类还没有覆盖equals以实现期望的行为，
    // 这时我们就需要覆盖equals方法。这通常属于“值类”的情形。

    // 等价关系
    // 自反性，也就是自己比较自己的时候，必定返回true
    // 对称性，比较一个对象时，如果返回true，那么用这个对象来比较自身也必须是true
    // 传递性，如果A比较B是true，B比较C是true，那么A比较C也必须是true
    // 一致性，如果比较返回true，在内部的比较值没有发生改变之前，多次调用始终返回true

    //Timestamp timestamp = new Timestamp(new Date(), new X509CertPath(System.in));

    Relation relation = new Relation("111");

    System.out.println("Relation:" + relation.equals(new Relation("111")));
  }
}
