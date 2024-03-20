package Pegas.service;

import Pegas.dao.CompanyRepository;
import Pegas.dto.CompanyDTO;;
import Pegas.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
@ToString
public class CompanyService {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;
    public Optional<CompanyDTO> findUserById(Long id) throws SQLException {
        return companyRepository.findById(id).map(companyMapper::fromTo);
    }
}
