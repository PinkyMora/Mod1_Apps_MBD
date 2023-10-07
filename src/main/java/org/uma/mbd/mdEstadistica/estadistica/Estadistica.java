package org.uma.mbd.mdEstadistica.estadistica;
import static java.lang.Math.*;
public class Estadistica {

    private int numElementos;
    private double sumaX, sumaX2;

    public void agrega(double d){

        numElementos++;
        sumaX += d;
        sumaX2 += pow(d,2);
    }

    public void agrega(double d, int n){
        numElementos += n;
        sumaX += n*d;
        sumaX2 += n*pow(d,2);
    }

    public double media(){
        return sumaX/numElementos;
    }
    public double varianza(){
        return (sumaX2/numElementos - pow(media(),2));
    }

    public double desviacionTipica(){
        return sqrt(varianza());
    }
}
