package Pegas.dao;

import Pegas.entity.Role;
import Pegas.entity.User;
import Pegas.utils.Connections;
import lombok.*;

import java.sql.*;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class UserRepository {
    private Connections connections;

    public void init(){
        System.out.println("init UserRepository");
    }
    public Optional<User> findById (Long id) {
        String sql = """
                select * from users
                where id = ?
                """;
        try(Connection connection = connections.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            User user = null;
            while (result.next()) {
                user = buildUser(result);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private User buildUser(ResultSet result) throws SQLException {
        return User.builder()
                .id(result.getLong("id"))
                .username(result.getString("username"))
                .firstname(result.getString("firstname"))
                .lastname(result.getString("lastname"))
                .birthday(result.getObject("birthday", Date.class).toLocalDate())
                .role(Role.valueOf(result.getString("role")))
                .company_id(result.getInt("company_id"))
                .payment_id(result.getInt("payment_id"))
                .build();
    }
    public void destroy(){
        System.out.println("destroy UserRepository");
    }
}
