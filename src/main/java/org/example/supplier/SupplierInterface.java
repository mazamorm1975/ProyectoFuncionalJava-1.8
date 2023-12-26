package org.example.supplier;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.function.Supplier;

public class SupplierInterface {
    public static void applyLocalDate(){

        Supplier<LocalDateTime> fechasAConvertir = () -> LocalDateTime.now();
        System.out.println("La fecha en formato yyyy-MM-dd es "+ DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(fechasAConvertir.get()));
    }

    public static void main(String[] args){
        applyLocalDate();
    }

}
