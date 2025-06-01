package com.example.web_back.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MenuRequest {
    private Long id;
    private String name;
    private String cuisine;
    private String protein;
    private String dishBase;

    public MenuRequest(MenuRequest menu) {
        this.id = menu.id;
        this.name = menu.name;
        this.cuisine = menu.cuisine;
        this.protein= menu.protein;
        this.dishBase = menu.dishBase;
    }
}
