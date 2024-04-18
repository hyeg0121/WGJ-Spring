package com.example.wogeoji.repository;

import com.example.wogeoji.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByIsDeletedEquals(Integer isDeleted);
    Optional<Room> findByIdAndIsDeleted(Long id, Integer isDeleted);
}

