package Pegas.dto;

import Pegas.entity.Role;
import lombok.Value;

@Value
public class UserCreateEditDto {
    String username;
    String birthday;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
