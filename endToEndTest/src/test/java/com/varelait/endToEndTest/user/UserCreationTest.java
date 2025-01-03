package com.varelait.endToEndTest.user;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.Map;
import static java.util.Map.entry;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.commons.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@TestInstance(Lifecycle.PER_CLASS)
public class UserCreationTest {

    private final Map<String, Map<String, String>> emails = Map.ofEntries(
        entry("Ismael", Map.ofEntries(
            entry("email", "ismael.varelait.com"),
            entry("password", "alfalfa")
        )),
        entry("Jose", Map.ofEntries(
            entry("email", "jose.varelait.com"),
            entry("password", "josecitorobles")
        ))
    );
    private HttpHeaders headers = new HttpHeaders();
    UserResponse ismaelUsr = null;
    UserResponse joseUsr = null;

    //private Logger logger = (Logger) LoggerFactory.getLogger(UserCreationTest.class); 
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
        System.out.println("ID: " + user.id() + "\nEmail: " + user.email());
        assertNotNull(user);
    }

    @Test 
    void createValidUserTwo() throws JSONException{

        Map<String, String> jose = emails.get("Ismael");
        JSONObject body= new JSONObject();
        body.put("email", jose.get("email"));
        body.put("password", jose.get("password"));
        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        ResponseEntity<UserResponse> response = new RestTemplate()
            .postForEntity("http://localhost:8080/api/user", request, UserResponse.class);
        UserResponse user = response.getBody();
        
        joseUsr = user;
        System.out.println("ID: " + user.id() + "\nEmail: " + user.email());
        assertNotNull(user);
    }

}
