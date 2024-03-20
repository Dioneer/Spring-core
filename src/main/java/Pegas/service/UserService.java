package Pegas.service;

import Pegas.dto.UserDTO;
import Pegas.dao.UserRepository;
import Pegas.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public Optional<UserDTO> findUserById(Long id) throws SQLException, InterruptedException {
        return userRepository.findById(id).map(userMapper::fromTo);
    }
}
