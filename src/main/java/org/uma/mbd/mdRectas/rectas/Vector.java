package org.uma.mbd.mdRectas.rectas;

public class Vector {

    private Punto extremo;
    public Vector(double x, double y){
        extremo = new Punto(x,y);
    }
    public Vector(Punto pto){
        extremo = new Punto(pto.getX(), pto.getY());
    }
    public Vector(Punto origen, Punto extremoNew){
        extremoNew.trasladar(-1*origen.getX(), -1*origen.getY());
        new Vector(extremoNew);
    }

    @Override
    public String toString(){
        return "V(" +extremo.getX()+", "+extremo.getY()+")";
    }
}
