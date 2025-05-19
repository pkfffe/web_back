package com.example.web_back.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MenuRequest {
    private Long id;
    private String mood;
    private String time;
    private String location;
    private String weather;

    public MenuRequest(MenuRequest menu) {
        this.id = menu.getId();
        this.mood = menu.mood;
        this.time = menu.time;
        this.location = menu.location;
        this.weather = menu.weather;
    }
}
