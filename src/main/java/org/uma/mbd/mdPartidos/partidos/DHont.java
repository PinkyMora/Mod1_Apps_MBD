package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DHont extends DHontSimple{
    private double minPor;

    public DHont(double mp){
        if(mp<0 || mp >=15){
            throw new EleccionesException("Porcentaje no valido.");
        }
        minPor = mp/100;
    }

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        int totalVotos = partidos.stream().mapToInt(partido -> partido.getVotos()).sum();
        List<Partido> partidos1 = partidos.stream().filter(partido -> (double)partido.getVotos()/totalVotos > minPor ).collect(Collectors.toList());
        return super.ejecuta(partidos1, numEsc);
    }
}
