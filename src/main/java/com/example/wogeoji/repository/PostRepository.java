package com.example.wogeoji.repository;

import com.example.wogeoji.entity.Post;
import com.example.wogeoji.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByIsDeletedEquals(Integer isDeleted);
    Optional<Post> findByIdAndIsDeleted(Long id, Integer isDeleted);
}

