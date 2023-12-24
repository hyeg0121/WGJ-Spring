package com.example.wogeoji.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
@EntityListeners(AuditingEntityListener.class)
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no", updatable = false)
    private Long no;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String item;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_no", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "room_no")
    private Room room;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
