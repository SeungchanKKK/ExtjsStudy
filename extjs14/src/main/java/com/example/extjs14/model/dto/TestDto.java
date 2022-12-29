package com.example.extjs14.model.dto;

import com.example.extjs14.model.Cities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TestDto {
    private Long totalNumbers;
    private List<Cities> data;

    public TestDto(Long totalNumbers, List<Cities> data) {
        this.totalNumbers = totalNumbers;
        this.data = data;
    }
}
