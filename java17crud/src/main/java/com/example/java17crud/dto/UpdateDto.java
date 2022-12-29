package com.example.java17crud.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateDto {
    private Long id;
    private String text1;
    private String text2;
    private String text3;
}
