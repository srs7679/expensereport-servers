package com.rubix.expense_tracker.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Set;
//import java.util.Set;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rubix.expense_tracker.model.User;
import com.rubix.expense_tracker.model.UserType;
import com.rubix.expense_tracker.model.UserModel;
import com.rubix.expense_tracker.model.UserTypeModel;
import com.rubix.expense_tracker.repository.UserRepository;
import com.rubix.expense_tracker.repository.UserTypeRepository;
import com.rubix.expense_tracker.service.UserService;




/*
 *  The UserController throws the response whenever the service is called from frontEnd
 *  @CrossOrigin is used to link with the frontEnd URL
 *  @RequestMapping is used to map the backEnd to the frontEnd */





@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
public class UserController  {
	
	private UserService userService;
    private UserRepository userRepository;
    
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
   
    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("/user/{id}")
    public UserModel getUser(@PathVariable int id) {
        return userService.getUser(id);
    }
    @GetMapping("/user")
    public List<UserModel> getUser() {
        return userService.getUsers();

    }
    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int  id) {
        return userService.deleteUser(id);
    }
    
  
    
}