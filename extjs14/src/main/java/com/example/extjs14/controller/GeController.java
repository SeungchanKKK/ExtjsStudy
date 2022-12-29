package com.example.extjs14.controller;


import com.example.extjs14.model.dto.CitiesAddDto;
import com.example.extjs14.model.dto.TestDto;
import com.example.extjs14.service.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class GeController {

    private final LocationService locationService;

    @PostMapping("/add")
    public String addlocation(@RequestBody CitiesAddDto dto) throws RuntimeException{
        locationService.addLocation(dto);
        return "등록되었습니다";
    }

    @GetMapping("/read")
    public TestDto readlocation() throws RuntimeException{
        TestDto testDto = locationService.readLocation();
        return testDto;
    }

    @PostMapping ("/update")
    public String changeInfo (HttpServletRequest req) throws RuntimeException, JsonProcessingException {
        locationService.changeLocation(req);
        return "메세지를확인해주세요.";
    }
}
