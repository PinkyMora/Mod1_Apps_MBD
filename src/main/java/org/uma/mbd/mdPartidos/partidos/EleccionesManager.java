package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.io.PrintWriter;
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

    public EleccionesManager setDatos(String[] datos) {
        this.datos = datos;
        return this;
    }

    public EleccionesManager setNumEsc(int numEsc) {
        this.numEsc = numEsc;
        return this;
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
        boolean salida = fSalida == null && consola == false;
        boolean entrada = fEntrada == null && datos == null;
        boolean entradaUnica = (fEntrada != null && datos != null);
        boolean criterio = cs == null;
        boolean escanos = numEsc<=0;
        if(entrada || entradaUnica || salida || criterio || escanos)
            throw new EleccionesException("No se pueden realizar estas elecciones, revise sus características");

    }

    public void build() throws IOException{
        verify();
        if(fEntrada!= null)
            elecciones.leeDatos(fEntrada);
        else
            elecciones.leeDatos(datos);
        Map<Partido,Integer> map = elecciones.generaResultados(cs,numEsc);

        if (consola)
            elecciones.presentaResultados(new PrintWriter(System.out,true),map);
        if (fSalida != null)
            elecciones.presentaResultados(fSalida,map);
    }

}
