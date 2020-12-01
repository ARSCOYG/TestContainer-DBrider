package com.example.demo;


import com.example.demo.entity.CustomerInfo;
import com.example.demo.entity.Tweet;
import com.example.demo.repository.CustomerRespository;
import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.util.EntityManagerProvider;
import com.github.database.rider.spring.api.DBRider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.MySQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DBRider //enables database rider in spring tests，一定要是Spring DBRider的仓库
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
public class MySQLDatabaseIt {
    private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:5.6")
            .withUsername("test").withPassword("test");

    @Rule
    public EntityManagerProvider emProvider = EntityManagerProvider.instance("mysql-it");

    @Rule
    public DBUnitRule dbUnitRule = DBUnitRule.instance(emProvider.connection());
/*
    @PersistenceContext
    private EntityManager entityManager;*/

    @Autowired
    public CustomerRespository customerRespository;

    @BeforeClass
    public static void setupContainer() {
        mysql.start();
    }

    @AfterClass
    public static void shutdown() {
        mysql.stop();
    }

    @Test
    @DataSet(value = "datasets/tweet.yml", disableConstraints = true)
    public void shouldSeedDataSetDisablingConstraints() {
        Tweet tweet = EntityManagerProvider.em().createQuery("select t from Tweet t where t.id = 'abcdef12345'", Tweet.class).getSingleResult();
        assertThat(tweet).isNotNull();
        assertThat(tweet.getContent()).isEqualTo("dbunit rules again!");
    }

    @Test
    @DataSet(value = "datasets/customer_info.yml", disableConstraints = true)
    public void shouldSeedCustomer() {
 /*       JpaRepositoryFactory jpaRepositoryFactory = new JpaRepositoryFactory(entityManager);

        customerRespository = jpaRepositoryFactory.getRepository(CustomerRespository.class);
*/
        assertThat(customerRespository).isNotNull();
        CustomerInfo tweet = customerRespository.findCustomerByCustomerId("1");
        assertThat(tweet).isNotNull();

    }


}
