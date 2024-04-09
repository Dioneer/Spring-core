package Pegas.entity;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Value
@FieldNameConstants
public class Birthday{
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthday;

    public long getAge(){
        return ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }
}
