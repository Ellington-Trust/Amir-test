package com.example.demo.database;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Table {
    protected int id;
    protected String name;

    public Table(int _id, String _name) {
        id = _id;
        name = _name;
    }
}
