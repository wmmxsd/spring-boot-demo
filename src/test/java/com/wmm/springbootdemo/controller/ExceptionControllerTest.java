package com.wmm.springbootdemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ExceptionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void throwException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/illegalArgumentException"))
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.message").value("参数错误"));
    }

    @Test
    void throwException2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/nullPointerException"))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.message").value("sorry, the resourse not found!"));
    }

    @Test
    void throwException3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/exception"))
                .andExpect(status().is(500))
                .andExpect(jsonPath("$.message").value("服务器出错啦"));
    }

    @Test
    void throwResponseStatusException() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/responseStatusException"));
        StatusResultMatchers mockMvcResultMatchers = MockMvcResultMatchers.status();
        resultActions.andExpect(mockMvcResultMatchers.is(500));
    }
}