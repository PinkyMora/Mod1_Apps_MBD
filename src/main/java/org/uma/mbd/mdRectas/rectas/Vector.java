package org.uma.mbd.mdRectas.rectas;

public class Vector {

    private Punto extremo;

    public Vector(double x, double y){
        extremo = new Punto(x,y);
    }
    public Vector(Punto pto){
        this(pto.getX(), pto.getY());
    }
    public Vector(Punto origen, Punto extremoNew){
        // I don't know at which point this is efficient and usable
        Punto puntotrasladado = new Punto(extremoNew.getX(), extremoNew.getY());
        puntotrasladado.trasladar(origen.getX(), origen.getY());
        extremo = puntotrasladado;
    }
    public Punto extremoDesde(Punto org){
        Punto extremoNow = new Punto(getComponenteX(), getComponenteY());
        extremoNow.trasladar(org.getX(), org.getY());
        return extremoNow;
    }
    public double getComponenteX(){
        return extremo.getX();
    }
    public double getComponenteY(){
        return extremo.getY();
    }
    public double modulo(){
        return (Math.sqrt(Math.pow(extremo.getX(), 2)+Math.pow(extremo.getY(), 2)));
    }
    public Vector ortogonal(){
        return new Vector(-getComponenteY(),getComponenteX());
    }
    public boolean paraleloA(Vector vec){
        return (getComponenteX()* vec.getComponenteY() == getComponenteY()* vec.getComponenteX()) ? true : false;
    }

    @Override
    public String toString(){
        return "V(" +extremo.getX()+", "+extremo.getY()+")";
    }
}
