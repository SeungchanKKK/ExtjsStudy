package com.example.java17crud.controller;

import com.example.java17crud.dto.ReadDto;
import com.example.java17crud.service.TeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class TeController {
    private final TeService teService;

    @PostMapping("/create")
    public String addtext(HttpServletRequest req) throws RuntimeException, JsonProcessingException {
        return teService.addTe(req);
    }

    @GetMapping("/read")
    public ReadDto readtexts() throws RuntimeException{
        ReadDto readDto = teService.readLocation();
        return readDto;
    }

    @PostMapping ("/update")
    public String changeInfo (HttpServletRequest req) throws RuntimeException, JsonProcessingException {
        teService.fixte(req);
        return "메세지를확인해주세요.";
    }

    @PostMapping("/delete")
    public String cutText(HttpServletRequest req) throws RuntimeException, JsonProcessingException {
        teService.cutText(req);
        return "삭제완료";
    }
}

