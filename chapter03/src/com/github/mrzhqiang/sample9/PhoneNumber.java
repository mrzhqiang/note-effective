package com.github.mrzhqiang.sample9;

public class PhoneNumber {
  private final short areaCode;
  private final short prefix;
  private final short lineNumber;

  public PhoneNumber(int areaCode, int prefix, int lineNumber) {
    rangeCheck(areaCode, 999, "area code");
    rangeCheck(prefix, 999, "prefix");
    rangeCheck(lineNumber, 9999, "line number");
    this.areaCode = (short) areaCode;
    this.prefix = (short) prefix;
    this.lineNumber = (short) lineNumber;
  }

  private static void rangeCheck(int arg, int max, String name) {
    if (arg < 0 || arg > max) {
      throw new IllegalArgumentException(name + ": " + arg);
    }
  }

  @Override public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof PhoneNumber)) {
      return false;
    }
    PhoneNumber pn = (PhoneNumber) obj;
    return pn.lineNumber == lineNumber
        && pn.prefix == prefix
        && pn.areaCode == areaCode;
  }

  @Override public int hashCode() {
    int result = 17;
    // 为什么使用31呢？因为它是个奇素数，如果是偶数的话，信息会丢失；奇素数不会。
    // 并且31有个特性：用它做乘法的时候，将自动换为31*i==(i<<5)-i，可以获得更好的性能
    result = 31 * result + (int) lineNumber;
    result = 31 * result + (int) prefix;
    result = 31 * result + (int) areaCode;
    return result;
  }
}
