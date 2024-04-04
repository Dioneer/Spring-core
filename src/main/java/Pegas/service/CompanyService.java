package Pegas.service;

import Pegas.dao.CompanyRepository;
import Pegas.dto.CompanyDTO;;
import Pegas.dto.UserReadDTO;
import Pegas.listener.AccessType;
import Pegas.listener.Entity;
import Pegas.mapper.CompanyMapper;
import Pegas.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CompanyService {
    private final CompanyMapper companyMapper;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyRepository companyRepository;
    private final CompanyReadMapper companyReadMapper;

    public Optional<CompanyDTO> findUserById(Integer id) throws SQLException, InterruptedException {
        return companyRepository.findById(id).map(i->{
            applicationEventPublisher.publishEvent(new Entity(i, AccessType.RAED));
            return companyMapper.fromTo(i);
        });
    }
    public List<CompanyDTO> findAll(){
        return companyRepository.findAll().stream()
                .map(companyReadMapper::fromTo)
                .toList();
    }
}
