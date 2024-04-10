package Pegas.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilterDTO {
    String firstName;
    String lastname;
    LocalDate birthday;
}
