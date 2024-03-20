package Pegas.entity;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class Company {
    private final Long id;
    private final String nameCompany;
}
