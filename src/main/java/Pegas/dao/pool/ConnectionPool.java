package Pegas.dao.pool;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ToString
@Component
public class ConnectionPool {
    private String username;
    private String password;
    private Integer poolSize;
    private String url;

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
}
