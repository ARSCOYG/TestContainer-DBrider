package com.example.demo.entity;


import javax.persistence.*;

/**
 * @author SRCB
 */

@Entity
@Table(name = "tb_user_role")
public class UserRole {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    private Long roleId;

    @Transient
    private String roleName;
}
