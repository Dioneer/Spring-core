package Pegas.dao;

import Pegas.entity.Company;
import Pegas.utils.Connections;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class CompanyRepository {
    private Connections connections;

    public void init(){
        System.out.println("init UserRepository");
    }

    public Optional<Company> findById (Long id) throws SQLException {
        String sql = """
                select * from company
                where id = ?
                """;
        Connection connection = connections.open();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet result = preparedStatement.executeQuery();
        Company company = null;
        while (result.next()) {
            company = buildCompany(result);
        }
        return Optional.ofNullable(company);
    }

    private Company buildCompany(ResultSet result) throws SQLException{
        return Company.builder()
                .id(result.getLong("id"))
                .nameCompany(result.getString("nameCompany"))
                .build();
    }

    public void destroy(){
        System.out.println("destroy UserRepository");
    }
}
