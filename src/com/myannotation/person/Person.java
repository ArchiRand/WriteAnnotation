package com.myannotation.person;

import com.myannotation.annotation.CheckDate;
import com.myannotation.annotation.Length;

import java.time.LocalDate;

public class Person {

    @Length(length = 7)
    private String name;
    @Length(length = 10)
    private String surName;
    @CheckDate
    private LocalDate birthDay;

    public Person(String name, String surName, LocalDate birthDay) {
        this.name = name;
        this.surName = surName;
        this.birthDay = birthDay;
    }

    //<editor-fold desc="getters-setters">
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
