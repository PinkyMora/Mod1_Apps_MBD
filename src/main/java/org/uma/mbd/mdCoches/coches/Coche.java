package org.uma.mbd.mdCoches.coches;

public class Coche {
    private String nombre;
    private double precio;
    private static double PIVA = 16;

    public static void setPIVA(double PIVA) {Coche.PIVA = PIVA;}

    public double precioTotal() {return precio+(precio*16/100);}
}
