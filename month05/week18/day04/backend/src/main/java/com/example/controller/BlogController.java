package com.example.controller;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Article;
import com.example.model.Author;
import com.example.service.BlogService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") 
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");
        String bio = body.get("bio");
        
        Author author = blogService.createAuthor(name, email, bio);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/articles/published")
    public ResponseEntity<List<Article>> getPublishedArticles() {
        List<Article> articles = blogService.getPublishedArticles();
        return ResponseEntity.ok(articles);
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Map<String, Object> body) {
        Long authorId = Long.valueOf(body.get("authorId").toString());
        String title = body.get("title").toString();
        String content = body.get("content").toString();

        Article article = blogService.createArticle(authorId, title, content);
        return ResponseEntity.ok(article);
    }
}
