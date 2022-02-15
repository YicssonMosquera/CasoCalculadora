package com.calculadora.utils;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class DateUtils {
    public static String obtenerFechaPorNumeroSemana(int numeroSemana){
        LocalDate week = LocalDate.now().with(ChronoField.ALIGNED_WEEK_OF_YEAR, numeroSemana);

        LocalDate start = week.with(DayOfWeek.MONDAY)  ;
        LocalDate end = start.plusDays(6);
        //Timestamp ts=new Timestamp(start.);
        return start+" 00:00:00"+"/"+end+" 23:59:00";
    }
}



