package org.uma.mbd.mdJarras;
import org.uma.mbd.mdJarras.jarras.Jarra;

public class MainJarra {
    public static void main(String[] args) {
        Jarra j1 = new Jarra(7);
        var j2 = new Jarra(5);

        j1.llena();
        j2.llenaDesde(j1);

        j2.vacia();
        j2.llenaDesde(j1);

        j1.llena();
        j2.llenaDesde(j1);

        j2.vacia();



        j1.llenaDesde(j2);
        System.out.println("J1: " +j1);
        System.out.println("J2: " +j2);

        ;
    }
}
