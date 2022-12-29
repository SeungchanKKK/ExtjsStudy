package com.example.java21.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductReadDto {
    private Long id;

    private String productNM;

    private int price;

    private int amount;

    private String searchValue;
}
