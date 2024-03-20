package Pegas.mapper;

import Pegas.dto.UserDTO;
import Pegas.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserDTO>{
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


