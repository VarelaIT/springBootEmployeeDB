package com.varelait.springEmployeeDB.presentation.user;

import com.varelait.springEmployeeDB.service.entities.UserResponse;
import com.varelait.springEmployeeDB.service.entities.UserDTO;
import com.varelait.springEmployeeDB.service.user.IUserService;
import com.varelait.springEmployeeDB.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserEndpoint {

    private IUserService userService;

    @Autowired
    public UserEndpoint(UserService userService){
        this.userService = userService;
    }

    private HttpStatus statusState(Object object){
        if (object == null)
            return HttpStatus.BAD_REQUEST;
        else
            return HttpStatus.OK;
    }

    @PostMapping("/auth")
    public ResponseEntity<UserResponse> authenticate(@Valid @RequestBody UserDTO userRequest, HttpSession session){
        UserResponse user = userService.authenticate(userRequest);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (user != null)
            status = HttpStatus.OK;

        session.setAttribute("logged", true);
        session.setAttribute("userEmail", user.email);
        session.setAttribute("userid", user.id);
        return new ResponseEntity<>(user, status);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserDTO userRequest){
        UserResponse user = userService.create(userRequest);
        HttpStatus status = statusState(user);
        return new ResponseEntity<>(user, status);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable int id, @Valid @RequestBody UserDTO userRequest, HttpSession session){
        UserResponse user = null;

        if ((boolean) session.getAttribute("logged"))
            user = userService.update(id, userRequest);

        HttpStatus status = statusState(user);
        return new ResponseEntity<>(user, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable int id){
        var user = userService.get(id);
        HttpStatus status = statusState(user);
        return new ResponseEntity<>(user, status);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> get(){
        var user = userService.get();
        HttpStatus status = statusState(user);
        return new ResponseEntity<>(user, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable int id){
        var user = userService.delete(id);
        HttpStatus status = statusState(user);
        return new ResponseEntity<>(user, status);
    }

}
