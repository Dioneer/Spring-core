package Pegas.db;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@ToString
public class User {
    private final Long id;
    private final String nameCompany;
}
