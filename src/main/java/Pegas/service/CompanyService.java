package Pegas.service;

import Pegas.dao.CompanyRepository;
import Pegas.dto.CompanyDTO;;
import Pegas.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
@ToString
@Service
public class CompanyService {
    @Autowired
    private final CompanyMapper companyMapper;
    @Autowired
    private final CompanyRepository companyRepository;
    public Optional<CompanyDTO> findUserById(Long id) throws SQLException, InterruptedException {
        return companyRepository.findById(id).map(companyMapper::fromTo);
    }
}
