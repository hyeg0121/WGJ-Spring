package com.example.wogeoji.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_no", updatable = false)
    private Long no;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "creator_no", nullable = false)
    private User creator;

    private String description;

    private Integer capacity;
}
