package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Article")
public class Article {
    @Id
    Integer articleId;
    @Column
    String title;
    @Column
    Integer price;
    @Column
    String company;
    @Column
    Integer count;
    @Column
    Integer categoryId;

    public Article(Integer articleId, String title, Integer price, String company, Integer count, Integer CategoryId)
    {
        this.articleId = articleId;
        this.title = title;
        this.price = price;
        this.company = company;
        this.count = count;
        this.categoryId = CategoryId;
    }
    public Article(){
    }
}
