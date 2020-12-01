package com.example.demo.entity;


import javax.persistence.*;

/**
 * @author SRCB
 */

@Entity
@Table(name = "tb_user_post")
public class UserPost {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long postId;

    @Transient
    private String postName;


}
