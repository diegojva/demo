package com.mybatis.springboot.resource;

import com.mybatis.springboot.mapper.UserMapper;
import com.mybatis.springboot.model.Product;
import com.mybatis.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersResource {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    @GetMapping("/update")
    public void updateUser() {
        User user = new User();
        user.setName("John");
        user.setSalary(10000L);

        userMapper.insert(user);
    }

    @PostMapping
    public void insertUser(@RequestBody User user) {
        userMapper.insert(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        User userFound = userMapper.findById(user.getId());

        userFound.setName(user.getName());
        userFound.setSalary(user.getSalary());

        userMapper.update(userFound);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userMapper.delete(id);
    }


    @GetMapping("/example")
    public void exampleEndpoint() {
        List<User> users = userMapper.findAll();
        users.stream().map(upper -> upper.getName().toUpperCase());
    }
}
