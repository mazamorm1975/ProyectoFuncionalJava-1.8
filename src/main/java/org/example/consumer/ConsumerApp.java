package org.example.consumer;

import org.example.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerApp {
    //Metodo que incrementa en uno cada uno de los elementos de la lista "list"
    public List<Integer> consumerInterface() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        Consumer<Integer> incrementar = x -> {
            x++;
            System.out.print(x+", ");
        };
        list.forEach(incrementar);
        return list;
    }

    public void evaluarProducto(){

        List<Product> listaProductos = new ArrayList<>();
        listaProductos.add(new Product(1,1004.45,"Silla"));
        listaProductos.add(new Product(3,24545.89,"mesa"));
        listaProductos.add(new Product(2,8477.01,"lapiz"));
        listaProductos.add(new Product(4,100.55,"Pan bimbo"));
        listaProductos.add(new Product(5,10.85,"vacuna anti.covid"));

        System.out.println("\n");
        System.out.println(listaProductos);

        Consumer<Product> listaEvaluar = x -> {
            if(x.getPrice() > 1000){
                Double discount = x.getPrice() * 0.1;
                Double newPrice = x.getPrice() - discount;
                x.setPrice(newPrice);
            }
        };

        List<Product> nuevoListado = ActualizarPreciosEnProductos(listaProductos, listaEvaluar);
        System.out.println("\n");
        System.out.print(nuevoListado);

    }

    private List<Product> ActualizarPreciosEnProductos(List<Product> listaProductos, Consumer<Product> listaEvaluar) {

        listaProductos.forEach(listaEvaluar);

        return listaProductos;
    }

    private void GeneraPwd(){

        Supplier<String> passGeneration = () -> {
            String cadena = "ABCDEFGHIJKMNOPQRSTUVWXYZabcdefghijkmnopqrstwxyz1234567890#/):-%&&&?=?¡";
            StringBuilder sp = new StringBuilder();
            for(int i=0; i<15; i++){
               int pass = new Random().nextInt(cadena.length());
               sp.append(cadena.charAt(pass));

            }
            return sp.toString();
        };

        String password= passGeneration.get();
        System.out.println("\n");
        System.out.println("Tu nuevo password es "+password);
    }

    public static void main(String[] args) {

        ConsumerApp c1 = new ConsumerApp();
        c1.consumerInterface();
        c1.evaluarProducto();
        c1.GeneraPwd();
    }
}
