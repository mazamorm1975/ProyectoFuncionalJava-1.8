package org.java_10;

import java.util.Optional;

public class JavaOptionalFeature {

    public static void main(String[] args){
        /*
         *Si se trabaja con spring boot y algun metodo de acceso a datos o similar arrojara un optional,
         * se podra utilizar el orElseThrow() para personalizar una exception
         */
        Optional<Integer> op = Optional.ofNullable(null);
        op.orElseThrow(() -> new ArithmeticException("No es mayor que 11"));
    }




}
