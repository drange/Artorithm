package com.sessility.genetic;

public interface PhenotypeFactory<T> {
  Phenotype<T> generate();
}
