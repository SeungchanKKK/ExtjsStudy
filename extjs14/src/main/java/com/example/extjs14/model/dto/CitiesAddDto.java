package com.example.extjs14.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CitiesAddDto {
    private String si;
    private String dong;
    private String gungu;

    public CitiesAddDto(String si, String dong, String gungu){
        this.si =si;
        this.dong =dong;
        this.gungu =gungu;
    }
}
