package org.example.javaTime;

import java.time.LocalDate;
import java.time.LocalTime;


public class Time {

    private void m1WorkingWithDates(){

        LocalTime fechaActual  = LocalTime.of(16,45,21);
        LocalTime fechaModificada = fechaActual.plusHours(2);

        System.out.println("Fecha Actual tipo Mock es : "+fechaActual);
        System.out.println("Fecha con horas agregadas es "+fechaModificada);

        LocalDate anioBisiesto = LocalDate.of(2020,1,1);
        boolean esAnioBisiesto = anioBisiesto.isLeapYear();

        System.out.println("Es año bisiesto ? --> "+ esAnioBisiesto);

        boolean isBeforeDate = fechaActual.isBefore(fechaModificada);
        System.out.println("Esta la fecha 16:45:21 antes de 18:45:21 ? "+ isBeforeDate);

        boolean isAfterDate = fechaActual.isAfter(fechaModificada);
        System.out.println("Esta la fecha 16:45:21 despues de 18:45:21 ? "+ isAfterDate);
    }

    public static void main (String[] args){
        Time time = new Time();
        time.m1WorkingWithDates();
    }
}
