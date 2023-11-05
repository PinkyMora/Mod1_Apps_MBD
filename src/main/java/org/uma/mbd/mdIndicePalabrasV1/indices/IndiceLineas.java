package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IndiceLineas extends Indice{

    private Map<String, Set<Integer>> indice;

    public IndiceLineas(){
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
                while(sc.hasNext()){
                    String palabra = sc.next().toLowerCase();
                    if(!palabrasNS.contains(palabra))
                    {
                        Set<Integer> listaPos = indice.computeIfAbsent(palabra, key -> new TreeSet<Integer>());
                        listaPos.add(texto.indexOf(linea)+1);
                    }
                }
            }
        }
    }

    @Override
    public void presentarIndiceConsola() {

        for (Map.Entry<String, Set<Integer>> entry: indice.entrySet()) {
            System.out.printf("%-15s", entry.getKey());
            for(Integer pos : entry.getValue()) {
                System.out.print(pos+".");
            }
            System.out.println();
        }
    }
}
