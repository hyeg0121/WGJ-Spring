package com.example.wogeoji.controller;

import com.example.wogeoji.dto.post.AddPostDto;
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
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 모든 거지방 조회
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAllPosts();
    }

    // pk로 거지방 조회
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getpostById(@PathVariable Long postId) {
        Optional<Post> post = postService.findPostById(postId);
        return post.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    // 거지방 추가
    @PostMapping
    public ResponseEntity<Post> addpost(@RequestBody AddPostDto addPostDto) {
        Post createdpost = postService.addPost(addPostDto);
        return new ResponseEntity<>(createdpost, HttpStatus.CREATED);
    }
}
