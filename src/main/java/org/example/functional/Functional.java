package org.example.functional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class Functional {

    private void m1Funcion(){
        Function<Client, Client> listado = Function.identity();
        System.out.println(listado.apply(new Client()));
    }

    private void m2Funcion(){

       IntFunction<Double> fx1 = x -> x + 5.10;
       DoubleFunction<String> fx2 = y -> "Hola pedro navajas "+y;
       LongFunction<String> fx3 = z -> "Que tal pablo marmol"+ z;

        System.out.println(fx1.apply(5));
        System.out.println(fx2.apply(5.6));
        System.out.println(fx3.apply(8));


    }

    private void m3Funcion(){

        ToIntFunction<Person> fx4 = Person::getId;
        DoubleToIntFunction fx5 = x -> (int) (x + 50.5);
        ToIntBiFunction<Person, Integer> fx6 = (x,y) -> x.getAge() + y;

        int funcionFx4 = fx4.applyAsInt(new Person(5,"Pedro",48));
        double funcionFx5 = fx5.applyAsInt(45.5);
        int funcionFx6 = fx6.applyAsInt(new Person(5,"Pedro",48), 45);

        System.out.println(funcionFx4);
        System.out.println(funcionFx5);
        System.out.println(funcionFx6);

    }
        public static void main (String [] args) {

            Function<String, Integer> funcion1 = x -> x.length();
            Function<Integer, Integer> funcion2 = x -> x + 20;
            Integer res = funcion1.andThen(funcion2).apply("Mario Zamora");
            System.out.println(res);

            Function<Integer, Integer> parametro1 = x -> x + 5000;
            Function<Integer, Boolean> parametro2 = y -> y > 15000;
            Boolean validacion = parametro1.andThen(parametro2).apply(24000);

            System.out.println("¿ La validación es (true / false) ?:"+validacion);


            Functional f1 = new Functional();
            f1.m1Funcion();
            f1.m2Funcion();
            f1.m3Funcion();

            List<Person> personas = new ArrayList<>();
            personas.add(new Person(1,"Mario",48));
            personas.add(new Person(2,"Patricia",41));
            personas.add(new Person(3,"Diana",25));
            personas.add(new Person(4,"Daniela",17));
            personas.add(new Person(5,"Chorchitas",5));

            Map<String, Person> listadoFiltrado = personas.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
            System.out.println("El listado es el siguiente");
            System.out.println("\n"+listadoFiltrado);

            Supplier<LocalDateTime> fecha = () -> LocalDateTime.now();
            System.out.println("\n");
            System.out.println("La fecha en formato 'yyyy-MM-dd' es: "+ DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(fecha.get()));



    }


}
