package com.example.wogeoji.service;

import com.example.wogeoji.dto.post.AddPostDto;
import com.example.wogeoji.dto.post.PostResponseDto;
import com.example.wogeoji.entity.Post;
import com.example.wogeoji.entity.Room;
import com.example.wogeoji.entity.User;
import com.example.wogeoji.exception.PostNotFoundException;
import com.example.wogeoji.exception.RoomNotFoundException;
import com.example.wogeoji.exception.UserNotFoundException;
import com.example.wogeoji.repository.PostRepository;
import com.example.wogeoji.repository.RoomRepository;
import com.example.wogeoji.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    // 모든 게시글 조회
    public List<PostResponseDto> findAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponseDto::from)
                .collect(Collectors.toList());
    }

    // pk로 게시글 조회
    public PostResponseDto findPostById(Long postId) {
        // TODO: POSTNOTFOUNDEXCEPTION 만들기
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        return PostResponseDto.from(post);
    }

    // 게시글 추가
    public PostResponseDto addPost(AddPostDto addPostDto) {
        Room room = roomRepository.findById(addPostDto.getRoomId())
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);

        User user = userRepository.findById(addPostDto.getAuthorId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Post post = Post.builder()
                .amount(addPostDto.getAmount())
                .author(user)
                .room(room)
                .item(addPostDto.getItem())
                .content(addPostDto.getContent())
                .build();

        Post savedPost = postRepository.save(post);

        return PostResponseDto.from(savedPost);
    }


    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
