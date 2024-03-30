package Pegas.unit;

import Pegas.ApplicationRunner;
import Pegas.dao.CompanyRepository;
import Pegas.dto.CompanyDTO;
import Pegas.entity.Company;
import Pegas.listener.Entity;
import Pegas.mapper.CompanyMapper;
import Pegas.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {
    private static final Integer COMPANY_ID = 1;
    private static final String COMPANY_NAME = "Onion";
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private  CompanyMapper companyMapper;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findUserById() {
        Mockito.doReturn(Optional.of(new Company(COMPANY_ID, COMPANY_NAME, Collections.emptyMap())))
                .when(companyRepository).findById(COMPANY_ID);
        Mockito.doReturn(new CompanyDTO(COMPANY_ID, COMPANY_NAME))
                .when(companyMapper).fromTo(new Company(COMPANY_ID, COMPANY_NAME, Collections.emptyMap()));
        try {
            Optional<CompanyDTO> actualResult = companyService.findUserById(COMPANY_ID);
            System.out.println(actualResult);
            assertTrue(actualResult.isPresent());
            var expectedResult = new CompanyDTO(COMPANY_ID, COMPANY_NAME);
            actualResult.ifPresent(actual-> assertEquals(expectedResult, actual));
            verify(eventPublisher).publishEvent(any(Entity.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void sayHello(){
        System.out.print("hello");
    }

}
