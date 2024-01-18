package org.java_11;

import org.java_10.Product;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ArrayApp {

    private void ArraysAsList(Product[] prod){

        List<Product> listaProductos = Arrays.asList(prod);
        Product[] listaProduct2 = listaProductos.toArray(Product[]::new);

        //Nota: en la siguiente linea se agrega un elemento mas al array listaProduct2, pero generara
        //una exception ArrayIndexOutOfBounds
        listaProduct2[2] = new Product(3,"prod-3",false);

        for (Product p: listaProduct2){
            System.out.println(p);
        }
    }

    public void Files(){

        Path writeInFiles = Paths.get("C:/", "Users/Dell/Documents/", "Passcode.txt");

        try{

            Files.writeString(writeInFiles, "Hola Soy Mario Chingon", StandardOpenOption.APPEND);
            String getContent = Files.readString(writeInFiles);
            System.out.println(getContent);

        }catch(Exception e){
            e.getStackTrace();
        }
    }

    public void httpRequest() throws Exception {

        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(new URI("https://pokeapi.co/api/v2/pokemon/pikachu"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

    public static void main(String[] args) throws Exception {

        Product[] productos = new Product[2];
        productos[0] = new Product(1,"prod-1",true);
        productos[1] = new Product(2,"prod-2",true);

        ArrayApp app = new ArrayApp();
        //app.ArraysAsList(productos);
        //app.Files();
        app.httpRequest();
    }

}
