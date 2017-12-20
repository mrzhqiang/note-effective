package com.github.mrzhqiang;

import com.github.mrzhqiang.sample1.Services;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/** 考虑用静态工厂方法代替构造器 */
public class Note1 {
  public static void main(String[] args) {
    // 为了获得一个类的实例，常用的方法就是，使用new关键字，通过类的公开构造器去创建
    Note1 note21 = new Note1();
    System.out.println(note21);
    // 还有一种方法也值得尝试：静态工厂方法
    Boolean.valueOf(true);
    // 注意：静态工厂方法，并不直接对应于设计模式中的工厂方法模式


    // 优势1——它们有名称

    // 构造器本身无法更恰当地描述，到底创建了一个什么样的类；参数列表越多，越容易造成困惑和混乱
    // 而具有适当名称的静态工厂会更容易使用，产生的代码也更易于阅读
    // 比如
    BigInteger bigInteger = new BigInteger(10, 10, new Random());
    // 构造器返回的对象可能为素数，用静态工厂方法来表示，显然更为清楚（1.4版本增加了probablePrime）
    BigInteger bigInteger1 = BigInteger.probablePrime(10, new Random());
    System.out.println("构造：" + bigInteger + ", 工厂：" + bigInteger1);
    // 对于构造器来说，一个类中只有一个存在，只是参数列表的形式不同，这样用户很难记住用哪个构造器
    // 而且对于类的设计者来说，整理参数列表的顺序也非常头疼
    // 所以当一个类有多种构造器时，最好是提供静态工厂方法，选择一个好的名字来区分实例类型


    // 优势2——不必在每次调用它们的时候，都创建一个新对象

    // 因为是静态方法，所以可以提供类变量，比较常用的是单例模式
    // 不可变类可以重复利用预先构建好的实例，也就是类变量所缓存的实例
    // 这样减少了类的创建销毁，极大地提升了性能
    Boolean b1 = Boolean.valueOf(true);
    Boolean b2 = Boolean.valueOf(true);
    Boolean b3 = new Boolean(true);
    Boolean b4 = true;
    System.out.println("b1:" + (b1 == b2) + ", " + (b1 == b3) + ", " + (b1 == b4));
    System.out.println("b2:" + (b2 == b3) + ", " + (b2 == b4));
    System.out.println("b3:" + (b3 == b4));
    // 实例受控的类：类总能严格控制在某个时刻哪些实例应该存在。
    // 不可变类：确保不会存在两个相等的实例，即当且仅当a==b时，a.equals(b)为true
    // ==是值比较，两个类通过==比较时，仅比较它们在内存中的地址值；equals是全面比较，不仅比较地址值，还比较内容
    // TODO 上面关于不可变类的描述存在一定的困惑，待后面学习到第15条时，再回头看看是否准确
    String s1 = "11";
    String s2 = "11";
    System.out.println((s1 == s2) + ":" + s1.equals(s2));


    // 优势3——它们可以返回原返回类型的任何子类型的对象

    // 隐藏实现类，公开的API更加简洁
    // 集合接口有32个便利实现，这些实现都通过静态工厂方法在Collections中导出
    // Collections.synchronizedList()
    // 利用这一优势，可以在不可实例化的类中，创建多个不可访问的静态内部类，然后利用静态工厂方法返回对应实例
    // 用户只需要知道名称即可，具体实现并不关心，也不用阅读大量的文档
    // 而且发行更高版本时，也利于维护甚至直接更改内部实现，不会破坏现有的代码结构，因为都是用接口持有对象

    // 比如
    // EnumSet.noneOf(Enum.class);

    Services.registerDefaultProvider(() -> System.out::println);
    Services.registerProvider("simple", () -> System.err::println);
    Services.newInstance().show("default");
    Services.newInstance("simple").show("simple");


    // 优势4——在创建参数化类型实例的时候，使用静态工厂方法使代码变得更加简洁
    // PS：事实上使用IDEA已经不需要这样做了，Eclipse好像也不存在类似的问题。可能1.6之后的版本已经修复了。
    Map<String, List<String>> m = new HashMap<String, List<String>>();
    // 类型推导
    Map<String, List<String>> m1 = newInstance();

    // 缺点1——类没有公开的或者受保护的构造器，就无法被一个子类扩展
    // 缺点2——与其他静态方法没有任何区别

    // 总结：静态工厂方法和公有构造器都各有用处，我们需要理解它们各自的长处。
    // 静态工厂通常更加合适，所以推荐使用静态工厂替代无止境的构造器，这样会获得更稳定的开发效率
  }

  public static <K, V> HashMap<K, V> newInstance() {
    return new HashMap<K, V>();
  }
}
