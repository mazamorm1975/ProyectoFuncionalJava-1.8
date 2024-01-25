package org.java_12_17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public sealed class ClaseSellada permits Product, Product2 {

    private int id;
    private String nombre;
    private double price;
    private boolean status;

    public static List<String> BuscarNombre(){
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("Mario");
        listaNombres.add("Armando");
        listaNombres.add("Martha");
        listaNombres.add("Pepe");
        listaNombres.add("Jorge");

        Predicate<String> busquedaNombres = x -> x.startsWith("A");
       List<String> nombreEncontrado =  listaNombres.stream().filter(busquedaNombres).collect(Collectors.toList());

       return nombreEncontrado;

    }

}
