package org.uma.mbd.mdTestL.tests;

import java.util.Objects;

public record Test(String alumno, int aciertos, int errores) {
    @Override
    public boolean equals(Object obj){
        return obj instanceof Test test && test.alumno.equalsIgnoreCase(alumno);
    }

    @Override
    public int hashCode(){
        return Objects.hash(alumno);
    }

    public double calificacion(double valAc, double valErr){
        return (valAc*aciertos + valErr*errores);
    }

}
