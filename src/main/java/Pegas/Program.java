package Pegas;

import Pegas.db.UserRepository;
import Pegas.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserRepository userRepository = context.getBean("repo1",UserRepository.class);
        UserService userService = context.getBean("repo6",UserService.class);
        System.out.println(userService);
        System.out.println(userRepository);
        context.close();
    }
}
