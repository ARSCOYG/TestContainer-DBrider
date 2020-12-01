package com.example.demo.entity;

import javax.persistence.*;



@Entity
@Table(name = "tb_role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roleId;

    private Long permissionId;
}
