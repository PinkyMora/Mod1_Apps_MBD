package org.uma.mbd.mdLibreriaV4.libreria;

import java.util.Objects;

public class Libro {

    private String autor, titulo;
    private double precioBase;
    private static double IVA = 10;

    public Libro(String nombreAutor, String tituloLibro, double precioBaseLibro){
        autor = nombreAutor;
        titulo = tituloLibro;
        precioBase = precioBaseLibro;
    }

    public String getAutor(){ return autor;}

    public String getTitulo(){ return titulo;}

    public double getPrecioBase(){ return precioBase;}

    public double getPrecioFinal(){ return precioBase + (precioBase*(IVA/100));}

    public static double getIVA() { return IVA;}

    public static void setIVA(double IVA) {Libro.IVA = IVA;}

    @Override
    public String toString(){
        return "("+autor+"; "+titulo+"; "+precioBase+"; "+IVA+"%; "+getPrecioFinal()+")";
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof Libro libro && libro.autor.equalsIgnoreCase(autor)
                                        && libro.titulo.equalsIgnoreCase(titulo);
    }

    @Override
    public int hashCode(){
        return Objects.hash(autor.toLowerCase(), titulo.toLowerCase());
    }
}
