package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Indice1aLinea extends Indice{

    private Map<String,Integer> indice;

    public Indice1aLinea(){
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
                    indice.putIfAbsent(palabra, texto.indexOf(linea)+1);
                    }
                }
            }
        }
    }

    @Override
    public void presentarIndiceConsola() {
        indice.forEach((key,value) -> System.out.printf("%-15s %s \n",key, value));
    }
}
