package Pegas.dto;

import java.time.LocalDate;

public interface IPersonalInfo {
    String getFirstName();
    String getLastname();
    LocalDate birthday();
}
