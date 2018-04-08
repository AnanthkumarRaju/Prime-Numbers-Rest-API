package com.ananth.rbs.primeapi.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

@Service
public class PrimeNumberGenerator {

    PrimeNumberGenerator() {
    }

    @Cacheable("primes")
    public List<Integer> generate(int range) {
        return rangeClosed(2, range)
                .filter(i -> rangeClosed(2, (int) sqrt(i))
                        .allMatch(j -> i % j != 0)).boxed().collect(toList());
    }
}
