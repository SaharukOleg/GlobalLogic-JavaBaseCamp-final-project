package com.got2.task.controller.characterControllerTest;

import com.got2.task.controller.CharacterController;
import com.got2.task.controller.testData.TestData;
import com.got2.task.entity.Characterrr;
import com.got2.task.repository.CharacterRepository;
import com.got2.task.service.CharacterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CharacterController.class)
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


    @Test
    public void importCharacterFromOutsideTest() throws Exception {

        this.mockMvc.perform(post("/outside/{outerId}", 317)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test(expected = AssertionError.class)
    public void checkErrorTest() throws Exception {

        this.mockMvc.perform(get("/findAll")).andDo(print())
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

}
