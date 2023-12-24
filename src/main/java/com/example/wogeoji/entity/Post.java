package com.example.wogeoji.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
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

}
