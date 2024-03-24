package com.example.wogeoji.service;

import com.example.wogeoji.dto.room.AddRoomDto;
import com.example.wogeoji.entity.Room;
import com.example.wogeoji.entity.User;
import com.example.wogeoji.exception.UserNotFoundException;
import com.example.wogeoji.repository.RoomRepository;
import com.example.wogeoji.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    // 모든 거지방 조회
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    // pk로 거지방 조회
    public Optional<Room> findRoomById(Long roomId) {
        return roomRepository.findById(roomId);
    }

    // 거지방 생성
    public Room addRoom(AddRoomDto addRoomDto) {
        User creator = userRepository.findById(addRoomDto.getCreatorId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);


        Room newRoom = Room.builder()
                .name(addRoomDto.getName())
                .capacity(addRoomDto.getCapacity())
                .creator(creator)
                .description(addRoomDto.getDescription())
                .build();

        return roomRepository.save(newRoom);
    }
}
