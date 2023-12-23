package com.example.wogeoji.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "user_room",
            joinColumns = @JoinColumn(name = "room_no"),
            inverseJoinColumns = @JoinColumn(name = "user_no")
    )
    private Set<User> participants = new HashSet<>();
}
