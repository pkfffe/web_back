package com.example.web_back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 모든 API 경로 허용
                        .allowedOrigins("*") // 모든 도메인 허용 (개발용)
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드
                        .allowedHeaders("*");
            }
        };
    }
}

