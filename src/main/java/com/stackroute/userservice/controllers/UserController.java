package com.stackroute.userservice.controllers;


import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")

    public ResponseEntity<User>saveUser(@RequestBody User user)
    {
        User savedUser=userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);

    }
    @GetMapping("users")
    public ResponseEntity<?>getAllUser(){

    List<User> getUser=userService.getAllUser();
        return new ResponseEntity<List<User>>(getUser,HttpStatus.OK);

    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?>getUserById(@PathVariable("id") int id){

        User getId=userService.getUserById(id);
        return new ResponseEntity<User>(getId,HttpStatus.OK);

   }
    @PutMapping("user/{id}")

        public ResponseEntity<User>updateUser(@RequestBody User user,@PathVariable int id)
        {
            User updatedUser=userService.updateUser(user,id);
            return new ResponseEntity<User>(updatedUser, HttpStatus.OK);

        }
     @DeleteMapping("user/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable("id") int id){
         userService.deleteUser(id);
         return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
     }


}
