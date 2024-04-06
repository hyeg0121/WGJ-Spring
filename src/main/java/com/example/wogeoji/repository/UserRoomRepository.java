package com.example.wogeoji.repository;

import com.example.wogeoji.entity.Room;
import com.example.wogeoji.entity.UserRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoomRepository extends JpaRepository<UserRoom, Long> {
    @Query("SELECT ur.room FROM UserRoom ur WHERE ur.user.id = :userId")
    List<Room> findRoomsByUserId(@Param("userId") Long userId);
}
