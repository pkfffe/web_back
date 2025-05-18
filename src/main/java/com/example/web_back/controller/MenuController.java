package com.example.web_back.controller;

import com.example.web_back.dto.MenuRequest;
import com.example.web_back.dto.MenuResponse;
import com.example.web_back.model.Menu;
import com.example.web_back.service.MenuService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-menu")
public class MenuController {
    private final MenuService service;

    public MenuController(MenuService service) {
        this.service = service;
    }

    @PostMapping("/recommend")
    public MenuResponse recommend(@RequestBody MenuRequest request) {
        return service.recommend(request);
    }
    @PostMapping("/add")
    public Menu addMenu(@RequestBody MenuRequest request) {
        return service.save(request);
    }
}
