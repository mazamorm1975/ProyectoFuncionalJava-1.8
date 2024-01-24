package org.java_12_17;



public class RecordApp {

    public static void main(String[] args) {

        Product prod = new Product(1,"handbag", 984.54, true);
        System.out.println(prod.getId());
        System.out.println(prod.getNombre());
        System.out.println(prod.getPrice());
        System.out.println(prod.isStatus());

        System.out.println("\n");

        ProductRecord prodRec = new ProductRecord(1,"handbag", 984.54, true);
        System.out.println(prodRec.id());
        System.out.println(prodRec.nombre());
        System.out.println(prodRec.price());
        System.out.println(prodRec.status());

          }
}
