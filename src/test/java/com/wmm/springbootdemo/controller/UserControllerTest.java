package com.wmm.springbootdemo.controller;

import com.wmm.springbootdemo.SpringBootDemoApplication;
import com.wmm.springbootdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(SpringBootDemoApplication.class)
@AutoConfigureMockMvc
class UserControllerTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MockMvc mockMvc;

    @Test
    void testQuery() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/users").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }

    @Test
    void testInsert() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/users"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        log.info(resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    void testchangemoney() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/users").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }

    @Test
    void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v2/users/8").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }
}