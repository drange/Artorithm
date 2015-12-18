package com.sessility;

import java.awt.Color;

public class NamedColor {

  private final Color c;
  private final String name;

  public NamedColor(String name, int r, int g, int b) {
    this.name = name;
    c = new Color(r, g, b);
  }

  public static double diff(Color c1, Color c2) {
    double x = 0;

    float[] hsb1 = Color.RGBtoHSB(c1.getRed(), c1.getGreen(), c1.getBlue(), null);
    float[] hsb2 = Color.RGBtoHSB(c2.getRed(), c2.getGreen(), c2.getBlue(), null);

    // int y1 = r1 * .299000 + g1 * .587000 + b1 * .114000
    // int u1 = r1 * -.168736 + g1 * -.331264 + b1 * .500000 + 128
    // int v1 = r1 * .500000 + g1 * -.418688 + b1 * -.081312 + 128

    x += Math.abs(hsb1[0] - hsb2[0]) * 12d; // hue
    x += Math.abs(hsb1[1] - hsb2[1]) * 11d; // saturation
    x += Math.abs(hsb1[2] - hsb2[2]) * 10d; // brightness

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

  public String toXML() {
    return "fill:rgb(" + getColor().getRed() + ", " + getColor().getGreen() + ", " + getColor().getBlue() + ")";
  }

  @Override
  public String toString() {
    return "rgb(" + getColor().getRed() + ", " + getColor().getGreen() + ", " + getColor().getBlue() + ")";
  }
}
