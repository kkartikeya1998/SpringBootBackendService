package com.kk.SpringBootBackendServices.service;


import com.kk.SpringBootBackendServices.model.User;
import com.kk.SpringBootBackendServices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j              //Simple Logging Framework
public class UseService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            log.debug("User with id {} is {}", id, optionalUser.get());
        } else {
            throw new IllegalIdentifierException("Id not found!");
        }
        return optionalUser.get();
        // Same as return optionalUser.orElse(null);
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user) {
        if (userRepository.findById(user.getId()) == null)
            return null;
        userRepository.save(user);
        return user;
    }

    public User deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return user;
    }

}
