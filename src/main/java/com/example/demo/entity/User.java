package com.example.demo.entity;



import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String workingnum;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @Transient
    private List<Role> roles;

    @Transient
    private Post post;
}
