package com.ananth.rbs.primeapi.controller;

import com.ananth.rbs.primeapi.service.PrimeNumberGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.ananth.rbs.primeapi.controller.PrimeResponse.newPrimeResponse;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrimeApiControllerTest {

    PrimeNumberGenerator primeNumberGenerator = mock(PrimeNumberGenerator.class);

    @InjectMocks
    PrimeApiController controller;

    @Test
    public void primeNumbersReturnsExpectedResult() {
        List<Integer> expectedPrimeNumbers = asList(1, 2, 3);
        PrimeResponse expectedPrimeResponse = newPrimeResponse().Initial(10).Primes(expectedPrimeNumbers).build();

        when(primeNumberGenerator.generate(10)).thenReturn(expectedPrimeNumbers);

        assertThat(controller.primeNumbers(10), is(expectedPrimeResponse));
    }
}