package com.example.java17crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class AjaxController {

    @PostMapping("/paging")
    public void parmCheck(HttpServletRequest req) throws RuntimeException {
        System.out.println(req);
    }
}