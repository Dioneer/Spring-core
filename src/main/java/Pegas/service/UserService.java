package Pegas.service;

import Pegas.db.User;
import Pegas.db.UserRepository;
import Pegas.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public List<User> findUserById(Long id) throws SQLException {
        return userRepository.findById(id);
    }
}
