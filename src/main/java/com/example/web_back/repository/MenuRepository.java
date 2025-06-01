package com.example.web_back.repository;

import com.example.web_back.dto.MenuRequest;
import com.example.web_back.dto.MenuResponse;
import com.example.web_back.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("SELECT m FROM Menu m WHERE " +
            "(:cuisine IS NULL OR m.cuisine = :cuisine) AND " +
            "(:protein IS NULL OR m.protein = :protein) AND " +
            "(:dishBase IS NULL OR m.dishBase = :dishBase)")

    List<Menu> findByOptionalFilters(@Param("cuisine") String cuisine,
                                     @Param("protein") String protein,
                                     @Param("dishBase") String dishBase);
}
