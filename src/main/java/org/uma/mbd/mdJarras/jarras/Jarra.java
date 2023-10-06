package org.uma.mbd.mdJarras.jarras;

public class Jarra {

    private int capacidad;
    private int contenido;

    public Jarra(int capInicial){capacidad = capInicial;}

    public int getCapacidad() {return capacidad;}

    public int getContenido() {return contenido;}

    public void llena(){ contenido = capacidad;}

    public void vacia(){ contenido = 0;}

    public void llenaDesde(Jarra jarra_de_llenado) {

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
