package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;

    public Recta(Punto pto1, Punto pto2){
        direccion = new Vector(pto2.getX()-pto1.getX(), pto2.getY()-pto1.getY());
        pto = pto1;
    }
    public Recta(Vector vctDireccion, Punto pto1){
        direccion = vctDireccion;
        pto = pto1;
    }

    public boolean paralelaA(Recta recta){
        return (recta.direccion.paraleloA(direccion)) ? true : false;
    }

    public boolean pasaPor(Punto p){
        Vector nuevo = new Vector(p,pto);
        return (nuevo.paraleloA(direccion)) ? true : false;
    }
    protected record Implicita(double a, double b, double c){}

    private Implicita implicita(){
        double vx = direccion.getComponenteX();
        double vy = direccion.getComponenteY();
        double px = pto.getX();
        double py = pto.getY();

        double a = 1/vx;
        double b = -1/vy;
        double c = (py/vy)-(px/vx);

        return new Implicita(a,b,c);
    }

    private double determinante(double a11, double a12, double a21, double a22){
        return a11*a22 - a12*a21;
    }
    public Punto interseccionCon(Recta recta){
        Implicita implicita1 = recta.implicita();
        Implicita implicita2 = implicita();

        double denominadorX = determinante(implicita1.a, implicita1.b, implicita2.a,implicita2.b);
        double denominadorY = determinante(implicita1.a, implicita1.b, implicita2.a,implicita2.b);
        if (denominadorX == 0 || denominadorY == 0 ) {
            throw new IllegalArgumentException("Rectas Paralelas, no existe interseccion");
        }else {
            double numeradorX = determinante(implicita1.a, -implicita1.c, implicita2.a, -implicita2.c);
            double numeradorY = determinante(-implicita1.c, implicita1.b, -implicita2.c, implicita2.b);
            return new Punto((numeradorX/denominadorX),(numeradorY/denominadorY));
        }
    }

    public Recta paralelaPor (Punto p){
        return new Recta(direccion,p);
    }

    public Recta perpendicularPor(Punto p){
        return new Recta(direccion.ortogonal(),p);
    }

    public double distanciaDesde(Punto p){
        Recta perpendicular = perpendicularPor(p);

        Punto interseccion = this.interseccionCon(perpendicular);

        return interseccion.distancia(p);
    }

    @Override
    public String toString(){
        return "R("+direccion+", "+pto+")";
    }
}

