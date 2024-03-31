package Pegas.integration.service;

import Pegas.ApplicationRunner;
import Pegas.dto.CompanyDTO;
import Pegas.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {
    private static final Integer COMPANY_ID=1;
    private static final String COMPANY_NAME = "Onion";
    private final CompanyService companyService;

    @Test
    void findUserById() throws SQLException, InterruptedException {
        Optional<CompanyDTO> actualResult = companyService.findUserById(COMPANY_ID);
        System.out.println(actualResult);
        assertTrue(actualResult.isPresent());
        var expectedResult = new CompanyDTO(COMPANY_ID, COMPANY_NAME);
        actualResult.ifPresent(actual-> assertEquals(expectedResult, actual));
    }
}
