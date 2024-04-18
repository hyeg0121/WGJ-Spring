package com.example.wogeoji.service;

import com.example.wogeoji.dto.post.PostResponseDto;
import com.example.wogeoji.dto.user.LoginUserDto;
import com.example.wogeoji.dto.user.UserResponseDto;
import com.example.wogeoji.entity.Post;
import com.example.wogeoji.entity.User;
import com.example.wogeoji.exception.DuplicateEmailException;
import com.example.wogeoji.exception.EmailNotFoundException;
import com.example.wogeoji.exception.IncorrectPasswordException;
import com.example.wogeoji.exception.UserNotFoundException;
import com.example.wogeoji.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    // 모든 유저 조회
    public List<UserResponseDto> findAllUser() {

        return userRepository.findByIsDeletedEquals(0)
                .stream()
                .filter(user -> 0 == user.getIsDeleted())
                .map(UserResponseDto::from)
                .collect(Collectors.toList());
    }

    // pk로 유저 조회
    public UserResponseDto findUserById(Long userId) {
        User user = userRepository.findByIdAndIsDeleted(userId, 0)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return UserResponseDto.from(user);
    }

    // 유저 생성
    public UserResponseDto addUser(User user) {
        // 이메일 중복 체크
        if (userRepository.existsByEmail(user.getEmail())) throw DuplicateEmailException.EXCEPTION;

        // 비밀번호 해싱
        String password = user.getPassword();
        String encodedPassword = encoder.encode(password);
        user.setPassword(encodedPassword);

        return UserResponseDto.from(userRepository.save(user));
    }

    // 유저 로그인
    public UserResponseDto login(LoginUserDto loginUserDto) {
        boolean isValid = false;
        User loggedUser = userRepository.findByEmail(loginUserDto.getEmail());

        if (loggedUser != null) isValid = BCrypt.checkpw(loginUserDto.getPassword(), loggedUser.getPassword());
        else throw EmailNotFoundException.EXCEPTION;


        if (isValid) return UserResponseDto.from(loggedUser);
        else throw IncorrectPasswordException.EXCEPTION;
    }

    // 유저의 posts 조회
    public List<PostResponseDto> getUserPosts(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);


        return user.getPosts().stream()
                .filter(post -> post.getIsDeleted() == 0)
                .map(PostResponseDto::from)
                .collect(Collectors.toList());
    }

    // 유저 삭제
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.delete();
    }


}
