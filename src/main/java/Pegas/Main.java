package Pegas;

import Pegas.config.ApplicationConfiguration;
import Pegas.dao.PaymentRepository;
import Pegas.service.CompanyService;
import Pegas.service.PaymentService;
import Pegas.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        CompanyService companyService = context.getBean(CompanyService.class);
        PaymentService paymentService  = context.getBean(PaymentService.class);
        UserService userService = context.getBean(UserService.class);
        System.out.println(companyService.findUserById(1L));
        System.out.println(userService.findUserById(1L));
        paymentService.show();
    }
}
