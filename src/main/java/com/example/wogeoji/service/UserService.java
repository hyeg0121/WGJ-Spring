package com.example.wogeoji.service;

import com.example.wogeoji.entity.User;
import com.example.wogeoji.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public User addUser(User user) {
        return userRepository.save(user);
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
