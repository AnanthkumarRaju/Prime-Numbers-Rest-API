package com.ananth.rbs.primeapi.controller;

import com.ananth.rbs.primeapi.service.PrimeNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/primes")
public class PrimeApiController {

    private PrimeNumberGenerator primeNumberGenerator;

    @Autowired
    PrimeApiController(PrimeNumberGenerator primeNumberGenerator) {
        this.primeNumberGenerator = primeNumberGenerator;
    }

    @RequestMapping(value = "/{initial}", method = GET, produces = {"application/json", "application/xml"})
    PrimeResponse primeNumbers(@PathVariable("initial") int range) {
        List<Integer> primeNumbers = primeNumberGenerator.generate(range);
        return new PrimeResponse(range, primeNumbers);
    }
}
