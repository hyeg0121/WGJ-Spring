package com.example.wogeoji.controller;

import com.example.wogeoji.dto.room.AddRoomDto;
import com.example.wogeoji.dto.room.RoomResponseDto;
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
    public ResponseEntity<List<RoomResponseDto>> getAllRooms() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(roomService.findAllRooms());
    }

    // pk로 거지방 조회
    @GetMapping("/{roomId}")
    public ResponseEntity<RoomResponseDto> getRoomById(@PathVariable Long roomId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(roomService.findRoomById(roomId));
    }

    // 거지방 추가
    @PostMapping
    public ResponseEntity<RoomResponseDto> addRoom(@RequestBody AddRoomDto addRoomDto) {
        RoomResponseDto createdRoom = roomService.addRoom(addRoomDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdRoom);
    }
}
