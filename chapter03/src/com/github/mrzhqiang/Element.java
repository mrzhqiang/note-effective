package com.github.mrzhqiang;

import java.util.Collections;
import java.util.Map;

public class Element {
  private static final Element Empty = new Element();

  private final String tagName = "#element";
  private final Map<String, String> attribute = Collections.emptyMap();
  private final Element child = Element.Empty;

  public Element() {
  }

  @Override public String toString() {
    return this.getClass().getSimpleName()
        + ":[tagName="
        + tagName
        + ", attribute="
        + attribute
        + ", child="
        + child + "]";
  }
}
