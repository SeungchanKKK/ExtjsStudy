package com.example.java21.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberNm;

    private String address;

    private String memberNick;

    public Member(String memberNm, String address, String memberNick) {
        this.memberNm = memberNm;
        this.address = address;
        this.memberNick = memberNick;
    }

}
