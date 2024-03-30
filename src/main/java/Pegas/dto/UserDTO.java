package Pegas.dto;

import Pegas.entity.Birthday;
import Pegas.entity.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstname;
    private String lastname;
    private Birthday birthday;
    private String username;
    private Role role;
    private Integer companyId;
}
