package Pegas;


import Pegas.config.DatabaseProperties;
import Pegas.service.CompanyService;
import Pegas.service.PaymentService;
import Pegas.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.SpringProperties;

import java.sql.SQLException;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) throws SQLException, InterruptedException {
        var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(SpringProperties.getProperty("test.msg"));
        System.out.println(context.getBean("connectionPool"));
        System.out.println(context.getBean(DatabaseProperties.class));
    }
}
