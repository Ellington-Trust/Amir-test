package com.example.demo.Controller;

import com.example.demo.Entity.Article;
import com.example.demo.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private final ShopService shopService;

    public ArticleController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody Article article) {
        try {
            shopService.addArticle(article.getArticleId(), article.getTitle(), article.getPrice() , article.getCompany() , article.getCount() ,article.getCategoryId());
            return new ResponseEntity<>("Article added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add Article: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findArticle(@PathVariable Integer id) {
        Optional<Article> found = shopService.findArticleById(id);
        if (found.isPresent()) {
            return new ResponseEntity<>("Article found " + found.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Article not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        try {
            shopService.deleteUserById(id);
            return new ResponseEntity<>("Article deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete Article: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
