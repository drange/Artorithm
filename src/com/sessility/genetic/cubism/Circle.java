package com.sessility.genetic.cubism;

import java.awt.Color;

import com.sessility.NamedColor;

public class Circle {

  private final int x;
  private final int y;
  private final int r;
  private final NamedColor c;

  public Circle(int x, int y, int r, NamedColor c) {
    this.x = x;
    this.y = y;
    this.r = r;
    this.c = c;

    if (this.r <= 0) {
      throw new IllegalArgumentException("Radius must be positive: " + r);
    }
  }

  public NamedColor getNamedColor() {
    return c;
  }

  /**
   * Returns true if and only if this completely covers back, i.e. dist(this,
   * back) + rad(back) <= rad(this)
   * 
   * @param back
   *          the object to check if is behind this
   * @return true if and only if this completely covers back
   */
  public boolean isHiding(Circle back) {
    double frontRad = getRadius();
    double backRad = back.getRadius();
    double centerDist = dist(getX(), getY(), back.getX(), back.getY());

    return centerDist + backRad <= frontRad;
  }

  public static double dist(int x1, int y1, int x2, int y2) {
    double xp = Math.pow(x1 - x2, 2);
    double yp = Math.pow(y1 - y2, 2);
    return Math.sqrt(xp + yp);
  }

  public Circle withColor(NamedColor c) {
    return new Circle(x, y, r, c);
  }

  public Circle withRadius(int r) {
    return new Circle(x, y, r, c);
  }

  public Circle withX(int x) {
    return new Circle(x, y, r, c);
  }

  public Circle withY(int y) {
    return new Circle(x, y, r, c);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getRadius() {
    return r;
  }

  public Color getColor() {
    return c.getColor();
  }

  public String getColorName() {
    return c.getName();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((c == null) ? 0 : c.hashCode());
    result = prime * result + r;
    result = prime * result + x;
    result = prime * result + y;
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
    Circle other = (Circle) obj;
    if (c == null) {
      if (other.c != null)
        return false;
    } else if (!c.equals(other.c))
      return false;
    if (r != other.r)
      return false;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  public String toXML() {
    String xmlx = "cx=\"" + x + "\"";
    String xmly = "cy=\"" + y + "\"";
    String xmlr = "r=\"" + r + "\"";
    String xmlf = "style=\"fill:" + c + "\"";

    String desc = "<desc id=\"" + hashCode() + "\">" + c.getName() + "</desc>";

    return "<circle " + xmlx + " " + xmly + " " + xmlr + " " + xmlf + ">" + desc + "</circle>";

  }

  @Override
  public String toString() {
    return "Circle [x=" + x + ", y=" + y + ", r=" + r + ", c=" + c + "]";
  }

}
