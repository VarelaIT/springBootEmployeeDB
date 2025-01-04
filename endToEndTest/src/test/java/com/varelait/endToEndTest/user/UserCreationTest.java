package com.varelait.endToEndTest.user;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;

import javax.management.RuntimeErrorException;

import static java.util.Map.entry;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.internal.junit.TestFinishedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@TestInstance(Lifecycle.PER_CLASS)
public class UserCreationTest {

    private final Map<String, Map<String, String>> emails = Map.ofEntries(
        entry("Ismael", Map.ofEntries(
            entry("email", "ismael@varelait.com"),
            entry("password", "alfalfa")
        )),
        entry("Jose", Map.ofEntries(
            entry("email", "jose@varelait.com"),
            entry("password", "josecitorobles")
        ))
    );
    private HttpHeaders headers = new HttpHeaders();
    UserResponse ismaelUsr = null;
    UserResponse joseUsr = null;

    private static Logger logger= LoggerFactory.getLogger(UserCreationTest.class); 
    @BeforeAll
    void setup(){
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test 
    void createValidUserOne() throws JSONException{

        Map<String, String> ismael = emails.get("Ismael");
        JSONObject body= new JSONObject();
        body.put("email", ismael.get("email"));
        body.put("password", ismael.get("password"));
        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        ResponseEntity<UserResponse> response = new RestTemplate()
            .postForEntity("http://localhost:8080/api/user", request, UserResponse.class);
        UserResponse user = response.getBody();
        
        ismaelUsr = user;
        logger.info("ID: " + user.id() + "\nEmail: " + user.email());
        assertNotNull(user);
    }

    @Test 
    void createValidUserTwo() throws JSONException{

        Map<String, String> jose = emails.get("Jose");
        JSONObject body= new JSONObject();
        body.put("email", jose.get("email"));
        body.put("password", jose.get("password"));
        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        try{

        ResponseEntity<UserResponse> response = new RestTemplate()
            .postForEntity("http://localhost:8080/api/user", request, UserResponse.class);
        UserResponse user = response.getBody();
        
        joseUsr = user;
        logger.trace("ID: " + user.id() + "\nEmail: " + user.email());
        assertNotNull(user);
        }catch(Error e){
            logger.info(e.getMessage());
            throw new RuntimeErrorException(e, "Test Failed");
                
        }
    }

}
