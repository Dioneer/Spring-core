package Pegas.mapper;

import Pegas.dto.CompanyDTO;
import Pegas.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyDTO>{
    @Override
    public CompanyDTO fromTo(Company company) {
        return new CompanyDTO(company.getId(), company.getNameCompany());
    }
}
