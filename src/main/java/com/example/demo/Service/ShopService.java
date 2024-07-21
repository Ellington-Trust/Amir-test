package com.example.demo.Service;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    final UserRepository users;

    public ShopService(UserRepository users) {
        this.users = users;
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

    void printUserById(Integer id) {
        Optional<User> user = users.findById(id);
        if (user.isPresent())
            System.out.println("Your wanted User : " + user.get().toString());
        else
            System.out.println("Your wanted User not found");
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
}
