package com.cake.manager.cake.controller;

import com.cake.manager.cake.domain.Cake;
import com.cake.manager.cake.service.CakeManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author Oleh Kepsha
 */
@WebMvcTest(CakeController.class)
class CakeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CakeManagementService cakeService;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void getCakesTest() throws Exception {
        List<Cake> testCakeList = Stream.of(1, 2, 3)
                .map(i -> new Cake("title" + i, "desc" + i,  "image" + i))
                .collect(Collectors.toList());
        String expectedResultContent = mapper.writeValueAsString(testCakeList);

        Mockito.when(cakeService.getCakes()).thenReturn(testCakeList);
        mockMvc
                .perform(get("/cake"))
                .andExpect(content().json(expectedResultContent));
    }

    @Test
    void addCakeTest() throws Exception {
        Cake testCake = new Cake("title", "desc",  "image");
        String expectedResultContent = mapper.writeValueAsString(testCake);

        Mockito.when(cakeService.addCake(testCake)).thenReturn(testCake);

        mockMvc
                .perform(post("/cake")
                .contentType(MediaType.APPLICATION_JSON)
                .content(expectedResultContent))
                .andExpect(content().json(expectedResultContent));

        verify(cakeService, times(1)).addCake(testCake);
    }
}
