package com.example.web_back.repository;

import com.example.web_back.dto.MenuRequest;
import com.example.web_back.dto.MenuResponse;
import com.example.web_back.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMoodOrTimeOrLocationOrWeather(String mood, String time, String location, String weather);

}
