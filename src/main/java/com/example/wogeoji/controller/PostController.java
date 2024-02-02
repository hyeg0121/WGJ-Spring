package com.example.wogeoji.controller;

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
    public ResponseEntity<Post> addpost(@RequestBody Post post) {
        Post createdpost = postService.addPost(post);
        return new ResponseEntity<>(createdpost, HttpStatus.CREATED);
    }

    // 거지방 업데이트
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatepost(@PathVariable Long postId, @RequestBody Post updatedPost) {
        Post updatedPostData = postService.updatePost(postId, updatedPost);
        if (updatedPostData != null) {
            return new ResponseEntity<>(updatedPostData, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 거지방 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletepost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
