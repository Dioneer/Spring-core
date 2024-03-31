package Pegas.service;

import Pegas.dao.CompanyRepository;
import Pegas.dto.CompanyDTO;;
import Pegas.listener.AccessType;
import Pegas.listener.Entity;
import Pegas.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CompanyService {
    private final CompanyMapper companyMapper;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyRepository companyRepository;

    public Optional<CompanyDTO> findUserById(Integer id) throws SQLException, InterruptedException {
        return companyRepository.findById(id).map(i->{
            applicationEventPublisher.publishEvent(new Entity(i, AccessType.RAED));
            return companyMapper.fromTo(i);
        });
    }
}
