package com.example.wogeoji.controller;

import com.example.wogeoji.entity.User;
import com.example.wogeoji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 모든 유저 조회
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUser();
    }

    // Pk로 유저 조회
    @GetMapping("/{userNo}")
    public ResponseEntity<User> getUserByNo(@PathVariable Long userNo) {
        Optional<User> user = userService.findUserByNo(userNo);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    // 유저 추가
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // 유저 업데이트
    @PutMapping("/{userNo}")
    public ResponseEntity<User> updateUser(@PathVariable Long userNo, @RequestBody User updatedUser) {
        User updatedUserData = userService.updateUser(userNo, updatedUser);
        if (updatedUserData != null) {
            return new ResponseEntity<>(updatedUserData, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 유저 삭제
    @DeleteMapping("/{userNo}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userNo) {
        userService.deleteUser(userNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
