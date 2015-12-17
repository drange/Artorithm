package com.sessility.genetic.cubism;

import java.util.ArrayList;
import java.util.Random;

import com.sessility.ColorLibrary;
import com.sessility.Main;
import com.sessility.NamedColor;
import com.sessility.genetic.Phenotype;
import com.sessility.genetic.PhenotypeFactory;

public class PictureGenerator implements PhenotypeFactory<Picture> {

  private final static Random RANDOM = new Random();

  @Override
  public Phenotype<Picture> generate() {
    int size = 5 + RANDOM.nextInt(20);
    ArrayList<Circle> circles = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      circles.add(randomCircle());
    }
    return new Picture(circles);
  }

  public static Circle randomColored(Circle c) {
    NamedColor col = ColorLibrary.getRandom();
    return c.withColor(col);
  }

  public static Circle randomRadius(Circle c) {

    int r = c.getRadius();
    int rr = RANDOM.nextInt(r) + (r / 2);

    return c.withRadius(Math.max(1, rr));
  }

  public static Circle randomMove(Circle c) {
    if (RANDOM.nextBoolean()) {
      int x = c.getX();
      int xx = RANDOM.nextInt(20) - 10;
      return c.withX(xx + x);
    } else {
      int x = c.getY();
      int xx = RANDOM.nextInt(20) - 10;
      return c.withY(xx + x);
    }
  }

  public static Circle randomCircle() {
    int x = RANDOM.nextInt(Main.WIDTH);
    int y = RANDOM.nextInt(Main.HEIGHT);

    int space = Math.min(Main.WIDTH - x, Main.HEIGHT - y);
    space = Math.min(space, x);
    space = Math.min(space, y);

    return new Circle(x, y, 1 + RANDOM.nextInt(space + 1), ColorLibrary.getRandom());
  }
}
