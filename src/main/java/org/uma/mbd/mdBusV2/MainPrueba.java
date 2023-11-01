package org.uma.mbd.mdBusV2;


import org.uma.mbd.mdBusV2.buses.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Set;

public class MainPrueba {
    public static void main(String[] args) {
        try {
            Servicio emt = new Servicio("Málaga");
            emt.leeBuses("recursos/mdBusV1/buses.txt");

            Comparator<Bus> cbon = Comparator.naturalOrder();

            Set<Bus> set = emt.filtra(new PorLinea(21), cbon);

            System.out.println(set);

            Comparator<Bus> cLin =
                    (b1, b2) -> Integer.compare(b1.getCodLinea(),b2.getCodLinea());
            Comparator<Bus> cCod =
                    (b1,b2) -> Integer.compare(b1.getCodBus(), b2.getCodBus());
            Comparator<Bus> c1 = cLin.thenComparing(cCod);

            emt.guarda(new PrintWriter(System.out, true),
                    new EnMatricula("A"),
                    cbon);

        } catch (IOException e) {
            System.err.println("Fichero no encontrado " + e.getMessage());
        }

    }
}
