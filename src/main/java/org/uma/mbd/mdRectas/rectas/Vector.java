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
        this(extremoNew.getX() - origen.getX(), extremoNew.getY() - origen.getY());
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
