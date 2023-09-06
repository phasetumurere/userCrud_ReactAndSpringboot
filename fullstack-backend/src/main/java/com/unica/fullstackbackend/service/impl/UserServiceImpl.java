package com.unica.fullstackbackend.service.impl;

import com.unica.fullstackbackend.exception.UserNotFoundException;
import com.unica.fullstackbackend.model.User;
import com.unica.fullstackbackend.repository.UserRepository;
import com.unica.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public User saveUser(User user) {

        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        User updatedUser = repository.findTheUserById(user.getId());
        System.out.println(updatedUser);
        updatedUser.setEmail(user.getEmail());
        updatedUser.setName(user.getName());
        updatedUser.setUsername(user.getUsername());
        return repository.save(updatedUser);
    }

    @Override
    public String deleteUser(Long id) {
        if(!repository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        repository.deleteById(id);
        return "user with id "+id+" Deleted Successfully";
    }
}
