package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ShopService shopService;

    @Autowired
    public UserController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            shopService.addUser(user.getUid(), user.getFirstName(), user.getLastName(), user.getAge(), user.getEmail() , user.getAddress());
            return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findUser(@PathVariable Integer id) {
        Optional<User> found = shopService.findUserById(id);
        if (found.isPresent()) {
            return new ResponseEntity<>("User found " + found.get() , HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        try {
            shopService.deleteUserById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<String> findUserByFirstName(@RequestParam String firstName) {
        shopService.findUserByFirstName(firstName);
        return new ResponseEntity<>("Search completed", HttpStatus.OK);
    }
}