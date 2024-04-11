package Pegas.dto;

import Pegas.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    @Email
    String username;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthday;
    @NotBlank
    @Size(min=3,max=30)
    String firstname;
    @NotNull
    String lastname;
    Role role;
    Integer companyId;
    MultipartFile image;
}
