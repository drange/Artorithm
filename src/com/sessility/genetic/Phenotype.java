package com.sessility.genetic;

public interface Phenotype<T> extends Comparable<Phenotype<T>> {
  int fitness();

  Phenotype<T> mutate();

  Phenotype<T> crossover(Phenotype<T> other);

}
