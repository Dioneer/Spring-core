package Pegas.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class User {
    private final Long id;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final LocalDate birthday;
    private final Role role;
    private final int company_id;
    private final int payment_id;
}
