package org.uma.mbd.mdPartidos.partidos;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

    public static Set<Token> seleccionaTokens(Set<Token> tks, int numEsc){
        return tks.stream().limit(numEsc).collect(Collectors.toCollection(TreeSet::new));
    }

    public static Map<Partido, Integer> generaResultados(Set<Token> tks){
        return tks.stream()
                .collect(Collectors.groupingBy(Token::getPartido, Collectors.summingInt(n -> 1)));
    }

    @Override
    public int compareTo(Token o) {
        var result = Double.compare(o.getRatio(),ratio);
        if (result == 0)
            result = partido.getNombre().compareToIgnoreCase(o.getPartido().getNombre());

        return result;
    }
}
