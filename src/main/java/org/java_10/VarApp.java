package org.java_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VarApp {

    //Condicionales para el uso de VAR a partir de java 10
    /*
     * - Solo se puede utilizar en un ambito local, NO como variable global
     * - No se puede declarar una varible tipo var SIN inicializarse
     * - No se puede re-declarar la misma variable con otro tipo de datos: Eg. var i = 32, y despues i = "mario"
     * - var NO es una palabra reservada, por lo que se puede utilizar como variable: Eg. private int var = 32
     * - NO se pueden tener metodos que devuelvan un tipo var: Eg. private var Calcular(){}
     * - NO se pueden pasar parametros que asemejen ser tipo var: Eg. private int Calcular(var x)
     * - NO se puede pasar el resultado de una lambda a una variable tipo var: Eg. var x = (a,b) -> a + b;
     * */
    private void m1Classic(){
        int i = 32;
        double d = 1.5;
        char c = '@';
        boolean b = true;
        String s = "mitocode";
        List<Integer> list = List.of(15, 22,444);
        Map<Integer, String> map = Map.of(1, "Java", 2,"Lenguage C", 3, "Kotlin");
    }

    private void m2After(){
        var i = 32;
        var d = 1.5;
        var c = '@';
        var b = true;
        var s = "mitocode";
        var list = List.of(15, 22,444);
        var map = Map.of(1, "Java", 2,"Lenguage C", 3, "Kotlin");
    }

    private void m3Products(){
        List<Product> listaProductos = new ArrayList<>();

        listaProductos.add(new Product(1,"Pro1", true));
        listaProductos.add(new Product(2,"Pro2", false));
        listaProductos.add(new Product(3,"Pro3", true));

        List<String> listaFiltroProductos1 = new ArrayList<>();
        List<String> listaFiltroProductos2 = new ArrayList<>();

        //Iteración sin hacer uso de la clase var
        for(Product pro: listaProductos ){
            String descProduct = pro.getName();
            listaFiltroProductos1.add(descProduct);
        }

        listaFiltroProductos1.forEach(x -> System.out.println(x));

        //Iteración haciendo uso de la clase var
        for(var pro: listaProductos ){
            var descProduct = pro.getName();
            listaFiltroProductos2.add(descProduct);
        }

        listaFiltroProductos2.forEach(System.out::println);
    }


    public static void main(String[] args){
        VarApp app = new VarApp();
        app.m1Classic();
        app.m2After();
        app.m3Products();
    }
}
