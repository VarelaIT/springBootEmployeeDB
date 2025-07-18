package com.varelait.endToEndTest.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@TestInstance(Lifecycle.PER_CLASS)
public class UserLoginTest {

    private UserResponse user;
    private HttpHeaders headers = new HttpHeaders();
    private String email = "info@varelait.com";
    private String password = "chacarron";

    @Test
    @Order(1)
    void setup() throws JSONException{
        JSONObject body= new JSONObject();
        body.put("email", email);
        body.put("password", password);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        //lets make this method verify is the user exist before creating it...
        try{
            ResponseEntity<UserResponse> response = new RestTemplate()
                .postForEntity("http://localhost:8080/api/user", request, UserResponse.class);
            user = response.getBody();
            
            System.out.println("ID: " + user.id() + "\nEmail: " + user.email());
        }catch(Exception e){
            System.out.println("USER CREATION ERROR: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    void validUserLogin() throws JSONException{
        JSONObject body= new JSONObject();
        body.put("email", email);
        body.put("password", password);
        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        ResponseEntity<UserResponse> response = new RestTemplate()
            .postForEntity("http://localhost:8080/api/login", request, UserResponse.class);
         
        var obj = response.getBody();
        var headers = response.getHeaders();
        assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
    }

}
