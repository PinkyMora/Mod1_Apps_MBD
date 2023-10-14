package org.uma.mbd.mdUrna;
import org.uma.mbd.mdUrna.urna.Urna;

public class MainUrna {
    public static void main(String[] args) {
        int nBlancas = Integer.parseInt(args[0]);
        int nNegras  = Integer.parseInt(args[1]);

        Urna urna = new Urna(nBlancas,nNegras);
        System.out.println("Creamos urna con los datos introducidos por parametro: "+urna);

        while (urna.totalBolas() > 1){
            Urna.ColorBola bola1 = urna.extraerBola();
            Urna.ColorBola bola2 = urna.extraerBola();

            System.out.println("Bola 1: "+bola1+" y Bola 2: "+bola2);
            // equals o ==??? Redefinir equals???
            if ((bola1.equals(bola2))) {
                urna.ponerBlanca();
                System.out.println("Iguales. Metemos bola blanca");
            } else {
                urna.ponerNegra();
                System.out.println("Difieren. Metemos bola negra");
            }
            System.out.println("Urna actualmente: "+urna);
        }
        System.out.println("Color de la última bola: "+urna.extraerBola());
    }
}
