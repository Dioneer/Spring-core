package Pegas.integration.repository;

import Pegas.ApplicationRunner;
import Pegas.dao.CompanyRepository;
import Pegas.entity.Company;
import Pegas.integration.service.TestApplicationRunner;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Transactional
//@Commit
public class CompanyRepositoryTest {
    private final CompanyRepository companyRepository;
    private final EntityManager entityManager;

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(isolation = Isolation.SERIALIZABLE)
    void findById(){
        var company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }
    @Test
    void save(){
        Company company = Company.builder()
                .nameCompany("Go")
                .locales(Map.of(
                        "ru","Yandex description",
                        "en","Yandex description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
    @Test
    void delete(){
        Optional<Company> company = companyRepository.findById(13);
        assertTrue(company.isPresent());
        company.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(13).isEmpty());
    }
    @Test
    void checkByQueries(){
        Optional<Company> company = companyRepository.findByNameCompany("Google");
        assertTrue(company.isPresent());
    }

    @Test
    void checkFindByFragment(){
        List<Company> companies = companyRepository.findAllByNameCompanyContainingIgnoreCase("A");
        assertThat(companies).hasSize(3);
    }
}
