package org.java_8_feature_analisis.streams;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppStream {

    public static void main(String[] args) {

        Client e1 = new Client(1, "Client1", "Trainee Developer", LocalDate.of(1991, 1, 1), 1000.00, "Peru");
        Client e2 = new Client(2, "Client2", "QA", LocalDate.of(1993, 2, 1), 2000.00, "Peru");
        Client e3 = new Client(3, "Client3", "Architect", LocalDate.of(1995, 3, 1), 3000.00, "Paraguay");
        Client e4 = new Client(4, "Client4", "Cloud Engineer", LocalDate.of(1987, 4, 1), 4000.00, "Colombia");
        Client e5 = new Client(5, "Client5", "Cobol Engineer", LocalDate.of(1956, 1, 1), 5000.00, "Argentina");
        Client e6 = new Client(6, "Client6", "Scrum Master", LocalDate.of(2002, 11, 1), 4500.00, "Argentina");
        Client e7 = new Client(7, "Client7", "Leader Project", LocalDate.of(1998, 12, 1), 10000.00, "Mexico");
        Client e8 = new Client(8, "Client8", "Senior Developer", LocalDate.of(1996, 7, 1), 7000.00, "Rep. Dominicana");
        Client e9 = new Client(9, "Client9", "Junior Developer", LocalDate.of(2008, 8, 1), 500.00, "Ecuador");
        Client e10 = new Client(10, "Client10", "Mobile Developer", LocalDate.of(1975, 9, 1), 3000.00, "Chile");
        Client e11 = new Client(11, "Client11", "Accounting", LocalDate.of(1985, 7, 3), 2000.00, "España");
        Client e12 = new Client(12, "Client12", "Manager", LocalDate.of(1980, 9, 2), 2000.00, "Mexico");
        Client e13 = new Client(13, "Client13", "Manager II", LocalDate.of(1980, 9, 2), 2000.00, "Peru");
        Client e14 = new Client(14, "Client23", "Manager III", LocalDate.of(1980, 9, 2), 2000.00, "Peru");
        Client e15 = new Client(15, "Client23", "Manager III", LocalDate.of(1980, 9, 2), 2001.00, "Peru");


        List<Client> clientList = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
        AppStream app = new AppStream();
     /*   app.m1getDevelopers(clientList, "QA");
        app.m2getDevelopers(clientList);
        app.m3CalculateOlderAge(clientList);
        app.m4GetTheOldestEmployee(clientList);
        app.m6GetTheMaximumSalary(clientList);
        app.m7GetAverage(clientList);
        app.m8GetSummaryStatistics(clientList);
        app.m9GetRecordsUsingDistintc(clientList);
        app.m10DiffBetweenCountAndSize(clientList);
        app.m11Skip(clientList);
        app.m12getAnyYounger(clientList);
        app.m13map(clientList);
        app.m14FlatMap(clientList);
        app.m15GroupBy(clientList);
        app.m16ToMapToSet(clientList);
        app.m17Comparator(clientList);
        app.m18SalarySumByCountry(clientList);
        app.m19ComplexExercises(clientList);
        app.m20ReduceMethod();
        */

        app.m21Joinin();


    }

    private void m1getDevelopers(List<Client> list, String textoABuscar) {
        Predicate<Client> filtroClientesPorPuesto = x -> x.getJob().contains(textoABuscar);

        List<Client> listado = list.stream()
                .filter(filtroClientesPorPuesto)
                .collect(toList());

        System.out.println(listado);

    }

    private void m2getDevelopers(List<Client> clienList) {

        //Listado Ordenado en orden de A - Z, con referencia al puesto del empleado
        //guardado en una lista de tipo "Client"
        List<Client> listadoClientes = clienList.stream()
                .sorted(comparing(Client::getJob))
                .toList().reversed();
        listadoClientes.forEach(System.out::println);

        System.out.println("\n");
        //Listado ordenado en orden de A - Z, con referencia al salario del empleado
        //SIN utilizar metodos referenciados
        clienList.stream()
                .sorted(comparing(x -> x.getSalary()))
                .toList()
                .reversed()
                .forEach(x -> System.out.println(x));
    }

    private void m3CalculateOlderAge(List<Client> ageList) {
        System.out.println("\n");
        Predicate<Client> calculateAge = x -> Period.between(x.getTime(), LocalDate.now()).getYears() >= 18;
        ageList.stream()
                .filter(calculateAge)
                .forEach(x -> System.out.println(x));
    }

    private void m4GetTheOldestEmployee(List<Client> listOlder) {
        System.out.println("\n");
        listOlder.stream()
                .sorted(comparing(Client::getTime))
                .limit(1)
                .forEach(System.out::println);
    }

    private void m6GetTheMaximumSalary(List<Client> listMaxSalary) {
        double max = listMaxSalary.stream()
                .mapToDouble(Client::getSalary)
                .max()
                .orElse(0);
        System.out.println("El maximo de salario es : " + max);

        double min = listMaxSalary.stream()
                .mapToDouble(Client::getSalary)
                .min()
                .orElse(0);
        System.out.println("El mínimo de salario es: " + min);

        Client cli = listMaxSalary.stream()
                .max(comparing(x -> x.getSalary()))
                .orElse(new Client());

        System.out.println("El empleado que mas gana es y que menos hace es  : " + cli);

    }

    private void m7GetAverage(List<Client> listClient) {

        double average = listClient.stream()
                .mapToDouble(x -> x.getSalary())
                .average()
                .orElse(0.00);

        DecimalFormat bd = new DecimalFormat("");
        System.out.printf("El promedio Del Sueldo de los empleado es de %.2f", average);

    }

    private void m8GetSummaryStatistics(List<Client> clientList) {
        System.out.println("\n");

        DoubleSummaryStatistics estadistica = clientList.stream()
                .mapToDouble(x -> x.getSalary())
                .summaryStatistics();
        System.out.println(estadistica);
        System.out.println("Total Empleados: " + estadistica.getCount());
        System.out.println("Promedio: " + estadistica.getAverage());
        System.out.println("Salario Maximo:  " + estadistica.getMax());
        System.out.println("Salario Minimo: " + estadistica.getMin());
        System.out.println("Total Sumatoria: " + estadistica.getSum());
    }

    private void m9GetRecordsUsingDistintc(List<Client> clientList) {
        clientList.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private void m10DiffBetweenCountAndSize(List<Client> clientList) {
        /*el metodo count en el api stream se utiliza mas cuando se tiene que contar elementos
          productos de una logica
        */
        Predicate<Client> contarIdEmpleados = x -> x.getSalary() >= 500;
        long usoCount = clientList.stream()
                .filter(contarIdEmpleados)
                .count();
        /*
         Si solo lo que se desea es conocer el total de elementos de una lista, basta con utilizar el size()
         */
        long usoSize = clientList.size();

        System.out.println(usoCount);
        System.out.println(usoSize);
    }

    private void m11Skip(List<Client> clientList) {
        clientList.stream()
                .skip(7)
                .distinct()
                .limit(4)
                .forEach(System.out::println);
    }

    private void m12getAnyYounger(List<Client> clientList) {
        Predicate<Client> filtradoJovenes = e -> Period.between(e.getTime(), LocalDate.now()).getYears() < 18;

        boolean hayAlgunJoven = clientList.stream()
                .anyMatch(filtradoJovenes);

        System.out.println("hay Alguna Empleado Joven ? " + hayAlgunJoven);
    }

    private void m13map(List<Client> clientList) {

        clientList.stream().map(e -> {
            e.setSalary(e.getSalary() * 1.10);
            return e.getSalary();
            //Iterando con una interfaz Consumer<Client>
        }).forEach(System.out::println);

    }

    private void m14FlatMap(List<Client> clientList) {
        clientList.stream()
                .filter(x -> x.getSalary() > 500)
                .flatMap(y -> {
                    return Stream.of(y.getSalary(), y.getClientName(), y.getCountry());
                }).forEach(x -> {
                    System.out.print(x + "\n");
                });
    }

    private void m15GroupBy(List<Client> clientList) {

        Map<Integer, List<Client>> listadoClientes1 = clientList.stream()
                .collect(groupingBy(Client::getId));
        System.out.println(listadoClientes1);


        Map<String, Map<String, List<Client>>> listadoClientes = clientList.stream()
                .collect(groupingBy(x -> x.getCountry(), groupingBy(y -> y.getJob())));
        System.out.println(listadoClientes);
    }

    private void m16ToMapToSet(List<Client> clientList) {
        Map<String, List<Client>> listado = clientList.stream().collect(groupingBy(Client::getCountry));

        Set<Client> listadoSet = new HashSet<>(clientList);
        System.out.println(listado.entrySet());
        System.out.println(listado.values());
        listado.entrySet().forEach(System.out::println);

    }

    private void m17Comparator(List<Client> clientList) {
        clientList.stream()
                .sorted(comparing(Client::getTime).reversed())
                .forEach(System.out::println);

        List<Integer> listado = Stream.of(1, 2, 3, 4, 5, 7, 8, 9, 12)
                .sorted(Comparator.reverseOrder())
                .collect(toList());


        System.out.println("Tamaño del listado es de " + listado.size() + " elementos");
        System.out.println("Elementos contenidos en la lista ");
        for (Integer i : listado) {
            System.out.println(i + " ");
        }

    }

    private void m18SalarySumByCountry(List<Client> clientList) {
        Map<String, Double> salaryListByCountry = clientList.stream()
                .collect(groupingBy(x -> x.getCountry(), summingDouble(x -> x.getSalary())));

        salaryListByCountry.forEach((x, y) -> System.out.println("Pais " + x + "|" + " Salario Total Del Pais " + y));
    }


    private void m19ComplexExercises(List<Client> clientList) {
        List<String> countryList = Arrays.asList("Peru", "Paraguay", "Rep. Dominicana", "Colombia", "Argentina", "Ecuador", "Chile", "Mexico");

        Map<String, List<Client>> listaFiltro = clientList.stream()
                .filter(x -> countryList.contains(x.getCountry()))
                .filter(x -> x.getSalary() > 2000.00)
                .sorted(comparing(Client::getCountry).thenComparing(Client::getSalary).reversed())
                .collect(groupingBy(Client::getCountry));
        /*
    - Filtrar los empleados que ganen mas de $2000.00., y que pertenecen a un pais de america latina
      (Peru, Paraguay, Colombia, Argentina, Ecuador, Chile, Mexico)
    - Ordenar los empleados filtrados por pais en orden alfabetico ascendente y luego por salario en orden descendente
    - Obtener una lista de los empleados Mejor pagados de cada pais y agregarlos a una lista separada
     */
        List<Client> filtradoFinal = new ArrayList<>();

        for (List<Client> listaAlmacenado : listaFiltro.values()) {
            filtradoFinal.add(
                    listaAlmacenado.stream()
                        .max(comparing(Client::getSalary))
                        .orElse(new Client())
            );
        }
        filtradoFinal.stream().forEach(x -> System.out.println(x));
    }

    private void m20ReduceMethod(){
        List<Integer>  resultadoSumatoria = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer lista = resultadoSumatoria.stream()
                .reduce(0, (sumatoria, elemento) -> sumatoria + elemento);
        System.out.println("La sumatoria del total de elementos de la lista es de " + lista+ " elementos");
    }
    
    private void m21Joinin(){
        List<String> firstList = Arrays.asList("Mario","Pedro","Maria","Angelica","Sonia","Armando","Roberto","Carmen","Rosario","Hortencia","Eliseo","Guadalupe");
        String resultList = firstList.stream().collect(Collectors.joining(","));

        System.out.print(resultList);
    }



}