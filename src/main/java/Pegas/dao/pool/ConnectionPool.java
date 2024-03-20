package Pegas.dao.pool;

import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Component
public class ConnectionPool {
    private String username;
    private String password;
    private Integer poolSize;
    private String url;

    public ConnectionPool(String username, String password, Integer poolSize, String url) {
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;
        this.url = url;
    }
}
