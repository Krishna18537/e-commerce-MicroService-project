package com.userservice.userservice;

import com.userservice.usermodel.User;
import com.userservice.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User user, Integer id) {
        User user1=getUserById(id);

        user1.setEmail(user.getEmail());
        user1.setMobile(user.getMobile());
        user1.setName(user.getName());

        return userRepository.save(user1);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
