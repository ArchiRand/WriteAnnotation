package com.myannotation;

import com.myannotation.person.Person;
import com.myannotation.person.Student;
import com.myannotation.person.Teacher;
import com.myannotation.utils.DatabaseManager;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();

        LocalDate sbd = LocalDate.of(2990, 3, 13);
        Student student = new Student("Artem", "LisaevAnatol'evi4", sbd);
        db.save(student);

        System.out.println("<=============================================>");

        LocalDate tbd = LocalDate.of(1970, 1, 1);
        Person teacher = new Teacher("Dmitriy", "Maronov", tbd);
        db.save(teacher);
    }

}
