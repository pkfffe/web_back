package com.example.web_back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cuisine;
    private String protein;

    @Column(name = "dish_base")  // DB 컬럼명이 dish_base일 때 명시
    private String dishBase;
}
