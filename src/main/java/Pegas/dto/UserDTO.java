package Pegas.dto;

import Pegas.entity.Role;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String username;
    private Role role;
    private int companyId;
}
