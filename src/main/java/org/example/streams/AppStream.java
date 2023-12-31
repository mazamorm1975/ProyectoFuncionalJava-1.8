package org.example.streams;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;
import static java.util.stream.Collectors.*;
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
        Client e15 = new Client(14, "Client23", "Manager III", LocalDate.of(1980, 9, 2), 2000.00, "Peru");

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
        */
        app.m15GroupBy(clientList);
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
                .sorted(Comparator.comparing(Client::getJob))
                .toList().reversed();
        listadoClientes.forEach(System.out::println);

        System.out.println("\n");
        //Listado ordenado en orden de A - Z, con referencia al salario del empleado
        //SIN utilizar metodos referenciados
        clienList.stream()
                .sorted(Comparator.comparing(x -> x.getSalary()))
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
                .sorted(Comparator.comparing(Client::getTime))
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
                .max(Comparator.comparing(x -> x.getSalary()))
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
        Map<String, List<Client>>countryList = clientList.stream()
                .collect(groupingBy(e -> e.getCountry()));
        System.out.println(countryList);

       Map<String, Map<String, List<Client>>> listadoClientes = clientList.stream()
                .collect(groupingBy(e -> e.getCountry(), groupingBy(e-> e.getJob())));
        System.out.println(listadoClientes);
    }
}