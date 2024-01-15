package org.example.javaTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Set;


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

    private void m2DiffTimeZones(){

        //Como conseguir las zonas horarias para cada continente
        ZoneId.getAvailableZoneIds().forEach(System.out::println);

       //Como conseguir la zona horaria de determinado lugar. Eg. Hermosillo
        ZoneId zonaHorariaMexico = ZoneId.of("America/Hermosillo");
        ZoneId zonaHorariaIndia = ZoneId.of("Indian/Cocos");

        LocalTime tiempoZonaHorariaMexico = LocalTime.now(zonaHorariaMexico);
        LocalTime tiempoZonaHorariaIndia = LocalTime.now(zonaHorariaIndia);

        //Como conseguir la diferencia de Horarios entre dos Zonas Horarias por horas y minutos
        long diffEntreZonasHorarias = ChronoUnit.HOURS.between(tiempoZonaHorariaMexico, tiempoZonaHorariaIndia);
        long diffEntreZonasHorariasMinutos = ChronoUnit.MINUTES.between(tiempoZonaHorariaMexico, tiempoZonaHorariaIndia);

        System.out.println("La diferencia en horas entre India y México es de : "+diffEntreZonasHorarias + " Horas.");
        System.out.println("La diferencia en minutos entre Mexico e India es de : " + diffEntreZonasHorariasMinutos + " Minutos.");


    }

    private void m3Instant(){
        Instant instante1 = Instant.now();
        Instant instante2 = instante1.plus(5, ChronoUnit.DAYS);

        System.out.println(instante1);
        System.out.println(instante2);
    }

    private void m4FormateadoresDeFechas(){

        LocalDate fechaAFormatear = LocalDate.of(2024,01,15);
        System.out.println(fechaAFormatear);

        String fechaFormateada = fechaAFormatear.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println(fechaFormateada);

         LocalDate fecha1 = LocalDate.parse("2024-01-15");
         LocalDate fecha2 = LocalDate.parse("15/01/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println(fecha1);
        System.out.println(fecha2);
    }

    public static void main (String[] args){
        Time time = new Time();
        time.m1WorkingWithDates();
        time.m2DiffTimeZones();
        time.m3Instant();
        time.m4FormateadoresDeFechas();
    }
}
