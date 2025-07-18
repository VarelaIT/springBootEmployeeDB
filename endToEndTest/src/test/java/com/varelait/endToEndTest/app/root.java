package com.varelait.endToEndTest.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@TestInstance(Lifecycle.PER_CLASS)
public class root {

    private HttpHeaders headers = new HttpHeaders();

    @BeforeAll
    void setup(){
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    void getRootURL(){
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/", String.class);
        HttpStatusCode status = response.getStatusCode();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, status);
    }

}
