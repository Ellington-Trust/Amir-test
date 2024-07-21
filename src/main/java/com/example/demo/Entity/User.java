package com.example.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user")
public class User {
    @Id
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer age;
    @Column
    private String email;
    @Column
    private String address;

    public User(Integer _id, String _firstName, String _lastName, Integer _age, String _email) {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
        this.email = _email;
    }

    public User() {
    }
}
