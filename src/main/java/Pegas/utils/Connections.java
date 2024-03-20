package Pegas.utils;

import lombok.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@ToString
public final class Connections {
    private String url;
    private String userName;
    private String password;
    private String size;
    private static final BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(12);

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

//    private void initConnectionPool() throws SQLException {
//        for (int i = 0; i < 12; i++) {
//            Connection connection = open();
//            Connection proxyConnection= (Connection)Proxy.newProxyInstance(Connections.class.getClassLoader(), new Class[]{Connection.class}, (proxy, method, args)->
//                method.getName().equals("close") ? pool.add((Connection) proxy) : method.invoke(connection, args));
//            pool.add(proxyConnection);
//        }
//    }
//
//    public Connection get() throws InterruptedException, SQLException {
//        return pool.take();
//    }

    public Connection open() throws SQLException {
        return DriverManager.getConnection(url,userName,password);
    }

}
