package com.sessility.genetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeneticAlgorithm<T> {
  private ArrayList<Phenotype<T>> pool;

  private final Random random;

  public final static int INITIAL_SIZE = 100;

  private int fitnessThreshold;
  private int maxIterations;
  private final PhenotypeFactory<T> phenotypeFactory;

  public GeneticAlgorithm(int fitnessThreshold, int maxIterations, PhenotypeFactory<T> phenotypeFactory) {
    pool = new ArrayList<>();
    this.fitnessThreshold = fitnessThreshold;
    this.maxIterations = maxIterations;
    this.phenotypeFactory = phenotypeFactory;

    if (this.phenotypeFactory == null)
      throw new NullPointerException("PhenotypeFactory was null");

    random = new Random();

  }

  public ArrayList<Phenotype<T>> getTopTen() {
    ArrayList<Phenotype<T>> topten = new ArrayList<>(10);
    synchronized (pool) {
      for (int i = 0; i < Math.min(10, pool.size()); i++) {
        topten.add(pool.get(i));
      }
    }
    return topten;
  }

  public void initialize(int initialSize) {
    for (int i = 0; i < initialSize; i++)
      pool.add(phenotypeFactory.generate());
  }

  public void setFitnessThreshold(int ft) {
    this.fitnessThreshold = ft;
  }

  public void run() {

    if (pool.size() == 0) {
      initialize(INITIAL_SIZE);
    }

    int iterations = 0;
    int currentBestFitness = Integer.MIN_VALUE;
    while (iterations < maxIterations && currentBestFitness < fitnessThreshold) {
      iterations++;

      if (pool.size() > 4.5 * 1000) {
        sanitize();
      }

      ArrayList<Phenotype<T>> individuals = new ArrayList<>(10);
      synchronized (pool) {
        individuals.add(getBest());
        for (int i = 0; i < 9; i++) {
          individuals.add(getSkewedRandom());
        }
      }
      doIndividuals(individuals);
    }
  }

  private void doIndividuals(ArrayList<Phenotype<T>> individuals) {
    int ceil = 2 * (individuals.size() / 2);
    for (int i = 0; i < ceil; i++) {
      Phenotype<T> p1 = individuals.get(i++);
      Phenotype<T> p2 = individuals.get(i);
      Phenotype<T> pA = p1.crossover(p2);
      Phenotype<T> pB = p2.crossover(p1);

      individuals.add(pA);
      individuals.add(pB);

      Phenotype<T> pBA = pB.crossover(pA);
      Phenotype<T> pAB = pA.crossover(pB);

      individuals.add(pBA);
      individuals.add(pAB);
      individuals.add(pBA.mutate());
      individuals.add(pAB.mutate());
      individuals.add(pA.mutate());
      individuals.add(pB.mutate());
      individuals.add(pA.mutate());
      individuals.add(pB.mutate());
    }

    synchronized (pool) {
      Set<Phenotype<T>> hs = new HashSet<>();
      hs.addAll(pool);
      hs.addAll(individuals);

      pool.clear();
      pool.addAll(hs);
      Collections.sort(pool);
    }
  }

  private void sanitize() {
    System.out.print("Sanitizing ... ");
    synchronized (pool) {
      HashSet<Phenotype<T>> set = new HashSet<>();
      set.addAll(pool);

      ArrayList<Phenotype<T>> oldPool = new ArrayList<>();
      oldPool.addAll(set);
      Collections.sort(oldPool);
      pool.clear();
      for (int i = 0; i < Math.min(2 * 1000, oldPool.size()); i++) {
        pool.add(oldPool.get(i));
      }
      for (int i = 0; i < 100; i++) {
        // System.out.println("sanitize " + pool.size());
        pool.add(phenotypeFactory.generate());
        // System.gc();
      }
      Collections.sort(pool);
    }
    System.out.println("done.  " + pool.size() + " genes, " + statString());

    System.gc();
  }

  public String statString() {
    double sum = 0;
    double max = Integer.MIN_VALUE;
    double min = Integer.MAX_VALUE;
    double median = 0;
    int n = 0;
    double[] fs = new double[n];
    synchronized (pool) {
      n = pool.size();
      fs = new double[n];
      for (int i = 0; i < n; i++) {
        double f = pool.get(i).fitness();
        fs[i] = f;
        sum += f;
        max = Math.max(max, f);
        min = Math.min(min, f);
        if (i == fs.length / 2)
          median = f;
      }
    }

    double diff = 0;
    for (int i = 0; i < n; i++) {
      diff += (fs[i] - median) * (fs[i] - median);
    }
    // System.out.print("\tstddev\t" + ((double) diff) / n + "\t");
    // System.out.print(((double) diff) / n + "\t");
    // System.out.println(Math.sqrt(((double) diff) / n));

    double stddev = Math.sqrt(diff / n);

    double mean = sum / n;
    String s = "min:" + Math.round(min);
    s += ", max:" + Math.round(max);
    s += ", mean:" + Math.round(mean);
    s += ", median:" + Math.round(median);
    s += ", stddev:" + Math.round(stddev);
    return s;
  }

  public Phenotype<T> getSkewedRandom() {
    int s = pool.size();

    int r = 1 + random.nextInt(s * s);
    int x = (int) Math.floor(s - Math.sqrt(r));

    // System.out.println("Random: " + x + " out of " + s);
    Phenotype<T> p = null;
    synchronized (pool) {
      if (!pool.isEmpty())
        p = pool.get(Math.min(x, pool.size() - 1));
    }
    return p;
  }

  /**
   * Gets current best phenotype
   * 
   * @return
   */
  public Phenotype<T> getBest() {
    Phenotype<T> p = null;
    synchronized (pool) {
      if (!pool.isEmpty())
        p = pool.get(0);
    }
    return p;
  }

}
