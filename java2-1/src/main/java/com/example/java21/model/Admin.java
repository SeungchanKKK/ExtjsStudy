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
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adminNickname;

    private String adminPwd ;

    private String adminNm ;

    public Admin(String adminNickname, String adminPwd, String adminNm) {
        this.adminNickname = adminNickname;
        this.adminPwd = adminPwd;
        this.adminNm = adminNm;
    }
}
