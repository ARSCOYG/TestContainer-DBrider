package com.example.demo;


import com.example.demo.entity.CustomerInfo;
import com.example.demo.repository.CustomerRespository;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;

import com.github.database.rider.spring.api.DBRider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 这是针对Junit4的版本
 * 一定要加载@RunWith(SpringRunner.class)，否则@ActiveProfiles("integration-test")不会被执行
 *  */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
@DBRider //enables database rider in spring tests，一定要是Spring DBRider的仓库
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
public class MySQLDataSpringJunit4 {

    private static final MySQLContainer mysql = new MySQLContainer(); //creates the database for all tests on this file

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomerRespository customerRespository;


    @BeforeClass
    public static void setupContainer() {
        mysql.start();
    }

    @AfterClass
    public static void shutdown() {
        mysql.stop();
    }

    @Test
    @DataSet(value = "customer_info.yml", disableConstraints = true)
    public void shouldSeedCustomer() {

        assertThat(customerRespository).isNotNull();
        CustomerInfo customerInfo = customerRespository.findCustomerByCustomerId("1");
        assertThat(customerInfo).isNotNull();
        assertThat(customerInfo.getCustomerId()).isEqualTo("1");

    }
}


