package com.example.wogeoji.service;

import com.example.wogeoji.dto.room.AddRoomDto;
import com.example.wogeoji.dto.room.RoomResponseDto;
import com.example.wogeoji.entity.Room;
import com.example.wogeoji.entity.User;
import com.example.wogeoji.entity.UserRoom;
import com.example.wogeoji.exception.RoomNotFoundException;
import com.example.wogeoji.exception.UserNotFoundException;
import com.example.wogeoji.repository.RoomRepository;
import com.example.wogeoji.repository.UserRepository;
import com.example.wogeoji.repository.UserRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final UserRoomRepository userRoomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, UserRepository userRepository, UserRoomRepository userRoomRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.userRoomRepository = userRoomRepository;
    }

    // 모든 거지방 조회
    public List<RoomResponseDto> findAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(RoomResponseDto::from)
                .collect(Collectors.toList());
    }

    // pk로 거지방 조회
    public RoomResponseDto findRoomById(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);

        return RoomResponseDto.from(room);
    }

    // 거지방 생성
    public RoomResponseDto addRoom(AddRoomDto addRoomDto) {
        User creator = userRepository.findById(addRoomDto.getCreatorId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);


        Room savedRoom = roomRepository.save(Room.builder()
                .name(addRoomDto.getName())
                .capacity(addRoomDto.getCapacity())
                .creator(creator)
                .description(addRoomDto.getDescription())
                .build());

        joinRoom(savedRoom);


        return RoomResponseDto.from(savedRoom);
    }

    // 가입하기
    public UserRoom joinRoom(Room room) {
        return userRoomRepository.save(UserRoom.builder()
                .user(room.getCreator())
                .room(room)
                .build());
    }

}
