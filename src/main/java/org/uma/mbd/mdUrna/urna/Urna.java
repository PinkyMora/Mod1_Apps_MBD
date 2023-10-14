package org.uma.mbd.mdUrna.urna;
import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    private int blancas, negras;
    static private Random r = new Random();

    public enum ColorBola{Blanca, Negra};

    public Urna(int nBlancas, int nNegras){
        if (nBlancas < 0 || nNegras < 0){
            throw new IllegalArgumentException("No se puede introducir un numero de bolas negativo.");
        }
        blancas = nBlancas;
        negras = nNegras;
    }

    public int totalBolas(){
        return negras+blancas;
    }

    public ColorBola extraerBola() {

        int nBolas = totalBolas();
        if (nBolas <= 0) {
            throw new NoSuchElementException("Urna vacia, no hay bolas para extraer.");
        }
        int bola = r.nextInt(nBolas);
        if (bola < blancas) {
            blancas--;
            return ColorBola.Blanca;
        } else {
            negras--;
            return ColorBola.Negra;
        }
    }
    public void ponerBlanca(){ blancas++; }

    public void ponerNegra(){ negras++; }

    @Override
    public String toString(){
        return "(B: "+blancas+", N: "+negras+")";
    }
}
