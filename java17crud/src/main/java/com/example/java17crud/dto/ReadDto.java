package com.example.java17crud.dto;

import com.example.java17crud.model.Te;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReadDto {
    private Long totalNumbers;
    private List<Te> data;

    public ReadDto(Long totalNumbers, List<Te> data) {
        this.totalNumbers = totalNumbers;
        this.data = data;
    }
}

