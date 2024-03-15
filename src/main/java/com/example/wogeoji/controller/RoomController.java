package com.example.wogeoji.controller;

import com.example.wogeoji.dto.room.AddRoomDto;
import com.example.wogeoji.entity.Room;
import com.example.wogeoji.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // 모든 거지방 조회
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.findAllRooms();
    }

    // pk로 거지방 조회
    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long roomId) {
        Optional<Room> room = roomService.findRoomById(roomId);
        return room.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    // 거지방 추가
    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody AddRoomDto addRoomDto) {
        Room createdRoom = roomService.addRoom(addRoomDto);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }
}
