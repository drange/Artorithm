package com.sessility;

import java.awt.Color;

public class NamedColor {

  private final Color c;
  private final String name;

  public NamedColor(String name, int r, int g, int b) {
    this.name = name;
    c = new Color(r, g, b);
  }

  public static int diff(Color c1, Color c2) {
    int x = 0;
    x += Math.abs(c1.getRed() - c2.getRed());
    x += Math.abs(c1.getGreen() - c2.getGreen());
    x += Math.abs(c1.getBlue() - c2.getBlue());
    return x;
  }

  public Color getColor() {
    return c;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((c == null) ? 0 : c.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    NamedColor other = (NamedColor) obj;
    if (c == null) {
      if (other.c != null)
        return false;
    } else if (!c.equals(other.c))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return name;
  }
}
