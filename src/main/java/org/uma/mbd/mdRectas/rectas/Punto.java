package org.uma.mbd.mdRectas.rectas;

public class Punto {

    private double x, y;
    public Punto(double a, double b) {
        x = a; y = b;
    }
    public Punto() { this(0,0); }

    public double getX() { return x; }
    public double getY() { return y; }
    public void trasladar(double a, double b) {
        x += a; y += b;
    }
    public void setX(double a){ x = a; }
    public void setY(double b){ y = b; }

    public double distancia(Punto pto) {
        return Math.sqrt(Math.pow(x - pto.x, 2) +
                Math.pow(y - pto.y, 2));
    }

    @Override
    public String toString(){
        return "P(" +x+", "+y+")";
    }

}
