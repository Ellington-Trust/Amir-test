package com.example.demo.Repository;

import com.example.demo.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByTitle(String title);
    List<Article> findByCategoryId(Integer categoryID);
    List<Article> findByCompany(String companyName);
}
