package com.unica.fullstackbackend.service;

import com.unica.fullstackbackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveUser(User user);
    public List<User>getAllUsers();
    public Optional<User> getUserById(Long id);

    public User updateUser(User user);

    public String deleteUser(Long id);
}
