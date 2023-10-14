package org.uma.mbd.mdUrna.urna;
import java.util.Random;

public class Urna {
    private int negras, blancas;

    private enum ColorBola{Blanca, Negra};

    private Urna(int nBlancas, int nNegras){
        if (nBlancas < 0 || nNegras < 0){
            throw new IllegalArgumentException("No se puede introducir un número de bolas negativo.");
        }
        negras = nNegras;
        blancas = nBlancas;
    }

    public int totalBolas(){
        return negras+blancas;
    }

    public ColorBola extraerBola(){
        Random r = new Random();
        int nBolas = totalBolas();
        return ColorBola.Blanca;
    }
}
