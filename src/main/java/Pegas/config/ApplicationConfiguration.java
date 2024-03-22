package Pegas.config;

import Pegas.dao.CompanyRepository;
import Pegas.dao.PaymentRepository;
import Pegas.dao.UserRepository;
import Pegas.pool.ConnectionPool;
import org.springframework.context.annotation.*;

//@ImportResource("classpath:application.xml")
@Configuration
//@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Bean("connectionPool")
    public ConnectionPool connectionPool(){
        return new ConnectionPool("postgres", "123456",
                12,"jdbc:postgresql://localhost:5432/postgres");
    }
    @Bean("connectionPool1")
    public ConnectionPool connectionPool1(){
        return new ConnectionPool("mysql", "123456",
                12,"jdbc:postgresql://localhost:5432/postgres");
    }
    @Bean
    public UserRepository userRepository(){
        return new UserRepository(connectionPool());
    }
    @Bean
    public CompanyRepository companyRepository(){
        return new CompanyRepository(connectionPool());
    }
    @Bean
    public PaymentRepository paymentRepository(){
        return new PaymentRepository(connectionPool1());
    }
}
