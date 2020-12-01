package com.example.demo.entity.hero;

import javax.persistence.*;

@Entity
public class Hero {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    public Hero() {
    }

    public Hero(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
