package com.sessility.genetic;

public interface Phenotype<T> extends Comparable<Phenotype<T>> {
  double fitness();

  Phenotype<T> mutate();

  Phenotype<T> crossover(Phenotype<T> other);

}
