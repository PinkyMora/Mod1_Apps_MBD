package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public class Persona implements Comparable<Persona>{

    private String nombre;
    private Persona amigo;

    public Persona(String name){
        nombre = name;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getAmigo() {
        return amigo;
    }

    public void setAmigo(Persona am) {
        this.amigo = am;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Persona p && (nombre.toLowerCase().equals(p.getNombre().toLowerCase()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }

    @Override
    public int compareTo(Persona o) {
        return nombre.compareToIgnoreCase(o.getNombre());
    }

    @Override
    public String toString() {
        if (getAmigo() == null)
            return nombre +" --> sin amigo";

        return nombre +" --> "+amigo.getNombre();
    }
}
