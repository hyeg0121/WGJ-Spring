package com.example.wogeoji.controller;

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
    @GetMapping("/{roomNo}")
    public ResponseEntity<Room> getRoomByNo(@PathVariable Long roomNo) {
        Optional<Room> room = roomService.findRoomByNo(roomNo);
        return room.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    // 거지방 추가
    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        Room createdRoom = roomService.addRoom(room);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    // 거지방 업데이트
    @PutMapping("/{roomNo}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long roomNo, @RequestBody Room updatedRoom) {
        Room updatedRoomData = roomService.updateRoom(roomNo, updatedRoom);
        if (updatedRoomData != null) {
            return new ResponseEntity<>(updatedRoomData, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 거지방 삭제
    @DeleteMapping("/{roomNo}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomNo) {
        roomService.deleteRoom(roomNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
