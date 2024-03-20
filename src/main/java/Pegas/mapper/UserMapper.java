package Pegas.mapper;

import Pegas.dto.UserDTO;
import Pegas.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ToString
@RequiredArgsConstructor
@Component
public class UserMapper implements Mapper<User, UserDTO>{
    @Autowired
    private final UserDTO userDTO;
    @Override
    public UserDTO fromTo(User user) {
        return UserDTO.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .birthday(user.getBirthday())
                .username(user.getUsername())
                .role(user.getRole())
                .companyId(user.getCompany_id())
                .build();
    }
}


