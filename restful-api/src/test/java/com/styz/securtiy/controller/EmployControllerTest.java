package com.styz.securtiy.controller;

import com.alibaba.fastjson.JSONObject;
import com.styz.api.model.Employ;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

/**
 * creat date:2019-07-13 08:56
 * author:xxydliuyss
 * note:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EmployControllerTest {
    @Autowired
    private WebApplicationContext wac;
    MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGet() throws Exception {
        //JsonPath:https://goessner.net/articles/JsonPath/
        String result = mvc.perform(MockMvcRequestBuilders.get("/get/1").characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void testSave() throws Exception {
        long id = new Random().nextLong();
        Employ employ = new Employ();
        employ.setDatasourceid("db2").setId(id).setDepartmentid(id).setName(RandomStringUtils.randomAscii(8));
        String result = mvc.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(employ)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("success"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void testUpdate() throws Exception {
        long id = new Random().nextLong();
        Employ employ = new Employ();
        employ.setId(1L).setDatasourceid("db2").setDepartmentid(id).setName(RandomStringUtils.randomAscii(8));
        String result = mvc.perform(MockMvcRequestBuilders.post("/update").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(employ)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("success"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    @Transactional
    public void testDelete() throws Exception {
        String result = mvc.perform(MockMvcRequestBuilders.get("/delete/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
}
