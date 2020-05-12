package com.wmm.springbootdemo.controller;

import com.wmm.springbootdemo.domain.User;
import com.wmm.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangmingming160328
 * @Description 用户控制器
 * @date @2020/5/7 17:28
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    private List<User> userList = new ArrayList<>();

    @GetMapping("/v1/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/v1/users/{name}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String name) {
        List<User> users = userList.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping("/v1/users")
    public ResponseEntity<List<User>> addUser(@RequestBody User user) {
        userList.add(user);
        return ResponseEntity.ok(userList);
    }

    @DeleteMapping("/v1/users/{id}")
    public ResponseEntity<List<User>> deleteUserById(@PathVariable("id") int id) {
        userList.remove(id);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/v2/users")
    public List<User> testQuery() {
        return userService.selectUserByName("Daisy");
    }

    @PostMapping("/v2/users")
    public List<User> testInsert() {
        userService.insertService();
        return userService.selectAllUser();
    }


    @PutMapping("/v1/users")
    public List<User> testchangemoney() {
        userService.changemoney();
        return userService.selectAllUser();
    }

    @DeleteMapping("/v2/users/{id}")
    public String testDelete(@PathVariable long id) {
        userService.deleteService(id);
        return "OK";
    }
}
