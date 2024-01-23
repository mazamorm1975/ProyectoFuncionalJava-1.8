package org.java_11;

import org.java_10.Product;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.SECONDS;

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

    private void m3Configs() throws Exception {
        /*
         Si se requiere realizar una petición de tipo GET, la clse HttpClient de java 11, permite pasar
         Datos en un Header, como por ejemplo que se requiera pasar un token en el Header
         entonces en el heade se le puede pasar el Authorization y enseguida el Token:
         Ejemplo: .header("Authorization","TokenJWT")
         */

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://pokeapi.co/api/v2/pokemon/pikachu"))
                .header("Key1","value1")
                .timeout(Duration.of(10, SECONDS))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.body());

    }

    private void m3Bodies() throws Exception {
        //En este metodo se aplica la clase HttpClient con diferentes tipos de POST
        HttpRequest httpRequest =  HttpRequest.newBuilder()
                .uri(new URI("https://pokeapi.co/api/v2/pokemon/pikachu"))
                //POST sin ningun cuerpo
                .POST(HttpRequest.BodyPublishers.noBody())

                .header("Content-Type", "text/plain;charset=UTF-8")

                //Se puede pasar un metodo POST incluyendo un String
                //.POST((HttpRequest.BodyPublishers.ofString("Un cuerpo con un string en la petición")))

                //Se puede pasar un metodo POST con arreglo de bytes
                //.POST(HttpRequest.BodyPublishers.ofInputStream(() -> new ByteArrayInputStream(data)))

                //Se puede psar un post apuntando a un archivo
                //.POST(HttpRequest.BodyPublishers.ofFile(Paths.get("src/main/resources/mitocode.txt")))

                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse);
    }

    private void m4Predicates(){

        Predicate<Product> isProductEmpty = x -> x.getName().isEmpty();
        Predicate<Product> isNotProductEmpty = Predicate.not(isProductEmpty);

        Stream.of(new Product(1,"product-x",true))
                .filter(x -> x.getName().isEmpty())
                .forEach(x -> System.out.println(x));
    }

    public static void main(String[] args) throws Exception {

        Product[] productos = new Product[2];
        productos[0] = new Product(1,"prod-1",true);
        productos[1] = new Product(2,"prod-2",true);

        ArrayApp app = new ArrayApp();
        //app.ArraysAsList(productos);
        //app.Files();
        //app.httpRequest();
        //app.m3Configs();
        app.m4Predicates();
    }

}
