package com.example.java17crud.service;

import com.example.java17crud.dto.CreateDto;
import com.example.java17crud.dto.ReadDto;
import com.example.java17crud.dto.UpdateDto;
import com.example.java17crud.model.Te;
import com.example.java17crud.repository.TeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeService {

    private final TeRepository teRepository;

    ObjectMapper mapper = new ObjectMapper();

    //Create
    public String addTe(HttpServletRequest req) throws JsonProcessingException {
        String data = req.getParameter("data");
        if (data.startsWith("[")) {
            List<CreateDto> dtos = mapper.readValue(data, new TypeReference<List<CreateDto>>() {
            });
            for (CreateDto dto : dtos) {
                addText(dto);
            }
        } else {
            //object 객체로 파싱
            CreateDto dto = mapper.readValue(data, CreateDto.class);
            addText(dto);
            return "success";
        }
        return "success";
    }

    //Read
    public ReadDto readLocation() {
        return new ReadDto(teRepository.findAll().stream().count(), teRepository.findAll());
    }

    //Update
    public String fixte(HttpServletRequest req) throws JsonProcessingException {
        String data = req.getParameter("data");
        if (data.startsWith("[")) {
            List<UpdateDto> dtos = mapper.readValue(data, new TypeReference<List<UpdateDto>>() {
            });
            for (UpdateDto dto : dtos) {
                updateText(dto);
            }
        } else {
            UpdateDto dto = mapper.readValue(data, UpdateDto.class);
            updateText(dto);
            return "success";
        }
        return "success";
    }
    public void cutText(HttpServletRequest req) throws JsonProcessingException {
        String data = req.getParameter("data");
        if(data.startsWith("[")){
            List<UpdateDto> dtos = mapper.readValue(data, new TypeReference<List<UpdateDto>>() {
            });
            for (UpdateDto dto : dtos) {
                teRepository.deleteById(dto.getId());
            }
        }else {
            UpdateDto dto = mapper.readValue(data, UpdateDto.class);
            teRepository.deleteById(dto.getId());
        }
    }

    //Create Logic
    public void addText(CreateDto dto) {
        Te te = new Te(dto.getText1(), dto.getText2(), dto.getText3());
        teRepository.save(te);
    }

    //Update Logic
    public void updateText(UpdateDto dto) {
        Te changedte = teRepository.findById(dto.getId()).orElseThrow();
        changedte.updateMet(changedte, dto.getText1(), dto.getText2(), dto.getText3());
        teRepository.save(changedte);
    }

    //목록수정
  /*  public void changeLocation(HttpServletRequest req) throws JsonProcessingException {
        System.out.println(req.getParameter("data"));
        String data = req.getParameter("data");
        //object 객체로 파싱
        ObjectMapper mapper = new ObjectMapper();
        Cities cities = mapper.readValue(data,Cities.class);
        Cities changedcity = locationRepository.findById(cities.getId()).orElseThrow(()-> new RuntimeException());
        changedcity.changeInfo(changedcity, cities.getSi(), cities.getDong(), cities.getGungu());
        locationRepository.save(changedcity);
    }

   */
}

