package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturasV2.alturas.EnContinente;
import org.uma.mbd.mdAlturasV2.alturas.MenoresQue;
import org.uma.mbd.mdAlturasV2.alturas.Mundo;
import org.uma.mbd.mdAlturasV2.alturas.Pais;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainMundo {
    public static void main(String args[]) throws IOException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");

        List<Pais> listaPaises = paises.selecciona(new MenoresQue(1.70));

        //  APARTADO A
        Comparator<Pais> cAlturaAsc =
                Comparator.comparingDouble(Pais::altura);
        Set<Pais> alturasAsc= new TreeSet<>(cAlturaAsc);
        alturasAsc.addAll(listaPaises);
        System.out.println("Paises ordenados por Altura en orden Ascendente");
        alturasAsc.forEach(System.out::println);

        //  APARTADO B
        System.out.println();
        Comparator<Pais> cAlfabet =
                Comparator.comparing(p-> p.nombre().toLowerCase());
        Set<Pais> alturasAlf= new TreeSet<>(cAlfabet);
        alturasAlf.addAll(listaPaises);
        System.out.println("Paises ordenados alfabéticamente");
        alturasAlf.forEach(System.out::println);

        //  APARTADO C
        System.out.println();
        Comparator<Pais> cContinente =
                Comparator.comparing(p-> p.continente().toLowerCase());
        Comparator<Pais> cContYAlf = cContinente.thenComparing(cAlfabet);
        Set<Pais> contYAlf= new TreeSet<>(cContYAlf);
        contYAlf.addAll(listaPaises);
        System.out.println("Paises ordenados por continente y a igualdad, alfabéticamente");
        contYAlf.forEach(System.out::println);

        //  APARTADO D
        System.out.println();
        Comparator<Pais> cContYAlfReversed = cContinente.thenComparing(cAlfabet.reversed());
        Set<Pais> contYAlfReversed= new TreeSet<>(cContYAlfReversed);
        contYAlfReversed.addAll(listaPaises);
        System.out.println("Paises ordenados por continente y a igualdad, alfabéticamente en orden inverso");
        contYAlfReversed.forEach(System.out::println);

        //  APARTADO E
        System.out.println();
        Comparator<Pais> cNatural = Comparator.naturalOrder();
        Set<Pais> natural= new TreeSet<>(cNatural);
        natural.addAll(listaPaises);
        System.out.println("Paises ordenados por su orden natural");
        natural.forEach(System.out::println);

        //  APARTADO F
        System.out.println();
        Comparator<Pais> cContYNatural = cContinente.thenComparing(cNatural);
        Set<Pais> contYNatural= new TreeSet<>(cContYNatural);
        contYNatural.addAll(listaPaises);
        System.out.println("Paises ordenados por continente y a igualdad, su orden natural");
        contYNatural.forEach(System.out::println);

    }
}