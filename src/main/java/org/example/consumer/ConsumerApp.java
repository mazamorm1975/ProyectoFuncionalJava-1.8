package org.example.consumer;

import org.example.model.Product;
import org.example.supplier.SupplierInterface;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.SimpleFormatter;

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



    public static void main(String[] args) {

        ConsumerApp c1 = new ConsumerApp();
        c1.consumerInterface();
        c1.evaluarProducto();

     }
}
