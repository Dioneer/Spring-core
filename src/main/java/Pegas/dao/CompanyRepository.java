package Pegas.dao;

import Pegas.entity.Company;
import Pegas.utils.Connections;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
@ToString
@Repository
public class CompanyRepository {

    private Connections connections;
    @PostConstruct
    public void init(){
        System.out.println("init UserRepository");
    }

    public Optional<Company> findById (Long id) {
        String sql = """
                select * from company
                where id = ?
                """;
        try(Connection connection = connections.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            Company company = null;
            while (result.next()) {
                company = buildCompany(result);
            }
            return Optional.ofNullable(company);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Company buildCompany(ResultSet result) throws SQLException{
        return Company.builder()
                .id(result.getLong("id"))
                .nameCompany(result.getString("nameCompany"))
                .build();
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy UserRepository");
    }
}
