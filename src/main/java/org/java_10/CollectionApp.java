package org.java_10;

import org.java_8_feature_analisis.consumer.ConsumerApp;

import java.util.*;

public class CollectionApp {

    private void m1CopyOf(List<Product> list){
        List<Product> listProductCopy = List.copyOf(list);
        //listProductCopy.add(new Product(5,"PS7", false));
        //listProductCopy.stream().forEach(System.out::println);

        Set<Product> setListProductCopy = Set.copyOf(list);
        //listProductCopy.add(new Product(5,"PS7", false));
        //setListProductCopy.forEach((x-> System.out.println(x)));

        Map<Integer,Product> mapList = new HashMap<>();
        mapList.put(1, new Product(1,"PS3", true));
        mapList.put(2, new Product(2,"PS4", false));
        mapList.put(3, new Product(3,"PS5", true));

        Map<Integer, Product> mapListProductCopy = Map.copyOf(mapList);
        mapListProductCopy.put(4, new Product(4,"PS6", true));

        System.out.println(mapListProductCopy);


    }

    private void m2UbmodifiableList(List<Product> listProduct){

        /*
        * Se pasa una lista de tipo Producto con la premisa de NO ser modificable, y se guarda en otra lista
        * llamada listaDeProductos
        */
        List<Product> listaDeProductos = Collections.unmodifiableList(listProduct);

        //Se altera la lista ORIGINAL agregando un nuevo elemento.
        listProduct.add(new Product(5,"PS7", false));

        //Se imprime la lista que contiene la lista original la cual sufrio una alteración.
        listaDeProductos.stream().forEach(System.out::println);

        /*
         * Se pasa una lista de tipo Producto con la premisa de NO ser modificable, y se guarda en otra lista
         * llamada listaDeProductos
         */
        List<Product> listaNueva =  List.copyOf(listProduct);

        //Se altera la lista ORIGINAL agregando un nuevo elemento.
        listProduct.add(new Product(6,"PS8", false));

        //Al momento de recorrer la lista nueva, solo arrojara los elementos originales
        //, mas no el que se agrego, es decir el id=6
        listaNueva.stream().forEach(x -> System.out.println(x));

    }

    public static void main(String[] args) {

        List<Product> lista = new ArrayList<>();
        lista.add(new Product(1,"PS3", true));
        lista.add(new Product(2,"PS4", true));
        lista.add(new Product(3,"PS5", true));
        lista.add(new Product(4,"PS6", true));

        CollectionApp app = new CollectionApp();
        //app.m1CopyOf(lista);
        app.m2UbmodifiableList(lista);

    }

}
