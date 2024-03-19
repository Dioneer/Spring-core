package Pegas.db;

import Pegas.utils.Connections;
import lombok.*;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class UserRepository {
    private String userName;
    private int poolSize;
    private List<Object> args;
    private Map<String, Object> properties;
    private Connections connections;

    public void init(){
        System.out.println("init UserRepository");
    }
    public List<User> findById (Long id) throws SQLException {
        List<User> arr = new ArrayList<>();
        String sql = """
                select * from company
                where id = ?
                """;
        Connection connection = connections.open();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            arr.add(new User(result.getLong("id"), result.getString("nameCompany")));
        }
        return arr;
    }
    public void destroy(){
        System.out.println("destroy UserRepository");
    }
}
