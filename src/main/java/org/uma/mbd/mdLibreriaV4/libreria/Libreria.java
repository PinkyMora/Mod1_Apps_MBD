package org.uma.mbd.mdLibreriaV4.libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {

    protected List<Libro> libros;

    public Libreria(){
        libros = new ArrayList<>();
    }

    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    protected void addLibro(Libro libro) {

        int pos = libros.indexOf(libro);
        if (pos < 0) {
            // El libro no esta
            libros.add(libro);
        } else {
            // El libro esta
            libros.set(pos,libro);
        }
    }

//    private int posicionLibro(String autor, String titulo){
//        int pos = 0;
//        while(pos<libros.size() && !(autor.equalsIgnoreCase(libros.get(pos).getAutor()) && (titulo.equalsIgnoreCase(libros.get(pos).getTitulo()))))
//            pos++;
//        return (pos == libros.size()) ? -1 : pos;
//    }

    public void remLibro(String autor, String titulo){

        Libro libro = new Libro(autor, titulo, 0);
        libros.remove(libro);
    }

    public double getPrecioBase(String autor, String titulo){
        Libro libro = new Libro(autor, titulo,0);
        int pos = libros.indexOf(libro);
        return pos >= 0 ? libros.get(pos).getPrecioBase() : 0;
    }

    public double getPrecioFinal(String autor, String titulo){
        Libro libro = new Libro(autor, titulo,0);
        int pos = libros.indexOf(libro);
        return pos >= 0 ? libros.get(pos).getPrecioFinal() : 0;
    }

    @Override
    public String toString(){
        return libros.toString();
    }
}

