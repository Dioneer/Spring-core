package Pegas.service;

import Pegas.db.UserRepository;
import Pegas.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
}
