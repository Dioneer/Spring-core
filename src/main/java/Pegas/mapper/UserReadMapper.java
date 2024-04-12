package Pegas.mapper;

import Pegas.dto.CompanyDTO;
import Pegas.dto.UserReadDTO;
import Pegas.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDTO>{

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDTO fromTo(User user) {
        CompanyDTO company = Optional.ofNullable(user.getCompany())
                .map(companyReadMapper::fromTo)
                .orElse(null);
        return new UserReadDTO(
                user.getId(),
                user.getUsername(),
                user.getBirthday(),
                user.getFirstname(),
                user.getLastname(),
                user.getRole(),
                company,
                user.getImage()
        );
    }
}
