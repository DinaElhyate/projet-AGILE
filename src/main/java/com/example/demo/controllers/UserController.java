package com.example.demo.controllers;

import com.example.demo.beans.User;
import com.example.demo.services.UserService;
import com.example.demo.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
      
    @Autowired
    private UserServiceImpl userServiceiImpl;

    @PostMapping("/add")
    public User create(@RequestBody User user) {
        return userServiceiImpl.create(user);
    }

    @PutMapping("/edit/{id}")
    public User update(@RequestBody User user,@PathVariable Long id) {
        return userServiceiImpl.update(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userServiceiImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id) {
        return  userServiceiImpl.get(id);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userServiceiImpl.getAll();
    }

    @GetMapping("/check/{email}/{password}")
    public String checkUser(@PathVariable String email, @PathVariable String password) {
        User user =  userServiceiImpl.findByEmailAndPassword(email, password);

        if (user != null) {
            return "User exists in the database.";
        } else {
            return "User does not exist in the database.";
        }
    }
}
