package Pegas.integration.service;

import Pegas.ApplicationRunner;
import Pegas.dto.UserCreateEditDto;
import Pegas.dto.UserReadDTO;
import Pegas.entity.Birthday;
import Pegas.entity.Role;
import Pegas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Transactional
//@Rollback
public class UserServiceIT {
    private static final Long USER_ID=1L;
    private final UserService userService;

    @Test
    void findAll(){
        List<UserReadDTO> result = userService.findAll();
        assertThat(result).hasSize(4);
    }
    @Test
    void findById(){
        Optional<UserReadDTO> user= userService.findById(USER_ID);
        assertTrue(user.isPresent());
        user.ifPresent(i-> assertEquals("ivanov@gmail.com",i.getUsername()));
    }
    @Test
    void create(){
        UserCreateEditDto user = new UserCreateEditDto(
                "test@test4.ru",
                LocalDate.of(2011,02,02),
                "test",
        "test",
                Role.ADMIN,
                1
        );
        UserReadDTO userReadDTO = userService.create(user);
        assertEquals(user.getUsername(), userReadDTO.getUsername());
        assertEquals(user.getBirthday(), userReadDTO.getBirthday());
        assertEquals(user.getFirstname(), userReadDTO.getFirstname());
        assertEquals(user.getLastname(), userReadDTO.getLastname());
        assertEquals(user.getCompanyId(), userReadDTO.getCompany().getId());
        assertSame(user.getRole(), userReadDTO.getRole());
    }
    @Test
    void update(){
        UserCreateEditDto user = new UserCreateEditDto(
                "test@test1.ru",
                LocalDate.of(2022,05,05),
                "test1",
                "test1",
                Role.ADMIN,
                1
        );
        Optional<UserReadDTO> userReadDTO = userService.update(USER_ID, user);
        assertTrue(userReadDTO.isPresent());
        userReadDTO.ifPresent(userReadDTO1->{
        assertEquals(user.getUsername(), userReadDTO1.getUsername());
        assertEquals(user.getBirthday(), userReadDTO1.getBirthday());
        assertEquals(user.getFirstname(), userReadDTO1.getFirstname());
        assertEquals(user.getLastname(), userReadDTO1.getLastname());
        assertEquals(user.getCompanyId(), userReadDTO1.getCompany().getId());
        assertSame(user.getRole(), userReadDTO1.getRole());
        });
    }
    @Test
    void delete(){
        assertFalse(userService.delete(124L));
        assertTrue(userService.delete(2L));
    }
}
