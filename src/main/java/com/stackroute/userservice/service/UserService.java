package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;

    }
    public List<User>getAllUser() {

        List<User> getUser= (List)userRepository.findAll();
        return getUser;
    }
    public User getUserById(int id) {
        Optional<User> getId = userRepository.findById(id);
        return getId.get();

    }


     public void deleteUser(int  id) {
      userRepository.deleteById(id);

     }
     public User updateUser( User user,int id){

        User usertobeupdated=userRepository.findById(id).get();
        usertobeupdated.setAge(user.getAge());
        return userRepository.save(usertobeupdated);

     }

    }





