package Pegas.entity;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
@RequiredArgsConstructor
public class Company {
    private final Long id;
    private String nameCompany;
}
