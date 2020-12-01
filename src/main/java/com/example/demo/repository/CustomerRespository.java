package com.example.demo.repository;

import com.example.demo.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository  extends JpaRepository<CustomerInfo,String>{
    CustomerInfo findCustomerByCustomerId(String Id);

}
