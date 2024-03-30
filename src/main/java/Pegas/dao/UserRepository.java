package Pegas.dao;

import Pegas.entity.*;
import Pegas.pool.ConnectionPool;
import Pegas.utils.Connections;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserRepository {
    public Optional<User> findById(Long id){
        System.out.println("Find user");
        return Optional.of(new User(id,null,null,null, null, null,null, null));
    }
}
