package org.uma.mbd.mdAlturas.alturas;

public class MenoresQue implements Seleccion{
    private double alturaMax;

    public MenoresQue(double alturaMaxima){
        alturaMax = alturaMaxima;
    }

    @Override
    public boolean test(Pais pais) {
        return pais.altura() < alturaMax;
    }
}
