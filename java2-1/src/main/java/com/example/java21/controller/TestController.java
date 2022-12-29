package com.example.java21.controller;

import com.example.java21.model.Test;
import com.example.java21.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @RequestMapping(value = "/test")
    public Map<String, Object> test(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("age",50);
        result.put("name","개발로짜");
        return result;
    }

    @RequestMapping(value = "/getList")
    public Map<String,Object>getList(){
        Map<String,Object> result = new HashMap<String,Object>();
        List<Test>list = null;
        try {
            list=testService.getList();
            result.put("data",list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @GetMapping ("/create")
    public String create(){
        return testService.createList();
    }
}
