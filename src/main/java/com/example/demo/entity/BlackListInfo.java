package com.example.demo.entity;



import javax.persistence.*;


@Entity
@Table(name = "BLACKLIST_INFO")
public class BlackListInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "CUSTOMER_ID")
    private String customerId;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Column(name = "CERTIFICATE_TYPE_CD")
    private String certificateTypeCd;
    @Column(name = "CERTIFICATE_NUM")
    private String certificateNum;


    public BlackListInfo(){}

    @Override
    public String toString() {
        return "BlackListInfo{" +
                "ID=" + id +
                "CUSTOMER_ID=" + customerId +
                ", CUSTOMER_NAME='" + customerName + '\'' +
                ", CERTIFICATE_TYPE_CD='" + certificateTypeCd + '\'' +
                ", CERTIFICATE_NUM='" + certificateNum + '\'' +
                '}';
    }

}
