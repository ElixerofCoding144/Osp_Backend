package com.lowes3.osp.service;

import com.lowes3.osp.entity.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User saveUser(User user);
    public User getUserById(Integer userId);
    public User updateUser(User user);
    public String deleteUserById(Integer userId);
    public List<User> getUsers();


}
