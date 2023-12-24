package com.example.wogeoji.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", updatable = false)
    private Long no;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    private String bio;

    @Column(name = "spent_amount")
    private Integer spentAmount;

    @CreatedDate
    @Column(name = "join_date")
    private LocalDateTime joinDate;


}
