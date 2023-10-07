package org.uma.mbd.mdJarras;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class MainAppMesa {

    public static void main(String[] args) {

        Mesa mesa = new Mesa(7,5);

        System.out.println("Estado Inicial: " + mesa);
        mesa.llenaB();
        System.out.println("Paso 1:         " + mesa);
        mesa.vuelcaBSobreA();
        System.out.println("Paso 2:         " + mesa);
        mesa.llenaB();
        System.out.println("Paso 3:         " + mesa);
        mesa.vuelcaBSobreA();
        System.out.println("Paso 4:         " + mesa);
        mesa.vaciaA();
        System.out.println("Paso 5:         " + mesa);
        mesa.vuelcaBSobreA();
        System.out.println("Paso 6:         " + mesa);
        mesa.llenaB();
        System.out.println("Paso 7:         " + mesa);
        mesa.vuelcaBSobreA();
        System.out.println("Paso Final:     " + mesa);


    }


}
