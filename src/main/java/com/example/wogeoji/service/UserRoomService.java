package com.example.wogeoji.service;

import com.example.wogeoji.dto.userroom.AddUserRoomDto;
import com.example.wogeoji.dto.userroom.UserRoomResponse;
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

@Service
public class UserRoomService {
    private final UserRoomRepository userRoomRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public UserRoomService(UserRoomRepository userRoomRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.userRoomRepository = userRoomRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    public UserRoomResponse joinRoom(AddUserRoomDto addUserRoomDto) {
        User user = userRepository.findById(addUserRoomDto.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Room room = roomRepository.findById(addUserRoomDto.getRoomId())
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);

        UserRoom savedUserRoom = userRoomRepository.save(UserRoom.builder()
                .user(user)
                .room(room)
                .build());

        return UserRoomResponse.from(savedUserRoom);
    }

}
