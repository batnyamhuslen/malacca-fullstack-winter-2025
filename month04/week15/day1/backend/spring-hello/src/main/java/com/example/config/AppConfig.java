package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration                              // Config class гэдгийг зарлах
@ComponentScan("com.example")               // энэ package-д Bean хайна
public class AppConfig {
    // Хоосон байж болно — @ComponentScan бүгдийг хайна
}
