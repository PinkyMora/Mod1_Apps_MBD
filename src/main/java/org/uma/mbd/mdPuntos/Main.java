package org.uma.mbd.mdPuntos;
import org.uma.mbd.mdPuntos.Puntos.Segmento;

public class Main
{
    public static void main(String[] args) {
        Segmento s1 = new Segmento(2,3,1,-1);
        System.out.println(s1);
        System.out.println(s1.longitud());
    }
}
