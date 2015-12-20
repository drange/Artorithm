package com.sessility.genetic.cubism;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sessility.Main;
import com.sessility.NamedColor;
import com.sessility.genetic.Phenotype;

/**
 * A picture is a list of Circles
 * 
 * @author pgd
 * 
 */
public class Picture implements Phenotype<Picture> {

  private final static Random RANDOM = new Random();
  private final List<Circle> circles;
  private BufferedImage image;
  private double fitness = Double.MIN_VALUE;

  // public String history = "";

  public Picture(List<Circle> circles) {
    this.circles = new ArrayList<>(circles.size());
    for (Circle c : circles) {
      this.circles.add(c);
    }

    initialize();
  }

  public BufferedImage getImage() {
    return image;
  }

  private void initialize() {

//    // deletes circles being hidden behind other circles
//    for (int i = 1; i < circles.size(); i++) {
//      Circle back = circles.get(i);
//      for (int j = 0; j < i; j++) {
//        Circle front = circles.get(j);
//        if (front.isHiding(back)) {
//          circles.remove(j);
//          j--;
//          i--;// go back one, since we delete one
//        }
//      }
//    }

    image = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();

    g.setColor(Color.white);
    g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

    for (Circle c : circles) {
      g.setColor(c.getColor());
      drawCircle(g, c.getX(), c.getY(), c.getRadius());
    }
    doComputeFitness();
  }

  private void drawCircle(Graphics g, int x, int y, int radius) {
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
  }

  private void doComputeFitness() {
    long f = 0;
    for (int x = 0; x < Main.WIDTH; x += 3) {
      for (int y = 0; y < Main.HEIGHT; y += 3) {
        Color here = new Color(image.getRGB(x, y));
        Color there = new Color(Main.SOURCE_IMAGE.getRGB(x, y));
        // f -= Math.round(Math.log(NamedColor.diff(here, there)));
        double diff = NamedColor.diff(here, there);
        // System.out.println("Diff: " + diff);
        f -= Math.round(diff);
      }
    }
    // how much should we penalize for many circles?
    // we could consider a )super-linear penalty
    fitness = f - (10 * circles.size());
  }

  public int size() {
    return circles.size();
  }

  @Override
  public int compareTo(Phenotype<Picture> o) {
    return -Double.compare(fitness, o.fitness());
  }

  @Override
  public Phenotype<Picture> crossover(Phenotype<Picture> other) {
    int c = RANDOM.nextInt(3);
    switch (c) {
    case 0:
      return braid(other);
    case 1:
      return leftRight(other);
    case 2:
      return upDown(other);
    default:
      return upDown(other);
    }
  }

  /**
   * Combines the upper half of the first picture with the lower half of the
   * other
   * 
   * @param other
   * @return
   */
  private Phenotype<Picture> upDown(Phenotype<Picture> other) {
    Picture o = (Picture) other;
    ArrayList<Circle> newCircles = new ArrayList<>(circles.size() + o.circles.size());
    for (int i = 0; i < circles.size(); i++) {
      Circle c = circles.get(i);
      if (c.getY() <= Main.HEIGHT / 2)
        newCircles.add(circles.get(i));
    }
    for (int i = 0; i < o.circles.size(); i++) {
      Circle c = o.circles.get(i);
      if (c.getY() >= Main.HEIGHT / 2)
        newCircles.add(c);
    }
    Picture p = new Picture(newCircles);
    // p.history = "(updown) " + history;
    return p;
  }

  /**
   * Combines the left half of the first picture with the right half of the
   * other
   * 
   * @param other
   * @return
   */
  private Phenotype<Picture> leftRight(Phenotype<Picture> other) {
    Picture o = (Picture) other;
    ArrayList<Circle> newCircles = new ArrayList<>(circles.size() + o.circles.size());
    for (int i = 0; i < circles.size(); i++) {
      Circle c = circles.get(i);
      if (c.getX() <= Main.WIDTH / 2)
        newCircles.add(circles.get(i));
    }
    for (int i = 0; i < o.circles.size(); i++) {
      Circle c = o.circles.get(i);
      if (c.getX() >= Main.WIDTH / 2)
        newCircles.add(c);
    }
    Picture p = new Picture(newCircles);
    // p.history = "(leftright) " + history;
    return p;
  }

  /**
   * Takes every other circle from the two pictures and braids them into one.
   * 
   * @param other
   * @return
   */
  private Phenotype<Picture> braid(Phenotype<Picture> other) {
    Picture o = (Picture) other;
    ArrayList<Circle> newCircles = new ArrayList<>(circles.size() + o.circles.size());
    for (int i = 0; i < Math.min(circles.size(), o.circles.size()); i++) {
      if (i % 2 == 0) {
        newCircles.add(circles.get(i));
      } else {
        newCircles.add(o.circles.get(i));
      }
    }
    Picture p = new Picture(newCircles);
    // p.history = "(braided) " + history;
    return p;
  }

  @Override
  public double fitness() {
    return fitness;
  }

