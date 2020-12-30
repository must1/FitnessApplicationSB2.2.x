package main.integrationtests;

import main.exercise.BodyPartType;
import main.exercisemessages.UserMessageRepository;
import main.model.Exercise;
import main.model.user.User;
import main.model.user.UserMessage;
import main.user.UserRepository;
import main.userproduct.UserProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class E2EUserProductTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMessageRepository userMessageRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    UserProductService userProductService;

    @Autowired
    private MockMvc mockMvc;

    private User user;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
        user = User.builder()
                .email("mail@gmail.com")
                .password("123")
                .favouriteBodyPartType(BodyPartType.LEGS)
                .lastName("asd")
                .firstName("asd")
                .username("asd")
                .phoneNumber("510")
                .build();

        userRepository.save(user);
    }

    @Test
    @WithMockUser(value = "spring", roles = "ADMIN")
    public void shouldAddExerciseAlongWithMessagesForUsers() throws Exception {
        Exercise exercise = Exercise.builder()
                .name("test")
                .bodyPartType(BodyPartType.LEGS)
                .exerciseDescription("test")
                .build();

        mockMvc.perform(post("/createExercise")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(exercise)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(userMessageRepository.findByUsername(user.getUsername()).getUserId().equals(user.getId()));
    }

}
