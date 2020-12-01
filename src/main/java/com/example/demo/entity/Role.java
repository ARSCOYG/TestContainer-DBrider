package com.example.demo.entity;




import javax.persistence.*;


@Entity
@Table(name = "tb_role")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean defaultRole;


    private String description;

//    @Transient
//    @ApiModelProperty(value = "拥有权限")
//    private List<RolePermission> permissions;


}