  @Override
  public Phenotype<Picture> mutate() {
    Picture clone = clone();
    if (clone.circles.isEmpty()) {
      mutateAdd(clone);
      clone.initialize();
      return clone;
    }

    // a slightly larger chance for removing a circle
    int choice = RANDOM.nextInt(10);
    switch (choice) {
    case 0:
      mutateRise(clone);
      break;
    case 1:
      mutateRemove(clone);
      break;
    case 2:
      mutateAdd(clone);
      break;
    case 3:
      mutateColor(clone);
      break;
    case 4:
      mutateRadius(clone);
      break;
    case 5:
      mutateMove(clone);
      break;
    case 6:
      mutateBri(clone);
      break;
    case 7:
      mutateSat(clone);
      break;
    case 8:
      mutateHue(clone);
      break;
    default:
      mutateRemove(clone);
      break;
    }
    clone.initialize();
    return clone;
  }

  /**
   * Adds a random circle at a random z-index
   * 
   * @param clone
   */
  private static void mutateAdd(Picture clone) {
    if (clone.circles.isEmpty()) {
      clone.circles.add(PictureGenerator.randomCircle());
      return;
    }
    int index = RANDOM.nextInt(clone.circles.size());
    clone.circles.add(index, PictureGenerator.randomCircle());
  }

  /**
   * Removes a random circle **unless only 1 circle is left, then we add a
   * random circle**
   * 
   * @param clone
   */
  private void mutateRemove(Picture clone) {
    if (clone.circles.size() <= 1) {
      mutateAdd(clone);
      return;
    }
    int index = RANDOM.nextInt(clone.circles.size());
    clone.circles.remove(index);

    // clone.history = "(remove " + index + ") " + clone.history;
  }

  private void mutateRadius(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);
    clone.circles.add(index, PictureGenerator.randomRadius(c));

    // clone.history = "(radius " + index + ") " + clone.history;
  }

  /**
   * Rise the z-coordinate of one circle; putting it at the end of the list
   * 
   * @param clone
   */
  private static void mutateRise(Picture clone) {
    if (clone.circles.size() >= 2) {
      int index = RANDOM.nextInt(clone.circles.size() - 1);
      Circle c = clone.circles.remove(index);
      clone.circles.add(c);
      // clone.history = "(rise " + index + ") " + clone.history;
    }
  }

  private static void mutateBri(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);

    NamedColor nc = c.getNamedColor();

    NamedColor nnc = nc;
    if (RANDOM.nextBoolean()) {
      nnc = nc.addBri(0.1f);
    } else {
      nnc = nc.addBri(-0.1f);
    }
    Circle n = c.withColor(nnc);
    clone.circles.add(index, n);
    // clone.history = "(bri " + index + ") " + clone.history;
  }

  private static void mutateSat(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);

    NamedColor nc = c.getNamedColor();

    NamedColor nnc = nc;
    if (RANDOM.nextBoolean()) {
      nnc = nc.addSat(0.1f);
    } else {
      nnc = nc.addSat(-0.1f);
    }
    Circle n = c.withColor(nnc);
    clone.circles.add(index, n);
    // clone.history = "(sat " + index + ") " + clone.history;
  }

  private static void mutateHue(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);

    NamedColor nc = c.getNamedColor();

    NamedColor nnc = nc;
    if (RANDOM.nextBoolean()) {
      nnc = nc.addHue(0.1f);
    } else {
      nnc = nc.addHue(-0.1f);
    }
    Circle n = c.withColor(nnc);
    clone.circles.add(index, n);
    // clone.history = "(hue " + index + ") " + clone.history;
  }

  private static void mutateColor(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);
    // String col = c.getColorName();
    Circle n = PictureGenerator.randomColored(c);
    clone.circles.add(index, n);
    // System.out.println("Swap " + n + " from " + col + " to " +
    // n.getColorName());
    // clone.history = "(color " + index + ") " + clone.history;
  }

  private static void mutateMove(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);
    clone.circles.add(index, PictureGenerator.randomMove(c));

    // clone.history = "(move " + index + ") " + clone.history;
  }

  public final Picture clone() {
    Picture p = new Picture(circles);
    // p.history = history;
    return p;
  }

  @Override
  public String toString() {
    return "Picture [circles=" + circles + ", fitness=" + fitness + "]";
  }

  public String toXML() {
    String svg = "<?xml version=\"1.0\"?>\n<svg viewBox=\"0 0 " + Main.WIDTH + " " + Main.HEIGHT
        + "\" version=\"1.1\"  xmlns=\"http://www.w3.org/2000/svg\">";

    // background color
    svg += "\n\t<circle r=\"400\" style=\"fill:rgb(255, 255, 255)\" />";

    for (Circle c : circles)
      svg += "\n\t" + c.toXML();
    svg += "\n</svg>";
    return "Fitness: " + fitness() + "\n" + svg;
  }

  @Override
  public int hashCode() {
    return Double.hashCode(fitness);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Picture other = (Picture) obj;
    if (fitness != other.fitness)
      return false;
    if (circles == null) {
      if (other.circles != null)
        return false;
    } else if (!circles.equals(other.circles))
      return false;
    return true;
  }

}
