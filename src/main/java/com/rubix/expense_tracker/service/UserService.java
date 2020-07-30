package com.rubix.expense_tracker.service;


import com.rubix.expense_tracker.model.*;
import com.rubix.expense_tracker.repository.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepo;
    private UserTypeRepository typerepo;

    public UserService(UserRepository userRepo,  UserTypeRepository typerepo) {
        this.userRepo = userRepo;
        this.typerepo = typerepo;
    }
    /** Create a new User */
    public ResponseEntity<Object> createUser(User model) {
        User user = new User();
        if (userRepo.findByEmail(model.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
        } else {
        	 user.setId(user.getId());
            user.setFirstname(model.getFirstname());
            user.setLastname(model.getLastname());
            user.setMobile(model.getMobile());
            user.setEmail(model.getEmail());
            user.setStatus(model.getStatus());
            user.setUsertype(model.getUsertype());

            User savedUser = userRepo.save(user);
            if (userRepo.findById(savedUser.getId()).isPresent())
                return ResponseEntity.ok("User Created Successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
        }
    }

    /** Update an Existing User */
    @Transactional
    public ResponseEntity<Object> updateUser(User user, int  id) {
        if(userRepo.findById(id).isPresent()) {
            User newUser = userRepo.findById(id).get();
         
            newUser.setFirstname(user.getFirstname());
            newUser.setLastname(user.getLastname());
            newUser.setMobile(user.getMobile());
            newUser.setEmail(user.getEmail());
            newUser.setStatus(user.getStatus());
            newUser.setUsertype(user.getUsertype());
            User savedUser = userRepo.save(newUser);
            if(userRepo.findById(savedUser.getId()).isPresent())
                return  ResponseEntity.accepted().body("User updated successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed updating the user specified");
        } else return ResponseEntity.unprocessableEntity().body("Cannot find the user specified");
    }
    /** Delete an User*/
    public ResponseEntity<Object> deleteUser(int id) {
        if (userRepo.findById(id).isPresent()) {
        	userRepo.deleteById(id);
            if (userRepo.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified User");
            else return ResponseEntity.ok().body("Successfully deleted the specified user");
        } else return ResponseEntity.badRequest().body("Cannot find the user specified");
    }

    public UserModel getUser(int id) {
        if(userRepo.findById(id).isPresent()) {
            User user = userRepo.findById(id).get();
            UserModel userModel = new UserModel();
            userModel.setId(user.getId());
            userModel.setFirstname(user.getFirstname());
            userModel.setLastname(user.getLastname());
            userModel.setEmail(user.getEmail());
            userModel.setMobile(user.getMobile());
            userModel.setStatus(user.getStatus());
            userModel.setUsertype(getUsertypeList(user));
            
            return userModel;
        } else return null;
    }
    public List<UserModel > getUsers() {
        List<User> userList = userRepo.findAll();
        if(userList.size()>0) {
            List<UserModel> userModels = new ArrayList<>();
            for (User user : userList) {
                UserModel model = new UserModel();
                model.setId(user.getId());
                model.setFirstname(user.getFirstname());
                model.setLastname(user.getLastname());
                model.setMobile(user.getMobile());
                model.setEmail(user.getEmail());
                model.setStatus(user.getStatus());
                model.setUsertype(getUsertypeList(user));
                userModels.add(model);
            }
            return userModels;
        } else return new ArrayList<UserModel>();
    }
    private List<UserTypeModel> getUsertypeList(User user){
        List<UserTypeModel> typeList = new ArrayList<>();
        for(int i=0; i< user.getUsertype().size(); i++) {
        	UserTypeModel typeModel = new UserTypeModel();
            typeModel.setName(user.getUsertype().get(i).getName());
           
            typeList.add(typeModel);
        }
        return typeList;
    }
}







