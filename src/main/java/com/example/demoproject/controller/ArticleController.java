package com.example.demoproject.controller;

import com.example.demoproject.dto.ArticleForm;
import com.example.demoproject.entity.Article;
import com.example.demoproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/new/create")
    public String createArticle(ArticleForm form){

        log.info(form.toString());
        //1. DTO -> Entity
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());
        //2. Repository로 Entity를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(form.toString());
//        return "";
        //System.out.println(saved.toString());
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        //1. id를 조회해 DB에서 해당 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. model에 데이터 등록
        model.addAttribute("article", articleEntity);
        //3. view page 반환
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1. DB에서 모든 Article 데이터 가져오기
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        //2. 모델에 데이터 등록
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }
}
