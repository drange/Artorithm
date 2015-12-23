package com.sessility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
  public static Picture currentBestPic = null;

  public static BufferedImage SOURCE_IMAGE = null;

  public static void main(String[] args) throws Exception {

    try {
      SOURCE_IMAGE = ImageIO.read(new File("apple.bmp"));
      HEIGHT = SOURCE_IMAGE.getHeight();
      WIDTH = SOURCE_IMAGE.getWidth();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    ColorLibrary.populateColors();

    final GeneticAlgorithm<Picture> ga = new GeneticAlgorithm<Picture>(1000, 1000 * 1000, new PictureGenerator());

    new Thread() {
      public void run() {
        long prevTimeOfImprovement = System.currentTimeMillis();
        double bestFitness = Long.MIN_VALUE;

        JFrame frame = new JFrame("Cubism");
        frame.setMinimumSize(new Dimension(WIDTH, 3 * HEIGHT));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        frame.add(p);
        p.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            printStuff();
          }
        });

        int counter = 0;
        while (true) {
          try {
            long now = System.currentTimeMillis();
            sleep(5 * 1000);
            counter++;
            Graphics g = p.getGraphics();
            ArrayList<Phenotype<Picture>> topten = ga.getTopTen();
            for (int i = 0; i < Math.min(3, topten.size()); i++) {
              Picture pic = (Picture) topten.get(i);

              g.drawImage(pic.getImage(), 0, i * HEIGHT, null);
              if (i == 0) {
                currentBestPic = pic;

                double f = pic.fitness();
                if (f > bestFitness) {
                  System.out.println("New best fitness: " + f);
                  bestFitness = f;
                  prevTimeOfImprovement = now;
                } else {
                  System.out.println("No improvement in " + Util.getDurationBreakdown(now - prevTimeOfImprovement));
                }

              } else {
                g.setColor(Color.black);
                g.drawLine(0, i * HEIGHT - 1, WIDTH, i * HEIGHT - 1);
                System.out.print(" " + pic.fitness());
              }
            }
            System.out.println();

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();

    ga.run();

  }

  public static void printStuff() {
    if (currentBestPic != null) {

      System.out.println("Fitness: " + currentBestPic.fitness());
      System.out.println(currentBestPic.toXML());

      StringSelection stringSelection = new StringSelection(currentBestPic.toXML());
      Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
      clpbrd.setContents(stringSelection, null);

      System.out.println("SVG contents set to clipboard");

    }
  }
}
