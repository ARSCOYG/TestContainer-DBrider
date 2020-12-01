package com.example.demo;
import com.example.demo.entity.CustomerInfo;
import com.example.demo.repository.CustomerRespository;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
@DBRider //enables database rider in spring tests，一定要是Spring DBRider的仓库
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
public class MySQLDataSpringJunit5 {

    private static final MySQLContainer mysql = new MySQLContainer(); //creates the database for all tests on this file

    @Autowired
    private CustomerRespository customerRespository;

    @BeforeEach
    public void setupContainer() {
        mysql.start();
    }

    @AfterEach
    public void shutdown() {
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

    @Test
    @DataSet(value = "customer_info.yml", disableConstraints = true)
    @ExpectedDataSet(value = "customer_info.yml")
    public void expectSeedCustomer() {
        // do nothing
    }
}
