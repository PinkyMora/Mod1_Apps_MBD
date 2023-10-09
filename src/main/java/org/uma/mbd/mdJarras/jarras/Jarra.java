package org.uma.mbd.mdJarras.jarras;

public class Jarra {

    private final int capacidad;
    private int contenido;

    public Jarra(int capInicial){
        if (capInicial <= 0)
            throw new IllegalArgumentException("No se puede crear una Jarra con capacidad " + capInicial);

        capacidad = capInicial;
        this.vacia();
    }

    public int getCapacidad() {return capacidad;}

    public int getContenido() {return contenido;}

    public void llena(){ contenido = capacidad;}

    public void vacia(){ contenido = 0;}

    public void llenaDesde(Jarra jarra_de_llenado) {

        if (this == jarra_de_llenado)
            throw new IllegalArgumentException("No se puede volcar una jarra sobre si misma");

        // Objects.requireNonNull(jarra_de_llenado, "La Jarra no existe");
        // Clase Objects ayuda con excepciones.
        int cabe = capacidad - contenido;
        if (cabe >= jarra_de_llenado.contenido) {
            contenido += jarra_de_llenado.contenido;
            jarra_de_llenado.vacia();
        } else {
            jarra_de_llenado.contenido -= cabe;
            this.llena();
        }
    }
    @Override

    public String toString(){
        return "J("+capacidad+", "+contenido+")";
    }
}
