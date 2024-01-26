package org.java_12_17.switchPatterns;

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


        public static void main (String[]args){
            SwitchApp switchApp = new SwitchApp();
            //switchApp.m1NewSwitch("");
            System.out.println(switchApp.m2YieldSwitch("B"));
        }

}
