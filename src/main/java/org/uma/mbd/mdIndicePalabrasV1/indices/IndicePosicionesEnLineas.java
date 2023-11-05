package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;
import java.util.stream.Collectors;

public class IndicePosicionesEnLineas extends Indice{

    private Map<String, Map<Integer, Set<Integer>>> indice;

    public IndicePosicionesEnLineas(){
        indice = new TreeMap<>();
    }

    @Override
    public void agregarLinea(String linea) {
        super.agregarLinea(linea);
        indice.clear();
    }
    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Collection<String> palabrasNS =  noSignificativas.stream().map(String::toLowerCase).collect(Collectors.toSet());
        for (String linea: texto) {
            try(Scanner sc = new Scanner(linea))
            {
                sc.useDelimiter(delimitadores);
                int posPalabra = 1;
                while(sc.hasNext()){
                    String palabra = sc.next().toLowerCase();
                    if(!palabrasNS.contains(palabra))
                    {
                        Set<Integer> listaPos = indice.computeIfAbsent(palabra, key -> new TreeMap<Integer,Set<Integer>>())
                                .computeIfAbsent(texto.indexOf(linea)+1, key -> new TreeSet<Integer>());
                        listaPos.add(posPalabra);
                    }
                    posPalabra++;
                }
            }
        }
    }

    @Override
    public void presentarIndiceConsola() {
        for (Map.Entry<String, Map<Integer,Set<Integer>>> entry: indice.entrySet()) {
            System.out.printf("%-15s\n", entry.getKey());
            for(Map.Entry<Integer,Set<Integer>> linea : entry.getValue().entrySet()) {
                System.out.printf("%10d\t\t", linea.getKey());
                for (Integer pos: linea.getValue()){
                    System.out.print(pos+".");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
