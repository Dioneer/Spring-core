package Pegas.dao;

import Pegas.dao.bpp.InjectBean;
import Pegas.pool.ConnectionPool;
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
    private final ConnectionPool connectionPool;

    public PaymentRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
