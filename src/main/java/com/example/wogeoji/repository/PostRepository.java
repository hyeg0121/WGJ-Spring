package com.example.wogeoji.repository;

import com.example.wogeoji.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
