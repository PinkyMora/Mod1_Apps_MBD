package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class DHontSimple implements CriterioSeleccion{
    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {

        Set<Token> tks = creaTokens(partidos,numEsc);
        Set<Token> tksSelec = Token.seleccionaTokens(tks, numEsc);
        return Token.generaResultados(tksSelec);
    }

    private Set<Token> creaTokens(List<Partido> partidos, int numEsc){

        return partidos.stream()
                .flatMap(partido -> IntStream.rangeClosed(1,numEsc)
                        .mapToObj(x -> new Token(partido, (partido.getVotos()/x))))
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
