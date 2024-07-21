package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User , Integer> {
    List<User> findByFirstName(String firstName);
    List<User> findByEmail(String email);
    List<User> findByLastName(String lastName);
}
