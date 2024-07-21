package com.example.demo.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    protected int id;
    protected String name;
    protected String email;

    public User(int _id, String _name , String _email) {
        this.id = _id;
        this.name = _name;
        this.email = _email;
    }
}
