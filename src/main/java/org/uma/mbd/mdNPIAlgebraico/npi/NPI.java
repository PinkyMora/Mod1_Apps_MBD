package org.uma.mbd.mdNPIAlgebraico.npi;

import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class NPI {

    private double x,y,z,t;

    public void entra(double valor){
        t=z;
        z=y;
        y=x;
        x=valor;
    }
    public double evalua(List<Elem> lista){
        for (var c: lista)
            switch(c){
                case Valor(double x) -> entra(x);
                case Fun(DoubleUnaryOperator op ) -> opera1(op);
                case Fun2(DoubleBinaryOperator op) -> opera2(op);
            }
        return x;
    }

    public void opera1(DoubleUnaryOperator op){
        x =  op.applyAsDouble(x);
    }
    public void opera2(DoubleBinaryOperator op){
        x = op.applyAsDouble(y,x);
        z = t;
        y = z;
    }

    @Override

    public String toString(){
        return "NPI(x="+x+", y="+y+", z="+z+", t="+t+")";
    }
}
