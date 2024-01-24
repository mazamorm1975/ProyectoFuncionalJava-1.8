package org.java_12_17;

public class Product {

    private final int id;
    private final String nombre;

    private final double price;

    private final boolean status;


    public Product(int id, String nombre, double price, boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }
}
