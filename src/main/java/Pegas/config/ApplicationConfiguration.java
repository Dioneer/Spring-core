package Pegas.config;

import Pegas.dao.pool.ConnectionPool;
import org.springframework.context.annotation.*;

@ImportResource("classpath:application.xml")
@Configuration
@ComponentScan("Pegas")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

}
