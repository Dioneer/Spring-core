package Pegas.mapper;

import Pegas.dto.CompanyDTO;
import Pegas.entity.Company;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ToString
@RequiredArgsConstructor
@Component
public class CompanyMapper implements Mapper<Company, CompanyDTO>{
    @Autowired
    private final CompanyDTO companyDTO;
    @Override
    public CompanyDTO fromTo(Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .companyname(company.getNameCompany())
                .build();
    }
}