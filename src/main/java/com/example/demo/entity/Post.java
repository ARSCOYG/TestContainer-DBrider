package com.example.demo.entity;


import javax.persistence.*;


@Entity

@Table(name = "tb_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String remark;
}
