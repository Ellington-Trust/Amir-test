package com.example.demo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity(name = "User")
public class User {
    @Id
    private Integer Uid;
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

    public User(Integer _id, String _firstName, String _lastName, Integer _age, String _email , String _address) {
        this.Uid = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
        this.email = _email;
        this.address = _address;
    }

    public User() {
    }

    @Override
    public String toString() {
        return Uid + " " + firstName + " " + lastName + " " + age + " " + email + " " + address;
    }
}
