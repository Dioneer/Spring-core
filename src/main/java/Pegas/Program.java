package Pegas;

import Pegas.config.ApplicationConfiguration;
import Pegas.dao.PaymentRepository;
import Pegas.service.CompanyService;
import Pegas.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, InterruptedException {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UserService userService = context.getBean(UserService.class);
        CompanyService companyService = context.getBean(CompanyService.class);
        PaymentRepository paymentRepository = context.getBean( PaymentRepository.class);
        System.out.println(userService.findUserById(1L));
        System.out.println(companyService.findUserById(1L));
        System.out.println(paymentRepository);
        context.close();
    }
}
