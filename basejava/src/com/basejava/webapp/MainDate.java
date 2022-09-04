package com.basejava.webapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainDate {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis() - start);
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("China Standard Time"));
        System.out.println(cal.getTime());
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        System.out.println(ld);
        System.out.println(lt);
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt1 = LocalDateTime.of(ld,lt) ;
        System.out.println(ldt);
        System.out.println(ldt1);
    }
}
