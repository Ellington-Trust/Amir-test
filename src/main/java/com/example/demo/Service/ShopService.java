package com.example.demo.Service;
import com.example.demo.Entity.Article;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ArticleRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Utils.UniqueNumberGenerator;
import org.springframework.stereotype.Service;
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
    }

    void addUser(Integer id , String fname , String lname , Integer age , String email)
    {
        try{
            users.save(new User(id , fname , lname , age , email));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    boolean findUserById(Integer id) {
        Optional<User> user = users.findById(id);
        if (user.isPresent())
        {
            System.out.println("Your wanted User : " + user.get().toString());
            return true;
        }
        else
        {
            System.out.println("Your wanted User not found");
            return false;
        }
    }

    void deleteUserById(Integer id) {
        users.deleteById(id);
    }

    void findUserByFirstName(String FirstName)
    {
        List<User> usersList = users.findByFirstName(FirstName);
        if(!usersList.isEmpty())
            for(User user : usersList)
                System.out.println("User : " + user.toString());
        else
            System.out.println("Your wanted User not found");
    }

    void addArticle(Integer articleId, String title, Integer price, String company, Integer count, Integer CategoryId)
    {
        try{
            articles.save(new Article(articleId, title, price, company, count, CategoryId));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    boolean findArticleById(Integer id) {
        Optional<Article> article = articles.findById(id);
        if (article.isPresent()) {
            System.out.println("Your wanted article : " + article.get().toString());
            return true;
        }
        else
        {
            System.out.println("Your wanted article not found");
            return false;
        }
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

    void CreateOrder(Integer userId , Integer articleId , Integer count)
    {
        if(findArticleById( articleId ) && findUserById(userId))
        {
            orders.save(new Order(UniqueNumberGenerator.generateUUIDString() , userId , articleId , count));
        }
        else {
            System.out.println("Invalid IDs!!");
        }
    }
}
