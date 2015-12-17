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
  private int fitness = Integer.MIN_VALUE;

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
    image = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();

    g.setColor(Color.white);
    g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

    for (Circle c : circles) {
      g.setColor(c.getColor());
      g.fillOval(c.getX(), c.getY(), c.getRadius(), c.getRadius());
    }
    doComputeFitness();
  }

  private void doComputeFitness() {
    int f = 0;
    for (int x = 0; x < Main.WIDTH; x += 3) {
      for (int y = 0; y < Main.HEIGHT; y += 3) {
        Color here = new Color(image.getRGB(x, y));
        Color there = new Color(Main.SOURCE_IMAGE.getRGB(x, y));
        f -= Math.round(Math.log(NamedColor.diff(here, there)));
      }
    }
    fitness = f - (5 * circles.size());
  }

  public int size() {
    return circles.size();
  }

  @Override
  public int compareTo(Phenotype<Picture> o) {
    return o.fitness() - fitness();
  }

  @Override
  public Phenotype<Picture> crossover(Phenotype<Picture> other) {
    Picture o = (Picture) other;
    ArrayList<Circle> newCircles = new ArrayList<>(circles.size() + o.circles.size());
    for (int i = 0; i < Math.min(circles.size(), o.circles.size()); i++) {
      if (i % 2 == 0) {
        newCircles.add(circles.get(i));
      } else {
        newCircles.add(o.circles.get(i));
      }
    }

    return new Picture(newCircles);
  }

  @Override
  public int fitness() {
    return fitness;
  }

  @Override
  public Phenotype<Picture> mutate() {
    Picture clone = clone();

    int choice = RANDOM.nextInt(6);
    switch (choice) {
    case 0:
      mutateRise(clone);
    case 1:
      mutateRemove(clone);
    case 2:
      mutateAdd(clone);
    case 3:
      mutateColor(clone);
    case 4:
      mutateRadius(clone);
    case 5:
      mutateMove(clone);
    default:
      mutateAdd(clone);
    }
    clone.initialize();
    return clone;
  }

  /**
   * Adds a random circle at a random z-index
   * 
   * @param clone
   */
  private void mutateAdd(Picture clone) {
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
  }

  private void mutateRadius(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);
    clone.circles.add(index, PictureGenerator.randomRadius(c));
  }

  /**
   * Rise the z-coordinate of one circle; putting it at the end of the list
   * 
   * @param clone
   */
  private void mutateRise(Picture clone) {
    if (clone.circles.size() >= 2) {
      int index = RANDOM.nextInt(clone.circles.size() - 1);
      Circle c = clone.circles.remove(index);
      clone.circles.add(c);
      // System.out.println("rise " + index);
    }
  }

  private void mutateColor(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);
    // String col = c.getColorName();
    Circle n = PictureGenerator.randomColored(c);
    clone.circles.add(index, n);
    // System.out.println("Swap " + n + " from " + col + " to " +
    // n.getColorName());
  }

  private void mutateMove(Picture clone) {
    int index = RANDOM.nextInt(clone.circles.size());
    Circle c = clone.circles.remove(index);
    clone.circles.add(index, PictureGenerator.randomMove(c));
  }

  public final Picture clone() {
    Picture p = new Picture(circles);
    return p;
  }

  @Override
  public String toString() {
    return "Fitness: " + fitness() + " " + circles;
  }

  @Override
  public int hashCode() {
    return fitness;
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
