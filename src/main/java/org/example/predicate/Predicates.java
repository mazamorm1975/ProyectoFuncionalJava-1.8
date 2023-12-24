package org.example.predicate;

import org.example.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {

    public static boolean EvaluaNumerosPrimos(int num) {

        boolean result = false;
        int cont = 0;
        for (int i = 1; i < num; i++) {

            if (num % i == 0) {
                cont++;
            }

            result = cont < 3;
        }
        return result;
    }

    public static void main(String[] args) {

        //Comparación de 2 cadenas para encontrar las que comiencen con "A" y contengan una letra "n"
        Predicate<String> comparacionCadena1 = palabra -> palabra.startsWith("A");
        Predicate<String> comparacionCadena2 = palabra2 -> palabra2.contains("n");
        boolean resultadoComparacion = comparacionCadena1.and(comparacionCadena2).test("Angelica");
        System.out.println("La comparación es correcta ? " + resultadoComparacion);

        Predicate<Integer> evaluaNumero = fx -> fx > 18;
        System.out.println(Predicates.EvaluaNumerosPrimos(5));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> numerosEnteros = x -> x % 2 == 0;

        List<Integer> resultadoEnteros = filtradoEnteros(numbers, numerosEnteros);

        System.out.println(resultadoEnteros);

        Predicates predicate = new Predicates();
        predicate.filterWithConditions();
    }

    private static List<Integer> filtradoEnteros(List<Integer> numbers, Predicate<Integer> numerosEnteros) {

        List<Integer> esEntero = new ArrayList<>();
        for(Integer n: numbers){
            if(numerosEnteros.test(n)){
                esEntero.add(n);
            }
        }

        return esEntero;
    }

    private void filterWithConditions() {
        List<Persona> personaList = Arrays.asList(
                new Persona("Mario", 48, "Chicoloapan"),
                new Persona("Paty", 48, "Tenayo"),
                new Persona("Diana", 48, "Miguel Hidalgo"),
                new Persona("Violeta", 48, "Ixtapaluca"),
                new Persona("Daniela", 48, "Ecatepec"),
                new Persona("Chorchitas", 5, "Jalatlaco"));
    }
}
