package com.userservice.usercontroller;

import com.userservice.UserServiceApplication;
import com.userservice.usermodel.User;
import com.userservice.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id)
    {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Integer id)
    {
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id)
    {
        userService.deleteUserById(id);
    }

}
