package Pegas.dto;

import Pegas.entity.Birthday;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FilterDTO {
    String firstName;
    String lastname;
    Birthday birthday;
}
