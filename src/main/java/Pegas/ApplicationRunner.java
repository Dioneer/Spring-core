package Pegas;


import Pegas.config.DatabaseProperties;
import Pegas.dao.CompanyRepository;
import Pegas.dao.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.SpringProperties;

import java.sql.SQLException;
//--spring.profiles.active=qa
@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(SpringProperties.getProperty("test.msg"));
        System.out.println(context.getBean("connectionPool"));
        System.out.println(context.getBean(DatabaseProperties.class));
    }
}
