package Pegas.dto;

import Pegas.entity.Birthday;
import Pegas.entity.Role;
import lombok.Value;

@Value
public class UserReadDTO {
    Long id;
    String username;
    Birthday birthday;
    String firstname;
    String lastname;
    Role role;
    CompanyDTO company;
}
