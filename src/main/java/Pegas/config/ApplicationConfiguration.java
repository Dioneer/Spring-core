package Pegas.config;

import Pegas.dao.CompanyRepository;
import Pegas.dao.PaymentRepository;
import Pegas.dao.UserRepository;
import Pegas.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Slf4j
//@ImportResource("classpath:application.xml")
@Configuration
//@ComponentScan("Pegas")
//@PropertySource("classpath:application.yml")
public class ApplicationConfiguration {

//    @Bean("connectionPool2")
//    public ConnectionPool connectionPool2(@Value("${db.username}")String username, @Value("${db.password}") String password,
//                          @Value("${db.pool.size}") Integer poolSize, @Value("${db.url}") String url) {
//      return new ConnectionPool(username, password,
//              poolSize,url);
//    }
//    @Bean("connectionPool")
//    public ConnectionPool connectionPool() {
//        return new ConnectionPool("postgres", "123456",
//                12,"jdbc:postgresql://localhost:5432/springdata");
//    }
//
//    @Bean("connectionPool1")
//    @Profile("dev")
//    public ConnectionPool connectionPool1(){
//        return new ConnectionPool("mysql", "123456",
//                12,"jdbc:postgresql://localhost:5432/springdata");
//    }

//    @Bean
//    public UserRepository userRepository(){
//        return new UserRepository();
//    }
//    @Bean
//    public CompanyRepository companyRepository(){
//        return new CompanyRepository();
//    }

    @PostConstruct
    private void init(){
        log.info("init application config");
    }
}
