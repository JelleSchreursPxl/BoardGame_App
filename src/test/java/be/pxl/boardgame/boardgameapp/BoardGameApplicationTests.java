package be.pxl.boardgame.boardgameapp;

import be.pxl.boardgame.boardgameapp.model.dto.BoardgameRequest;
import be.pxl.boardgame.boardgameapp.repository.IBoardGameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class BoardGameApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IBoardGameRepository boardGameRepository;

    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8:0:18");

    @DynamicPropertySource
    static void registerMySQLProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    public void addBoardGameTest() throws Exception{
        BoardgameRequest request = BoardgameRequest.builder().name("Sheep In Disguise").build();

        String requestString = mapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/boardgame")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestString)).andExpect(status().isCreated());

        Assertions.assertEquals(1, boardGameRepository.findAll().size());
    }
}
