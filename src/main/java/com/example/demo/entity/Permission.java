package com.example.demo.entity;



import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tb_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final long serialVersionUID = 1L;


    private String name;



    private Integer level;




    private String title;


    private String path;


    private String component;


    private String parentId;

    @Transient
    private List<Permission> children;

    @Transient
    private List<String> permTypes;

}
