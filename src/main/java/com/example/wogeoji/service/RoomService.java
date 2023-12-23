package com.example.wogeoji.service;

import com.example.wogeoji.entity.Room;
import com.example.wogeoji.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // 모든 거지방 조회
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    // pk로 거지방 조회
    public Room findRoomByNo(Long roomNo) {
        return roomRepository.findById(roomNo).orElse(null);
    }

    // 거지방 생성
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    // 거지방 업데이트
    public Room updateRoom(Long roomNo, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(roomNo).orElse(null);

        if (existingRoom != null) {
            existingRoom.setName(updatedRoom.getName());
            existingRoom.setDescription(updatedRoom.getDescription());
            existingRoom.setCapacity(updatedRoom.getCapacity());


            return roomRepository.save(existingRoom);
        }

        return null;
    }

    public void deleteRoom(Long roomNo) {
        roomRepository.deleteById(roomNo);
    }
}
