package org.uma.mbd.mdLibreriaV3L.libreria;

public class OfertaPrecio implements OfertaFlex{

    private double descuento;
    private double umbral;

    public OfertaPrecio( double d, double umb){
        descuento = d;
        umbral = umb;
    }

    @Override
    public double getDescuento(Libro libro){
        return (libro.getPrecioBase() >= umbral)? descuento : 0;
    }

    @Override
    public String toString(){
        return descuento+"%("+umbral+")";
    }

}
