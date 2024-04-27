package Pegas;


import Pegas.config.DatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.SpringProperties;

///v3/api-docs
//--spring.profiles.active=qa
///swagger-ui/index.html
@SpringBootApplication
//@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(SpringProperties.getProperty("test.msg"));
        System.out.println(context.getBean("connectionPool"));
//        System.out.println(context.getBean(DatabaseProperties.class));
    }
}
