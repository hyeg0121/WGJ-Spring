package com.example.wogeoji.controller;

import com.example.wogeoji.dto.user.LoginUserDto;
import com.example.wogeoji.dto.user.UserResponseDto;
import com.example.wogeoji.entity.Post;
import com.example.wogeoji.entity.User;
import com.example.wogeoji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUser());
    }

    // Pk로 유저 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(userId));
    }

    // 유저 추가
    @PostMapping
    public ResponseEntity<UserResponseDto> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.addUser(user));
    }

    // 유저 로그인
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginUserDto loginUserDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.login(loginUserDto));
    }

    // 유저가 작성한 글 조회
    @GetMapping("/{userId}/posts")
    public List<Post> getUsersPosts(@PathVariable Long userId) {
        return userService.getUserPosts(userId);
    }
}
