package Pegas.dto;

import Pegas.entity.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String username;
    private Role role;
    private int companyId;
}
