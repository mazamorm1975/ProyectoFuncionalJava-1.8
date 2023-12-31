package org.example.supplier;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierInterface {

    public static void GeneratePassword(){

        String cadena = "#$%&/12345AbCDe$%!&67890EfGHi&()(=14785jKmNOp¡??&%12378QRstU$%$:;v25874WXYZ:_;:+159753";
        StringBuilder complementarCadena = new StringBuilder();
        Supplier<String> genera = () -> {

            for (int i = 0; i < 14; i++) {
                int almacenaValor = new Random().nextInt(cadena.length());
                complementarCadena.append(cadena.charAt(almacenaValor));
            }
            return complementarCadena.toString();
        };
        System.out.println("El password Generado es --> "+ genera.get());
    }

    public static void applyLocalDate() {

        Supplier<LocalDateTime> fechasAConvertir = () -> LocalDateTime.now();
        System.out.println("La fecha en formato yyyy-MM-dd es "+ DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(fechasAConvertir.get()));

    }

    public static void main(String[] args) {
        applyLocalDate();
        GeneratePassword();
    }

}
