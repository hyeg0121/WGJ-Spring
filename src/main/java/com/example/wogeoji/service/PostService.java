package com.example.wogeoji.service;

import com.example.wogeoji.entity.Post;
import com.example.wogeoji.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 모든 게시글 조회
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    // pk로 게시글 조회
    public Optional<Post> findPostByNo(Long postNo) {
        return postRepository.findById(postNo);
    }

    // 게시글 추가
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    // 게시글 업데이트
    public Post updatePost(Long postNo, Post updatedPost) {
        Post existingPost = postRepository.findById(postNo).orElse(null);

        if (existingPost != null) {
            existingPost.setAmount(updatedPost.getAmount());
            existingPost.setItem(updatedPost.getItem());

            return postRepository.save(existingPost);
        }

        return null;
    }

    public void deletePost(Long postNo) {
        postRepository.deleteById(postNo);
    }
}
