package Pegas.mapper;

import Pegas.dto.CompanyDTO;
import Pegas.entity.Company;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class CompanyMapper implements Mapper<Company, CompanyDTO>{
    private final CompanyDTO companyDTO;
    @Override
    public CompanyDTO fromTo(Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .companyname(company.getNameCompany())
                .build();
    }
}
