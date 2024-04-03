package Pegas.dto;

import Pegas.entity.Birthday;
import Pegas.entity.Role;
import lombok.Value;

@Value
public class UserCreateEditDto {
    String username;
    Birthday birthday;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
