package org.java_12_17.switchPatterns;

import org.java_12_17.sealedClasesAndRecord.Product;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Supplier;

public class SwitchApp {

    private void m1NewSwitch(String param) {
        switch (param) {
            case "A" -> System.out.println("Mario Zamora Martinez");
            case "B" -> System.out.println("Patricia Aburto Salas");
            case "C" -> System.out.println("Chorchitas Miramon Zamora");
            case "D" -> System.out.println("Daniela Zamora Aburto");
            default ->  System.out.println("No se ingreso nada");
        }
    }

    private String m2YieldSwitch(String param) {
        return switch (param) {
            case "A":
                yield "Mario Zamora Martinez";

            case "B":
                yield "Patricia Aburto Salas";

            case "C":
                yield "Chorchitas Miramon Zamora";

            case "D":
                yield "Daniela Zamora Aburto";

            default:
                yield "No se ingreso ningun datos adicional";

        };
    }

    private String m3PatternMatcher(Object param) throws Exception {
    //Primer forma de como se podria utilizar el pattern Matcher sin el uso del switch en java 17
       /* if(param instanceof String){
            System.out.println("Es un String");
        } else if(param instanceof Integer){
            System.out.println("Es un entero");
        } else if (param instanceof Double) {
            System.out.println("Es un double");
        } else {
            System.out.println("Default");
        }
        */
        Optional<Object> error = Optional.ofNullable(param);
        Object error2 = error.orElseThrow(() ->new RuntimeException("El valor viene en vacio"));
        //Segunda forma de realizar el patternMatcher utilizando la sentencia switch en java 17
        return switch (param){
          case String s -> "Es un String ";
          case Integer i -> "Es un entero";
          case Double d -> "Es un double";
          case Product p -> "Es un product";
          case null -> "El valor fue nulo";
            default -> null;
        };
    }


        public static void main (String[]args) throws Exception {
            SwitchApp switchApp = new SwitchApp();
            //switchApp.m1NewSwitch("");
            //System.out.println(switchApp.m2YieldSwitch("B"));
            System.out.println(switchApp.m3PatternMatcher(new Product()));
        }

}
