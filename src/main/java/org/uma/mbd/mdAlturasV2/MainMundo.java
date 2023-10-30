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

        Comparator<Pais> cAlturaAsc =
                Comparator.comparingDouble(Pais::altura);
        Set<Pais> alturasAsc= new TreeSet<>(cAlturaAsc);
        alturasAsc.addAll(listaPaises);

        Comparator<Pais> cAlfabet =
                (p1,p2) -> p1.nombre().compareToIgnoreCase(p2.nombre());
                //Comparator.comparing((p1,p2) -> p1.nombre().compareToIgnoreCase(p2.nombre()));



        for (Pais pais : paises.selecciona(new MenoresQue(1.70))) {
            System.out.println(pais);
        }
        System.out.println();
        for (Pais pais : paises.selecciona(new EnContinente("Europe"))) {
            System.out.println(pais);
        }


    }
}