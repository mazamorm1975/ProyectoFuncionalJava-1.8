package org.java_11;


public class Strings {

    private void stringHandlers(String s){

        boolean estaEnBlancoLaCadena = s.isBlank();
        boolean estaVaciaLaCadena = s.isEmpty();

        s.lines().filter(lines -> !lines.isBlank()).forEach(System.out::println);
    }

    //Metodo que demustra el tratamiento para remover espacios en blanco al principio y/o al final del texto
    private void metodosStrip(String cadenaConEspacios){
        //El metodo strip() remueve espacios en blanco tanto al principio como al final
        String cadenaSinEspacios = cadenaConEspacios.strip();
        System.out.println(cadenaSinEspacios);

        //El Metodo stripLeading() elimina espacios en blanco al principio del texto proporcionado
        String cadenaConEspaciosAlPrincipio = cadenaConEspacios.stripLeading();
        System.out.println(cadenaConEspaciosAlPrincipio);

        //El metodo stripTrailing() elimina espacios en blanco al final del text proporcionado.
        String cadenaConEspaciosAlFinal = cadenaConEspacios.stripTrailing();
        System.out.println(cadenaConEspaciosAlFinal);

    }

    private void metodoTrimVSStrip(String cadenaDeTexto){

        /*
         * trim() solo considera los caracteres de espacio en blanco ASCII estandard.
         * strip() considera todos los caracteres de espacio en blanco Unicode
         */

        System.out.println("Cadena De Texto Original "+ cadenaDeTexto);
        System.out.println("Cadena De Texto Despues Del Trim "+ cadenaDeTexto.trim());
        System.out.println("Cadena De Texto Despues Del Strip "+ cadenaDeTexto.strip());

    }

    public static void main(String[] args) {
        Strings str = new Strings();
        //str.stringHandlers("Hola Mario Zamora \n ,Eres bueno programando \n ¿ Como le haces ? \n, Pronto agarraras proyecto \n Vientos Mario ");
        //str.metodosStrip("  MarioZamora  ");
        str.metodoTrimVSStrip("   Mario \u2005\u3000");
    }

}
