package com.example.wogeoji.controller;

import com.example.wogeoji.dto.post.AddPostDto;
import com.example.wogeoji.dto.post.PostResponseDto;
import com.example.wogeoji.entity.Post;
import com.example.wogeoji.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 모든 거지방 조회
    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.findAllPosts());
    }

    // pk로 거지방 조회
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getpostById(@PathVariable Long postId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.findPostById(postId));
    }

    // 거지방 추가
    @PostMapping
    public ResponseEntity<PostResponseDto> addpost(@RequestBody AddPostDto addPostDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postService.addPost(addPostDto));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
