package com.example.wogeoji.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
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
}
