package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.util.Map;

public class EleccionesManager {

    private String []datos;
    private int numEsc;
    private CriterioSeleccion cs;
    private Elecciones elecciones;
    private String fEntrada;
    private String fSalida;
    private boolean consola;

    public EleccionesManager(Elecciones elecciones){
        this.elecciones = elecciones;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }

    public EleccionesManager setNumEsc(int numEsc) {
        this.numEsc = numEsc;
    }

    public EleccionesManager setCriterioSeleccion(CriterioSeleccion cs) {
        this.cs = cs;
        return this;
    }

    public EleccionesManager setEntrada(String fEntrada) {
        this.fEntrada = fEntrada;
        return this;
    }

    public EleccionesManager setSalida(String fSalida) {
        this.fSalida = fSalida;
        return this;
    }

    public EleccionesManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    private void verify(){

    }

    public void build() throws IOException{
        verify();
        elecciones.leeDatos(fEntrada);
        Map<Partido,Integer> map = elecciones.generaResultados(cs,numEsc);
        elecciones.presentaResultados(fSalida,map);

    }

}
