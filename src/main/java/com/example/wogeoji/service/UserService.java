package com.example.wogeoji.service;

import com.example.wogeoji.entity.User;
import com.example.wogeoji.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    // 모든 유저 조회
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    // pk로 유저 조회
    public Optional<User> findUserById(Long Id) {
        return userRepository.findById(Id);
    }

    // 유저 생성
    @Transactional
    public User addUser(User user) {
        // 비밀번호 해시
        String password = user.getPassword();
        String encodedPassword = encoder.encode(password);
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    // 유저 로그인
    public User login(User user) {
        boolean isValid = false;
        User loggedUser = userRepository.findByEmail(user.getEmail());
        if (loggedUser != null) {
            isValid = BCrypt.checkpw(user.getPassword(), loggedUser.getPassword());
        }

        if (isValid) {
            return loggedUser;
        }

        return null;
    }

    // 유저 업데이트
    public User updateUser(Long userId, User updateUser) {
        Optional<User> existingUserOptional = userRepository.findById(userId);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(updateUser.getName());
            existingUser.setBio(updateUser.getBio());
            existingUser.setPassword(updateUser.getPassword());

            return userRepository.save(existingUser);
        }

        return null;
    }

    // 유저 삭제
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
