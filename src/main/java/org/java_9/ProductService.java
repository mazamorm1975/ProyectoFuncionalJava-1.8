package org.java_9;

public interface ProductService {


    default void dTest(){
        System.out.println("Hola soy un metodo default");
        pTest();
    }

    static void sTest(){
        System.out.println("Hola soy un metodo estatico");
    }

    private void pTest(){

        System.out.println("Hola soy un metodo privado");
        System.out.println("Hola soy un metodo privado");
        System.out.println("Hola soy un metodo privado");
        System.out.println("Hola soy un metodo privado");
        System.out.println("Hola soy un metodo privado");
        System.out.println("Hola soy un metodo privado");
        System.out.println("Hola soy un metodo privado");
        System.out.println("Hola soy un metodo privado");
        System.out.println("Hola soy un metodo privado");

    }


}
