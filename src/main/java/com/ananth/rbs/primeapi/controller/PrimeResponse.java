package com.ananth.rbs.primeapi.controller;

import java.util.List;
import java.util.Objects;

public class PrimeResponse {

    public int Initial;

    public List<Integer> Primes;

    public PrimeResponse() {
    }

    public PrimeResponse(int initial, List<Integer> primes) {
        Initial = initial;
        Primes = primes;
    }

    private PrimeResponse(Builder builder) {
        this.Initial = builder.Initial;
        this.Primes = builder.Primes;
    }

    public static Builder newPrimeResponse() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeResponse that = (PrimeResponse) o;
        return Initial == that.Initial &&
                Objects.equals(Primes, that.Primes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Initial, Primes);
    }

    @Override
    public String toString() {
        return "PrimeResponse{" +
                "Initial=" + Initial +
                ", Primes=" + Primes +
                '}';
    }

    public static final class Builder {
        private int Initial;
        private List<Integer> Primes;

        private Builder() {
        }

        public PrimeResponse build() {
            return new PrimeResponse(this);
        }

        public Builder Initial(int Initial) {
            this.Initial = Initial;
            return this;
        }

        public Builder Primes(List<Integer> Primes) {
            this.Primes = Primes;
            return this;
        }
    }
}
