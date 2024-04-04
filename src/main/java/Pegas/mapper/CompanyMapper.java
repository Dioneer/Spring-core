package Pegas.mapper;

import Pegas.dto.CompanyDTO;
import Pegas.entity.Company;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Mapper<Company, CompanyDTO>{
    private CompanyDTO companyDTO;
    @Override
    public CompanyDTO fromTo(Company company) {
        return new CompanyDTO (company.getId(), company.getNameCompany());
    }
}
