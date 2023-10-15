package org.uma.mbd.mdTesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdTesoro.tesoro.Tesoro;

public class MainTesoro {
    public static void main(String[] args) {
        Punto palmeraAmarilla = new Punto(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        Punto palmeraAzul = new Punto(Double.parseDouble(args[2]),Double.parseDouble(args[3]));
        Punto palmeraRosa = new Punto(Double.parseDouble(args[4]),Double.parseDouble(args[5]));

        Tesoro tesoro = new Tesoro(palmeraAmarilla, palmeraAzul, palmeraRosa);

        System.out.println("Estaca Amarilla: "+tesoro.getEstacaAmarilla());
        System.out.println("Estaca Azul: "+tesoro.getEstacaAzul());
        System.out.println("Tesoro en la posicion: "+tesoro.getTesoro());
    }
}

