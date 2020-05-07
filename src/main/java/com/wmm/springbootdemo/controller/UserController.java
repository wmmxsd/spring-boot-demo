package com.wmm.springbootdemo.controller;

import com.wmm.springbootdemo.domain.User;
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
@RequestMapping("/api/v1")
public class UserController {
    private List<User> userList = new ArrayList<>();

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/users/{name}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String name) {
        List<User> users = userList.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public ResponseEntity<List<User>> addUser(@RequestBody User user) {
        userList.add(user);
        return ResponseEntity.ok(userList);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<List<User>> deleteUserById(@PathVariable("id") int id) {
        userList.remove(id);
        return ResponseEntity.ok(userList);
    }
}
