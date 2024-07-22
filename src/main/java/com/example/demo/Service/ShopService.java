package com.example.demo.Service;
import com.example.demo.Entity.Article;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ArticleRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Utils.UniqueNumberGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    final UserRepository users;
    final OrderRepository orders;
    final ArticleRepository articles;

    public ShopService(UserRepository users , OrderRepository orders , ArticleRepository articles) {
        this.users = users;
        this.orders = orders;
        this.articles = articles;
    }

    void clear()
    {
        users.deleteAll();
        orders.deleteAll();
        articles.deleteAll();
    }

    public Optional<User> findUserById(Integer id) {
        return users.findById(id);
    }

    public void addUser(Integer id, String fname, String lname, Integer age, String email , String address)
    {
        try{
            if(findUserById(id).isPresent())
                return;
            users.save(new User(id , fname , lname , age , email , address));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addArticle(Integer articleId, String title, Integer price, String company, Integer count, Integer categoryId)
    {
        try{
            if(findArticleById(articleId).isPresent())
                return;
            articles.save(new Article(articleId , title ,price , company , count , categoryId));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteUserById(Integer id) {
        users.deleteById(id);
    }

    public void deleteOrderById(String id) {
        orders.deleteById(id);
    }

    public void findUserByFirstName(String FirstName)
    {
        List<User> usersList = users.findByFirstName(FirstName);
        if(!usersList.isEmpty())
            for(User user : usersList)
                System.out.println("User : " + user.toString());
        else
            System.out.println("Your wanted User not found");
    }


    public Optional<Article> findArticleById(Integer id) {
        return articles.findById(id);
    }

    public Optional<Order> findOrderById(String id) {
        return orders.findById(id);
    }

    void deleteArticleById(Integer id) {
        articles.deleteById(id);
    }

    void findArticleByTitle(String title)
    {
        List<Article> articleList = articles.findByTitle(title);
        if(!articleList.isEmpty())
            for(Article article : articleList)
                System.out.println("Article : " + article.toString());
        else
            System.out.println("Your wanted article not found");
    }

    void findUserOrdersById(Integer userId) {
        List<Order> ordersList = orders.findByCustomerId(userId);
        if(!ordersList.isEmpty())
            for(Order order : ordersList)
                System.out.println("order : " + order.toString());
        else
            System.out.println("This user doesn't have any order");
    }

    @Transactional
    public void createOrder(Integer userId, Integer articleId, Integer count)
    {
        if(findArticleById(articleId).isPresent() && findUserById(userId).isPresent())
            orders.save(new Order(UniqueNumberGenerator.generateUUIDString() , userId , articleId , count));
        else
            System.out.println("Invalid IDs!!");
    }
}
