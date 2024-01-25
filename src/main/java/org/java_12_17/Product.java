package org.java_12_17;

import lombok.NoArgsConstructor;
import org.java_12_17.ClaseSellada;
@NoArgsConstructor(force = true)
public non-sealed class Product extends ClaseSellada{

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
