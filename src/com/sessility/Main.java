package com.sessility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sessility.genetic.GeneticAlgorithm;
import com.sessility.genetic.Phenotype;
import com.sessility.genetic.cubism.Picture;
import com.sessility.genetic.cubism.PictureGenerator;

public class Main {

  public static int HEIGHT = 200;
  public static int WIDTH = 200;

  public static BufferedImage SOURCE_IMAGE = null;

  public static void main(String[] args) throws Exception {

    try {
      SOURCE_IMAGE = ImageIO.read(new File("apple.bmp"));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    ColorLibrary.populateColors();

    final GeneticAlgorithm<Picture> ga = new GeneticAlgorithm<Picture>(1000, 1000 * 1000, new PictureGenerator());

    new Thread() {
      public void run() {
        JFrame frame = new JFrame("Cubism");
        frame.setMinimumSize(new Dimension(WIDTH, 5 * HEIGHT));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        frame.add(p);
        while (true) {
          try {
            sleep(2 * 1000);
            Graphics g = p.getGraphics();
            ArrayList<Phenotype<Picture>> topten = ga.getTopTen();
            for (int i = 0; i < Math.min(5, topten.size()); i++) {
              Picture pic = (Picture) topten.get(i);

              g.drawImage(pic.getImage(), 0, i * HEIGHT, null);
              if (i == 0)
                System.out.println("Drawing best: " + pic);
              else {
                g.setColor(Color.black);
                g.drawLine(0, i * HEIGHT - 1, WIDTH, i * HEIGHT - 1);
              }
            }

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();

    ga.run();

  }
}
