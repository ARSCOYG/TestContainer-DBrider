package spock

import com.example.demo.entity.CustomerInfo
import com.example.demo.repository.CustomerRespository
import com.github.database.rider.core.api.configuration.DBUnit
import com.github.database.rider.core.api.configuration.Orthography
import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.spring.api.DBRider
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.MySQLContainer
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThat


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
@DBRider //enables database rider in spring tests，一定要是Spring DBRider的仓库
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
//@org.testcontainers.spock.Testcontainers
class SpockTestContainer extends Specification {

    private static final MySQLContainer mysql = new MySQLContainer();

    @Autowired
    private CustomerRespository customerRespository;

    def setupSpec(){
        mysql.start();
    }

    @DataSet(value = "customer_info.yml", disableConstraints = true)
    def shouldSeedCustomer(){
        expect:""
        println customerRespository
        customerRespository == null;


//        assertThat(customerRespository).isNotNull();
//        CustomerInfo customerInfo = customerRespository.findCustomerByCustomerId("1");
//        assertThat(customerInfo).isNotNull();
//        assertThat(customerInfo.getCustomerId()).isEqualTo("1");
    }
    def cleanupSpec(){
        mysql.stop();
    }



}
