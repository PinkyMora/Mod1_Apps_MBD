package org.uma.mbd.mdAlturasV2.alturas;

public record Pais(String nombre, String continente, double altura) implements Comparable<Pais>{
    @Override
    public int compareTo(Pais o) {

        int result = Double.compare(altura,o.altura);
        if (result == 0)
                result =  nombre.compareToIgnoreCase(o.nombre);
        return result;
    }
}
