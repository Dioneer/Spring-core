package Pegas.mapper;

import Pegas.dto.CompanyDTO;
import Pegas.entity.Company;

public class CompanyReadMapper implements Mapper<Company, CompanyDTO>{
    @Override
    public CompanyDTO fromTo(Company company) {
        return new CompanyDTO(company.getId(), company.getNameCompany());
    }
}
