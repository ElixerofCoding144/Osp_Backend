package com.lowes3.osp.service;

import com.lowes3.osp.dao.UserRepository;
import com.lowes3.osp.entity.Survey;
import com.lowes3.osp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User User) {
        return userRepository.save(User);
    }

    @Override
    public User getUserById(Integer UserId) {
        Optional<User> User = userRepository.findById(UserId);
        if (User.isPresent()) return User.get();
        else return null;
    }

    @Override
    public User updateUser(User User) {
        if(userRepository.existsById(User.getUserId())) return userRepository.save(User);
        else return null;
    }

    @Override
    public String deleteUserById(Integer UserId) {
        Optional<User> User = userRepository.findById(UserId);
        if (User.isPresent()){
            userRepository.deleteById(UserId);
            return "Deleted the User.";
        }
        else return "Could not find User by Id.";
    }
    
    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}
