package com.example.service;


import java.util.List;
import java.util.Optional;

import org.springframework.core.metrics.StartupStep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Article;
import com.example.model.Author;
import com.example.model.Comment;
import com.example.model.Tag;
import com.example.repository.ArticleRepository;
import com.example.repository.AuthorRepository;
import com.example.repository.CommentRepository;
import com.example.repository.TagRepository;

@Service
@Transactional
public class BlogService {

    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;


    public BlogService(AuthorRepository authorRepository, ArticleRepository articleRepository,
                       CommentRepository commentRepository, TagRepository tagRepository) {
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.tagRepository = tagRepository;
    }


    public Author createAuthor(String name, String email, String bio) {

        if (authorRepository.existsByEmail(email)) {
            throw new RuntimeException("Энэ имэйл хаягтай зохиолч аль хэдийн бүртгэгдсэн байна!");
        }
        
        Author author = new Author(name, email);
        author.setBio(bio);
        
        return authorRepository.save(author);
    }


    public Article createArticle(Long authorId, String title, String content) {

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Зохиолч олдсонгүй! ID: " + authorId));

        Article article = new Article(title, content);
        

        author.addArticle(article); 

        return articleRepository.save(article);
    }


    public Comment addComment(Long articleId, String content, String authorName) {

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Нийтлэл олдсонгүй! ID: " + articleId));

        Comment comment = new Comment(content, authorName);
        comment.setArticle(article);
        

        article.getComments().add((javax.xml.stream.events.Comment) comment); 

        return commentRepository.save(comment);
    }


    public void addTagToArticle(Long articleId, String tagName) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Нийтлэл олдсонгүй! ID: " + articleId));

        Optional<Tag> tagOptional = tagRepository.findByName(tagName);
        Tag tag;
        
        if (tagOptional.isPresent()) {
            tag = tagOptional.get();
        } else {
            tag = new Tag(tagName);
            tag = tagRepository.save(tag);
        }

        article.getTags().add((StartupStep.Tag) tag);
        tag.getArticles().add(article); 
        
        articleRepository.save(article);
    }

    public List<Article> getPublishedArticles() {
        return articleRepository.findByPublishedTrue();
    }

    public List<Article> getArticlesByTag(String tagName) {
        return articleRepository.findByTagsName(tagName);
    }
}
