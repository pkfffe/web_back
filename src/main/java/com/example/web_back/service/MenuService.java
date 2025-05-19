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
        List<Menu> result = repository.findByMoodOrTimeOrLocationOrWeather(
                request.getMood(),
                request.getTime(),
                request.getLocation(),
                request.getWeather()
        );

        if (result.isEmpty()) {
            return new MenuResponse("추천할 메뉴가 없습니다. 김치찌개!");
        }

        Collections.shuffle(result);
        return new MenuResponse(result.get(0).getName());
    }

    public Menu save(MenuRequest request) {
        // DTO → Entity 수동 변환
        Menu menu = new Menu();
        menu.setMood(request.getMood());
        menu.setTime(request.getTime());
        menu.setLocation(request.getLocation());
        menu.setWeather(request.getWeather());

        return repository.save(menu); // 여기서 Menu 타입이므로 오류 없음
    }

    public void deleteMenu(Long id) {
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("해당하는 ID 없음!");
        }
        repository.deleteById(id);
    }
}

