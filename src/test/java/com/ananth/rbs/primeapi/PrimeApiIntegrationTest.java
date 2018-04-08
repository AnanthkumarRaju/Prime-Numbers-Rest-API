package com.ananth.rbs.primeapi;

import com.ananth.rbs.primeapi.controller.PrimeResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.ananth.rbs.primeapi.controller.PrimeResponse.newPrimeResponse;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PrimeApiApplication.class, webEnvironment = RANDOM_PORT)
public class PrimeApiIntegrationTest {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void primeNumbersWithDefaultJsonResponse() {
        PrimeResponse expectedPrimeResponse = newPrimeResponse().Initial(10).Primes(asList(2, 3, 5, 7)).build();

        ResponseEntity<PrimeResponse> response = restTemplate.getForEntity(url("/primes/10"), PrimeResponse.class);

        assertThat(APPLICATION_JSON_UTF8, is(response.getHeaders().getContentType()));
        assertThat(OK, is(response.getStatusCode()));
        assertThat(expectedPrimeResponse, is(response.getBody()));
    }

    @Test
    public void primeNumbersWithMediaTypeJsonResponse() {
        PrimeResponse expectedPrimeResponse = newPrimeResponse().Initial(5).Primes(asList(2, 3, 5)).build();

        ResponseEntity<PrimeResponse> response = restTemplate.getForEntity(url("/primes/5?mediaType=json"), PrimeResponse.class);

        assertThat(APPLICATION_JSON_UTF8, is(response.getHeaders().getContentType()));
        assertThat(OK, is(response.getStatusCode()));
        assertThat(expectedPrimeResponse, is(response.getBody()));
    }

    @Test
    public void primeNumbersWithXmlResponse() {
        PrimeResponse expectedPrimeResponse = newPrimeResponse().Initial(10).Primes(asList(2, 3, 5, 7)).build();

        ResponseEntity<PrimeResponse> response = restTemplate.getForEntity(url("/primes/10?mediaType=xml"), PrimeResponse.class);

        assertThat("xml", is(response.getHeaders().getContentType().getSubtype()));
        assertThat(OK, is(response.getStatusCode()));
        assertThat(expectedPrimeResponse, is(response.getBody()));
    }

    private String url(String uri) {
        return "http://localhost:" + port + uri;
    }

}
