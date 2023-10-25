package org.uma.mbd.mdBusV1L.buses;

public class EnMatricula implements Criterio{
    private String dato;

    public EnMatricula(String subMatric){
        dato = subMatric;
    }
    @Override
    public boolean esSeleccionable(Bus bus) {
        return bus.getMatricula().contains(dato);
    }

    @Override
    public String toString() {
        return "Autobuses cuya matricula contiene "+dato;
    }
}
