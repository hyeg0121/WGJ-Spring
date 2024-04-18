package com.example.wogeoji.repository;

import com.example.wogeoji.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findByIsDeletedEquals(Integer isDeleted);
    Optional<User> findByIdAndIsDeleted(Long id, Integer isDeleted);
    boolean existsByEmail(String email);
}
