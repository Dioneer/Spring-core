package Pegas;

import Pegas.db.UserRepository;
import Pegas.service.UserService;
import Pegas.utils.Connections;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserRepository userRepository = context.getBean("repo1",UserRepository.class);
        UserService userService = context.getBean("repo6",UserService.class);
        Connections connections = context.getBean("connections", Connections.class);
        System.out.println(connections);
        System.out.println("Somth find"+userService.findUserById(1L));
        System.out.println(userRepository);
        context.close();
    }
}
