package com.myannotation.utils;

import com.myannotation.annotation.CheckDate;
import com.myannotation.annotation.Length;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class CheckObject {

    private static boolean canSave;

    public static <T> boolean checkBeforeSave(T obj) {
        canSave = true;
        Field[] fields = obj.getClass().getSuperclass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(CheckDate.class)) {
                checkDate(f, obj);
            } else if (f.isAnnotationPresent(Length.class)) {
                checkStrings(f, obj);
            }
        }
        return canSave;
    }

    private static <T> void checkDate(Field field, T obj) {
        try {
            field.setAccessible(true);
            LocalDate bd = (LocalDate) field.get(obj);
            if (bd.isAfter(LocalDate.now())) {
                System.err.println(bd.toString() + " is after now! " +
                        "Please Check it and try again");
                canSave = false;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static <T> void checkStrings(Field field, T obj) {
        try {
            String fieldName = field.getName();
            field.setAccessible(true);
            String value = (String) field.get(obj);
            int length = field.getAnnotation(Length.class).length();
            if (value.length() > length) {
                System.err.println("Too long value for field " + fieldName + "! " +
                        "Please check it and try again");
                canSave = false;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
