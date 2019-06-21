package com.kk.SpringBootBackendServices.service;


import com.kk.SpringBootBackendServices.model.User;
import com.kk.SpringBootBackendServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return (userRepository.findById(id).orElse(null));
    }

    public User createUser(User user){
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user){
        if(userRepository.findById(user.getId()) == null)
            return null;
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long id){
        userRepository.delete(userRepository.findById(id).orElse(null));
    }

}
