package Pegas.utils;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@AllArgsConstructor
@Setter
@ToString
public class Connections {
    private final String url;
    private final String userName;
    private final String password;

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
        return DriverManager.getConnection(url,userName,password);
    }

}
