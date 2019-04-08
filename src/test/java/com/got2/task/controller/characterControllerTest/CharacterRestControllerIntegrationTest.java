package com.got2.task.controller.characterControllerTest;

import com.got2.task.controller.CharacterController;
import com.got2.task.controller.testData.TestData;
import com.got2.task.entity.Characterrr;
import com.got2.task.repository.CharacterRepository;
import com.got2.task.service.CharacterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@RunWith(SpringRunner.class)

@AutoConfigureMockMvc
public class CharacterRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    Characterrr characterrr;

    @MockBean
    private CharacterRepository characterRepository;

    @MockBean
    private CharacterService service;

    @MockBean
    TestData testData;

    @Test
    public void importCharacterFromOutsideTest() throws Exception {
        when(characterRepository.findById(1)).thenReturn(Optional.of(characterrr));
        when(service.getCharacterrrById(1)).thenCallRealMethod();

        this.mockMvc.perform(post("/outside/{outerId}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.id").value(1));
    }


    @Test(expected = AssertionError.class)
    public void checkErrorTest() throws Exception {
        this.mockMvc.perform(get("/characters")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.nextPage").value("http://localhost:8080/findAll?page=1"))
                .andExpect(jsonPath("$.previousPage").value("http://localhost:8080/findAll?page=0"))
                .andExpect(jsonPath("$.startPage").value("http://localhost:8080/findAll?page=0"))
                .andExpect(jsonPath("$.result").isNotEmpty())
                .andExpect(jsonPath("$.result").isArray());

        characterRepository.deleteAll();
    }


    @Test
    public void ShowCharactersByURLTest() throws Exception {
        this.mockMvc.perform(get("/characters"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content().string(containsString("")));

    }

    @Test
    public void getCharacterByIdTest() throws Exception {
        this.mockMvc.perform(post("/outside/{outerId}", 13))
                .andDo(print())
                .andExpect(status()
                        .isOk());
    }


    @Test
    public void badClientRequest() throws Exception {
        this.mockMvc.perform(post("/outside/{outerId}", -1))
                .andDo(print())
                .andExpect(status()
                        .is4xxClientError());
    }

}
