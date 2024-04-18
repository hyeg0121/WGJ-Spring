package com.example.wogeoji.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String bio = "아직 목표가 없습니다.";

    private String profileImagePath = "/images/profile.png";

    private Integer spentAmount = 0;

    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    @Override
    public void delete() {
        this.isDeleted = 1;
    }
}
