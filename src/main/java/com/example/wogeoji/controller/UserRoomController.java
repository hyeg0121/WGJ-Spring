package com.example.wogeoji.controller;

import com.example.wogeoji.dto.userroom.AddUserRoomDto;
import com.example.wogeoji.dto.userroom.UserRoomResponse;
import com.example.wogeoji.service.UserRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-rooms")
public class UserRoomController {

    private final UserRoomService userRoomService;

    @Autowired
    public UserRoomController(UserRoomService userRoomService) {
        this.userRoomService = userRoomService;
    }

    @PostMapping
    public ResponseEntity<UserRoomResponse> joinRoom(@RequestBody AddUserRoomDto addUserRoomDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userRoomService.joinRoom(addUserRoomDto));
    }
}
