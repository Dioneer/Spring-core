package Pegas;

import Pegas.service.CompanyService;
import Pegas.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = context.getBean("userService",UserService.class);
        CompanyService companyService = context.getBean("companyService",CompanyService.class);
        System.out.println(userService.findUserById(1L));
        System.out.println(companyService.findUserById(1L));
        context.close();
    }
}
