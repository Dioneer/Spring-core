package Pegas.dao;

import Pegas.dao.bpp.InjectBean;
import Pegas.dao.pool.ConnectionPool;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@ToString
@Repository
public class PaymentRepository {
//    @InjectBean
//    @Autowired
//    @Qualifier("connectionPool")
    private ConnectionPool connectionPool1;
    private Integer poolSize;
    private List<ConnectionPool> connectionPool;

    public PaymentRepository(ConnectionPool connectionPool1,
                             @Value("${db.pool.size}") Integer poolSize, List<ConnectionPool> connectionPool) {
        this.connectionPool1 = connectionPool1;
        this.poolSize = poolSize;
        this.connectionPool = connectionPool;
    }
}
