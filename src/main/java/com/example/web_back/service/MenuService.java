package com.example.web_back.service;

import com.example.web_back.dto.MenuRequest;
import com.example.web_back.dto.MenuResponse;
import com.example.web_back.model.Menu;
import com.example.web_back.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MenuService {
    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public MenuResponse recommend(MenuRequest request) {
        List<Menu> result = repository.findByOptionalFilters(
                request.getCuisine(),
                request.getProtein(),
                request.getDishBase()
        );

        if (result.isEmpty()) {
            return new MenuResponse("추천할 메뉴가 없습니다.");
        }

        Collections.shuffle(result);
        return new MenuResponse(result.get(0).getName());
    }

    public Menu save(MenuRequest request) {
        Menu menu = new Menu();
        menu.setId(request.getId());
        menu.setName(request.getName());
        menu.setCuisine(request.getCuisine());
        menu.setProtein(request.getProtein());
        menu.setDishBase(request.getDishBase());
        return repository.save(menu);
    }

    public void deleteMenu(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("해당하는 ID 없음!");
        }
        repository.deleteById(id);
    }
}


