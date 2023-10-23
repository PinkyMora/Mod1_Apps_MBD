package org.uma.mbd.mdLibreriaV4.libreria;

public class LibroEnOferta extends Libro {
    private double descuento;

    public LibroEnOferta(String autor, String titulo, double precioBase, double desc){
        super(autor,titulo,precioBase);
        descuento = desc;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecioFinal() {
        double pf = super.getPrecioFinal();
        return (pf - pf*descuento/100);
    }

    @Override
    public String toString(){
        return "("+getAutor()+"; "+getTitulo()
                +"; "+getPrecioBase()+"; "+descuento
                +"%; "+(getPrecioBase()*(1-descuento/100)
                +"%; "+getIVA()+"; "+getPrecioFinal()+")");
    }

}
