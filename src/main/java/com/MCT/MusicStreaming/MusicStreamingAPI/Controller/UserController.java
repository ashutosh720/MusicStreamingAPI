package com.MCT.MusicStreaming.MusicStreamingAPI.Controller;

import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import com.MCT.MusicStreaming.MusicStreamingAPI.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@Valid @RequestBody Users user) {
        Users savedUser = userService.registerUser(user);
        return new ResponseEntity<Users>(savedUser, HttpStatus.CREATED);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<Users> authenticateUser(@Valid @RequestBody Users user) {
        Users authenticatedUser = userService.authenticateUser(user);
        return new ResponseEntity<Users>(authenticatedUser, HttpStatus.OK);
    }

    @GetMapping("/findbyId/{user_id}")
    public Users findUserById(int user_id){
        return this.userService.findUserById(user_id);
    }


}

