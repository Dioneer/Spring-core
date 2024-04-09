package Pegas.dto;

import Pegas.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NonNull;
import lombok.Value;

@Value
public class UserCreateEditDto {
    @Email
    String username;
    String birthday;
    @NotBlank
    @Size(min=3,max=30)
    String firstname;
    @NotNull
    String lastname;
    Role role;
    Integer companyId;
}
