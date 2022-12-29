package com.example.extjs14.model;

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
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String si;
    @NotNull
    private String dong;
    @NotNull
    private String gungu;

    public Cities(String si, String dong, String gungu) {
        this.si = si;
        this.dong = dong;
        this.gungu = gungu;
    }


    public void changeInfo(Cities cities,String si, String dong, String gungu) {
        this.id = cities.getId();
        this.dong = dong;
        this.gungu = gungu;
        this.si = si;
    }
}
