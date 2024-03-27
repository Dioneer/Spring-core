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
        CompanyService companyService = context.getBean(CompanyService.class);
        PaymentService paymentService  = context.getBean(PaymentService.class);
        UserService userService = context.getBean(UserService.class);
        System.out.println(companyService.findUserById(1L));
        System.out.println(userService.findUserById(1L));
        paymentService.show();
        System.out.println(context.getBean(DatabaseProperties.class));
    }
}
