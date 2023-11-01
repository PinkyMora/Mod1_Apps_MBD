package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.IOException;
import java.io.PrintWriter;

public class ClubManager {

    private String fEntrada;
    private String delimitador;
    private String fSalida;
    private boolean consola;
    private Club club;

    public ClubManager(Club club){
        this.club = club;
    }

    public ClubManager setEntrada(String fEntr, String delim){
        fEntrada = fEntr;
        delimitador = delim;
        return this;
    }

    public ClubManager setSalida(String salida){
        fSalida = salida;
        return this;
    }

    public ClubManager setConsola(boolean console){
        consola = console;
        return this;
    }

    private void verify(){

        if(fEntrada == null | (fSalida == null && consola == false))
            throw new AmigoException("Fichero de entrada o salida no encontrado");

    }

    public void build() throws IOException {
        verify();
        club.lee(fEntrada,delimitador);
        club.hacerAmigos();
        if (consola)
            club.presentaAmigos(new PrintWriter(System.out,true));
        if (fSalida != null)
            club.presentaAmigos(fSalida);
    }
}
