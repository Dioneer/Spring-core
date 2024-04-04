package Pegas.dto;

import Pegas.entity.Birthday;
import Pegas.entity.Role;
import lombok.Value;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.util.Locale;

@Value

public class UserCreateEditDto {
    String username;
    Birthday birthday;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;

    public UserCreateEditDto(String username, String birthday, String firstname, String lastname, Role role, Integer companyId) {
        this.username = username;
        this.birthday =  new Birthday( LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)));
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.companyId = companyId;
    }
}
