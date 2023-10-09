package org.uma.mbd.mdNPI;
import org.uma.mbd.mdNPI.npi.NPI;

public class Main {
    public static void main(String[] args) {
        NPI cpi = new NPI();

        System.out.println("** SIMULADOR DE CALCULADORA CON NOTACION POLACA INVERSA **");
        // Resolver la expresión: 3 * (6 - 2) + (2 + 7) / 5 -> en NPI: 3 6 2 - * 5 2 7 + / +
        System.out.println("Resolucion de 3 6 2 - * 5 2 7 + / + ");
        cpi.entra(3);
        System.out.println(cpi);
        cpi.entra(6);
        System.out.println(cpi);
        cpi.entra(2);
        System.out.println(cpi);
        cpi.resta();
        System.out.println(cpi);
        cpi.multiplica();
        System.out.println(cpi);
        cpi.entra(5);
        System.out.println(cpi);
        cpi.entra(2);
        System.out.println(cpi);
        cpi.entra(7);
        System.out.println(cpi);
        cpi.suma();
        System.out.println(cpi);
        cpi.divide();
        System.out.println(cpi);
        cpi.suma();
        System.out.println(cpi);
        System.out.println(" Resultado = " + cpi.getResultado());
    }
}
