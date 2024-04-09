package Pegas.integration.repository;

import Pegas.ApplicationRunner;
import Pegas.dao.UserRepository;
import Pegas.dto.IPersonalInfo;
import Pegas.dto.PersonalInfo;
import Pegas.entity.Role;
import Pegas.entity.User;
import Pegas.integration.service.TestApplicationRunner;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@RequiredArgsConstructor
@Transactional
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    void findAllByFIO(){
        List<User> users = userRepository.findAllByFirstnameContainingAndLastnameContaining("a","o");
        assertTrue(!users.isEmpty());
        assertThat(users).hasSize(3);
    }
    @Test
    void setUpdRole(){
        Optional<User> entity = userRepository.findById(1L);
        assertEquals(Role.ADMIN, entity.get().getRole());
        int result = userRepository.updateRole(Role.USER, 1L, 4L);
        assertEquals(2, result);
        Optional<User> entity2 = userRepository.findById(1L);
        assertEquals(Role.USER, entity2.get().getRole());
    }
    @Test
    void checkProjections(){
        List<IPersonalInfo> personalInfos = userRepository.findAllByCompanyId(1);
        assertTrue(!personalInfos.isEmpty());
        assertThat(personalInfos).hasSize(2);
    }

    @Test
    void findFirstByCompanyIsNotNullOrderByIdDesc(){
        Optional<User> user = userRepository.findFirstByCompanyIsNotNullOrderByIdDesc();
        assertTrue(user.isPresent());
        user.ifPresent(u-> assertEquals("Roma", u.getFirstname()));
    }

    @Test
    void checkPageable(){
        var pageable = PageRequest.of(1,2, Sort.by("id"));
        userRepository.findAllBy(pageable);
    }

    @Test
    void findFirst3By(){
        List<User> users = userRepository.findFirst3By(Sort.by("id").and(Sort.by("firstname")).descending());
        assertTrue(!users.isEmpty());
        assertThat(users).hasSize(3);
    }
}
