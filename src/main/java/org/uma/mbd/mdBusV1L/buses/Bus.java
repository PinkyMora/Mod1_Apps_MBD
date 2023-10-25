package org.uma.mbd.mdBusV1L.buses;

import java.util.Objects;

public class Bus {
    private int codBus;
    private String matricula;
    private int codLinea;

    public Bus(int codigoBus, String matric){
        codBus = codigoBus;
        matricula = matric;

    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public int getCodBus() {
        return codBus;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCodLinea() {
        return codLinea;
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof Bus bus   && (codBus == ((Bus) obj).codBus)
                                        && (bus.matricula.equalsIgnoreCase(matricula));
    }

    @Override
    public int hashCode() {
        return Objects.hash(codBus,matricula.toLowerCase());
    }

    @Override
    public String toString() {
        // Hacer con stringjoiner???
        return "Bus("+codBus+","+matricula+","+codLinea+")";
    }
}
