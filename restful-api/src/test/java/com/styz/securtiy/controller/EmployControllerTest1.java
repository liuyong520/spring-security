package com.styz.securtiy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.styz.api.model.Employ;
import com.styz.securtiy.dto.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * creat date:2019-07-13 13:33
 * author:xxydliuyss
 * note:
 */
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class EmployControllerTest1 {
    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void testGet() throws Exception {
        ResponseEntity<Employ> forEntity = restTemplate.getForEntity("/get/1", Employ.class);
        System.out.println(objectMapper.writeValueAsString(forEntity));
    }

    @Test
    public void testSave() throws Exception {
        long id = new Random().nextLong();
        Employ employ = new Employ();
        employ.setDatasourceid("db2").setId(id).setDepartmentid(id).setName(RandomStringUtils.randomAscii(8));
        restTemplate.withBasicAuth("user","user");
        SimpleResponse simpleResponse = restTemplate.postForObject("/save", employ, SimpleResponse.class);
        System.out.println(simpleResponse);
    }

    @Test
    public void testUpdate() throws Exception {
        long id = new Random().nextLong();
        Employ employ = new Employ();
        employ.setId(1L).setDatasourceid("db2").setDepartmentid(id).setName(RandomStringUtils.random(8));
        ResponseEntity longResponseEntity = restTemplate.postForEntity("/update", employ,null);
    }

    @Test
    @Transactional
    public void testDelete() throws Exception {
        SimpleResponse forObject = restTemplate.getForObject("/delete/2", SimpleResponse.class);
        System.out.println(forObject);
    }
}
