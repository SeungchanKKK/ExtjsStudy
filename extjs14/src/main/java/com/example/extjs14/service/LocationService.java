package com.example.extjs14.service;

import com.example.extjs14.model.Cities;
import com.example.extjs14.model.dto.CitiesAddDto;
import com.example.extjs14.model.dto.TestDto;
import com.example.extjs14.repository.CitiesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
@RequiredArgsConstructor
public class LocationService {

    private final CitiesRepository locationRepository;

    //목록저장
    public void addLocation(CitiesAddDto dto) {
        Cities location = new Cities(dto.getSi(), dto.getDong(), dto.getGungu());
        locationRepository.save(location);
    }
    //목록조회
    public TestDto readLocation() {
        return new TestDto(locationRepository.findAll().stream().count(),locationRepository.findAll());
    }

    //목록수정
    public void changeLocation(HttpServletRequest req) throws JsonProcessingException {
        System.out.println(req.getParameter("data"));
        String data = req.getParameter("data");
        //object 객체로 파싱
        ObjectMapper mapper = new ObjectMapper();
        Cities cities = mapper.readValue(data,Cities.class);
        Cities changedcity = locationRepository.findById(cities.getId()).orElseThrow(()-> new RuntimeException());
        changedcity.changeInfo(changedcity, cities.getSi(), cities.getDong(), cities.getGungu());
        locationRepository.save(changedcity);
    }
}
