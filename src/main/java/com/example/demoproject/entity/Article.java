package com.example.demoproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

    //생성자
    public Article(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    //toString 메소드
    @Override
    public String toString(){
        return "Article{" + "id="+id+", title='"+title+'\''+", content='"+content+'\''+'}';
    }
}
