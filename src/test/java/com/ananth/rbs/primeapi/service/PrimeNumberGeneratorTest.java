package com.ananth.rbs.primeapi.service;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrimeNumberGeneratorTest {

    PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
    
    @Test
    public void generatePrimeNumbers_withInitialOne() {
        assertThat(emptyList(), is(primeNumberGenerator.generate(1)));
    }

    @Test
    public void generatePrimeNumbers_withInitialZero() {
        assertThat(emptyList(), is(primeNumberGenerator.generate(0)));
    }

    @Test
    public void generatePrimeNumbers_withInitialTen() {
        assertThat(asList(2, 3, 5, 7), is(primeNumberGenerator.generate(10)));
    }

    @Test
    public void generatePrimeNumbers_withNegativeInitial() {
        assertThat(emptyList(), is(primeNumberGenerator.generate(-1)));
    }
}