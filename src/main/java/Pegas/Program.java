package Pegas;

import Pegas.db.UserRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserRepository userRepository = context.getBean("repo1",UserRepository.class);
        System.out.println(userRepository);
    }
}
