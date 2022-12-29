package com.example.java17crud.model;


import com.sun.istack.NotNull;
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
public class Te {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text1;
    @NotNull
    private String text2;
    @NotNull
    private String text3;

    public Te(String text1, String text2, String gungu) {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = gungu;
    }


    public void updateMet(Te te,String text1, String text2, String text3) {
        this.id = te.getId();
        this.text2 = text2;
        this.text3 = text3;
        this.text1 = text1;
    }
}

