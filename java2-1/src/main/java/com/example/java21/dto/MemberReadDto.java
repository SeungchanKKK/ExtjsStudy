package com.example.java21.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberReadDto {
    private Long id;

    private String memberNm;

    private String address;

    private String memberNick;

    private String searchValue;

    private String searchCode;
}
