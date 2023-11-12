package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Proporcional implements CriterioSeleccion{
    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {

        Set<Token> tks = creaTokens(partidos, numEsc);
        tks = Token.seleccionaTokens(tks, numEsc);
        return Token.generaResultados(tks);
    }

    private Set<Token> creaTokens(List<Partido> partidos, int numEsc){

        // Int? Cannot be decimal, votes are int, it couldnt be 1,5 votos.
        int vpe = partidos.stream().mapToInt(Partido::getVotos).sum() / numEsc;

        return partidos.stream()
                .flatMap(partido -> IntStream.range(0,numEsc)
                        .mapToObj(x -> new Token(partido, (partido.getVotos()-x*vpe))))
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
