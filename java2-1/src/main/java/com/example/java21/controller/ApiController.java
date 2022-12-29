package com.example.java21.controller;

import com.example.java21.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/")
public class ApiController {

    @RequestMapping(value = "/sessionCheck" , method = RequestMethod.POST)
    public Map<String,Object> sessionCheck (Product product){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        return  result;
    }
}
