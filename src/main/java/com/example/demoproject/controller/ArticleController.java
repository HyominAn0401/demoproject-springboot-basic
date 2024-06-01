package com.example.demoproject.controller;

import com.example.demoproject.dto.ArticleForm;
import com.example.demoproject.entity.Article;
import com.example.demoproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "new";
    }

    @PostMapping("/articles/new/create")
    public String createArticle(ArticleForm form){
        //1. DTO -> Entity
        Article article = form.toEntity();
        System.out.println(article.toString());
        //2. Repository로 Entity를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println(form.toString());
//        return "";
        System.out.println(saved.toString());
        return "";
    }
}
