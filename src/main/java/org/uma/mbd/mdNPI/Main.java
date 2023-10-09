package org.uma.mbd.mdNPI;
import org.uma.mbd.mdNPI.npi.NPI;

public class Main {
    public static void main(String[] args) {
        NPI cpi = new NPI();

        System.out.println("** CALCULADORA CON NOTACION POLACA INVERSA **");
        // Resolver la expresión: 3 * (6 - 2) + (2 + 7) / 5 -> en NPI: 3 6 2 - * 5 2 7 + / +
        System.out.println("Calculo de 3 6 2 - * 5 2 7 + / + ");
        cpi.entra(3);
        cpi.entra(6);
        cpi.entra(2);
        cpi.resta();
        cpi.multiplica();
        cpi.entra(5);
        cpi.entra(2);
        cpi.entra(7);
        cpi.suma();
        cpi.divide();
        cpi.suma();
        System.out.println("Resultado = " + cpi.getResultado());
    }
}
