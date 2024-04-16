package Pegas.integration.http;

import Pegas.ApplicationRunner;
import Pegas.dto.UserCreateEditDto;
import Pegas.integration.service.TestApplicationRunner;
import lombok.RequiredArgsConstructor;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureMockMvc
@Transactional
@WithMockUser(username = "ivanov@gmail.com", password="123", authorities = {"ADMIN"})
public class  UserControllerIT {
    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("user/users"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"));
    }
    @Test
    void create() throws Exception {
        mockMvc.perform(post("/users")
                .param("username","test@gmail.com")
                .param("firstname","test")
                .param("lastname", "test")
                .param("role", "ADMIN")
                .param("companyId", "1")
                .param("birthday", "01-01-2002")
                )
                .andExpectAll(
                status().is3xxRedirection(), redirectedUrlPattern("/users/{\\d+}"));
    }
}
