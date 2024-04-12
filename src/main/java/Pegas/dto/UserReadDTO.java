package Pegas.dto;

import Pegas.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDTO {
    Long id;
    String username;
    LocalDate birthday;
    String firstname;
    String lastname;
    Role role;
    CompanyDTO company;
    String image;
}
