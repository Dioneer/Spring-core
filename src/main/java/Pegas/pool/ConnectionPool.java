package Pegas.pool;

import jakarta.annotation.PostConstruct;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Component
@ToString
public class ConnectionPool {
    private final String username;
    private final String password;
    private final Integer poolSize;
    private final String url;

    public ConnectionPool(@Value("${db.username}")String username,@Value("${db.password}") String password,
                          @Value("${db.pool.size}") Integer poolSize,@Value("${db.url}") String url) {
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;
        this.url = url;
    }
    static{
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection open() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    @PostConstruct
    private void init(){
        log.info("init connection pool");
    }
}

