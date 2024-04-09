package Pegas.mapper;

import Pegas.dao.CompanyRepository;
import Pegas.dto.UserCreateEditDto;
import Pegas.entity.Birthday;
import Pegas.entity.Company;
import Pegas.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User>{
    private final CompanyRepository companyRepository;

    public User fromTo(UserCreateEditDto from, User to){
        to.setUsername(from.getUsername());
        to.setFirstname(from.getFirstname());
        to.setLastname(from.getLastname());
        to.setBirthday(from.getBirthday().isEmpty() ? null : new Birthday(LocalDate.parse(from.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH))));
        to.setRole(from.getRole());
        to.setCompany(getCompany(from.getCompanyId()));
        return to;
    }

    @Override
    public User fromTo(UserCreateEditDto userC) {
        return User.builder()
                .username(userC.getUsername())
                .firstname(userC.getFirstname())
                .lastname(userC.getLastname())
                .birthday(userC.getBirthday().isEmpty() ? null : new Birthday(LocalDate.parse(userC.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH))))
                .role(userC.getRole())
                .company(getCompany(userC.getCompanyId()))
                .build();
    }

    private Company getCompany(Integer companyId) {
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElse(null);
    }
}
