package com.foxconn.license.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foxconn.license.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins="*")
@RestController
public class WebController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LicenseRepository licenseRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping(path = "/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping(path = "/user/{username}")
    public User getUser(@PathVariable String username){
        return userRepository.findByusername(username);
    }
    @PutMapping(path = "/user")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @DeleteMapping(path="/user/{username}")
    public List<User> DeleteUser(@PathVariable String username){

        return userRepository.removeByusername(username);
    }
    @DeleteMapping(path="/user1/{username}")
    public void DeleteUser1(@PathVariable String username){
        //test Custom Delete Query
        userRepository.deleteUserByname(username);
    }
    @DeleteMapping(path="/users")
    public void DeleteUsers(){
        userRepository.deleteAllInBatch();
    }
    
}
