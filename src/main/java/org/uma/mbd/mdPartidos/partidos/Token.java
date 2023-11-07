package org.uma.mbd.mdPartidos.partidos;

import java.util.Map;
import java.util.Set;

public class Token implements Comparable<Token>{
    private Partido partido;
    private double ratio;

    public Token(Partido partido, double ratio) {
        this.partido = partido;
        this.ratio = ratio;
    }

    public Partido getPartido() {
        return partido;
    }

    public double getRatio() {
        return ratio;
    }

    public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc){

    }

    public static Map<Partido, Integer> generaResultados(Set<Token> tks){

    }

    @Override
    public int compareTo(Token o) {
        var result = Double.compare(ratio,o.getRatio());
        if (result == 0)
            result = partido.getNombre().compareToIgnoreCase(o.getPartido().getNombre());

        return result;
    }
}
