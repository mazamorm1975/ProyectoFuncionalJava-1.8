package org.java_12_17.sealedClasesAndRecord;

public record ProductRecord (
        int id,
        String nombre,
        double price,
        boolean status
//En los objetos de tipo record se pueden implementar varias interfaces
) implements  Fabric , Fabric2, Fabric3{

    public ProductRecord(String nombre){
        this(1, "Monitor Acer 4", 4351.12, true);
    }

    public static int idProducto = 458787878;

    @Override
    public void testFabric() {
        System.out.println("Test de prueba sobre implementación de interfaces");
    }

    @Override
    public void testFabric2() {
        System.out.println("Test de prueba sobre implementación de interfaz Fabrica 2");
    }

    @Override
    public void testFabric3() {
        System.out.println("Test de prueba sobre implementación de interfaz Fabrica 3");
    }
}
