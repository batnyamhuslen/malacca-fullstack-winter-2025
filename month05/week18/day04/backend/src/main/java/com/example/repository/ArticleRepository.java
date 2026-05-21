package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
    List<Article> findByAuthorId(Long authorId);
    
    List<Article> findByPublishedTrue();

    List<Article> findByTagsName(String tagName);
}
