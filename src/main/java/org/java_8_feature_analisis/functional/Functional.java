package org.java_8_feature_analisis.functional;

import org.java_8_feature_analisis.model.Product;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Functional {

    public static void main(String[] args) {

        Functional f1 = new Functional();
        f1.m1Funcion();
        f1.m2Funcion();
        f1.m3Funcion();
        f1.m4Funcion();

    }

    private void m1Funcion() {
        Function<Client, Client> listado = Function.identity();
        System.out.println(listado.apply(new Client()));
    }

    public void m2Funcion() {

        List<Person> personas = new ArrayList<>();
        personas.add(new Person(1, "Mario", 48));
        personas.add(new Person(2, "Patricia", 41));
        personas.add(new Person(3, "Diana", 25));
        personas.add(new Person(4, "Daniela", 17));
        personas.add(new Person(5, "Chorchitas", 5));

        Map<Integer, Person> listado = personas.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));
        listado.forEach((x, y) -> System.out.println("Despliegue del listado con el identificador fuera : " + x + " " + y));
        System.out.println("Identificador incluido dentro de la matriz." + listado);
    }

    private void m3Funcion() {

        IntFunction<Integer> fx1 = x -> x + 10;
        DoubleFunction<Double> fx2 = y -> y + 500.54;
        LongFunction<Long> fx3 = z -> z + 10000;


        Integer valorFx1 = fx1.apply(7);
        Double valorFx2 = fx2.apply(1500);
        Long valorFx3 = fx3.apply(1400);

        System.out.println("Valor de la funcion fx1 " + valorFx1);
        System.out.println("Valor de la funcion fx2 " + valorFx2);
        System.out.println("Valor de la funcion fx3 " + valorFx3);
    }

    private void m4Funcion() {
        Person p = new Person();
        p.setId(1);
        p.setName("Mario Zamora");
        p.setAge(48);

        ToIntFunction<Person> longitudDePalabra = x -> x.getName().length();
        System.out.println(longitudDePalabra.applyAsInt(p));

        DoubleToIntFunction CalculoDePeso = y -> (int) (y + 5.5);
        System.out.println(CalculoDePeso.applyAsInt(10));

        LongToIntFunction edad = z -> p.getAge() + 15000;
        System.out.println(edad.applyAsInt(0));

        ToIntBiFunction<Person, Integer> calculoEdad = (a1, a2) -> a1.getAge() + a2;
        System.out.println(calculoEdad.applyAsInt(new Person(2, "Angelica", 18), 5));

    }

    private void m5Funcion() {

        Person p = new Person();
        p.setName("MarioZ");
        Function<String, Integer> fx1 = x -> p.getName().length();
        Function<Integer, Integer> fx2 = y -> y + 5;
        System.out.println("La cantidad de Letras contenida es de: " + fx1.andThen(fx2));

    }

    private List<Product> ProductDetails(List<Product> lista, Consumer<Product> datos) {
       lista.forEach(datos);
        return lista;
    }


}
