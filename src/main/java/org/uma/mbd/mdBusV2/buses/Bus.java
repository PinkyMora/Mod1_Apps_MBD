package org.uma.mbd.mdBusV2.buses;

import java.util.Comparator;
import java.util.Objects;

public class Bus implements Comparable<Bus> {
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
        return obj instanceof Bus bus   && (codBus == (bus.getCodBus()))
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

    @Override
    public int compareTo(Bus b1) {
        // Parece que salen al contrario
        int result= matricula.compareToIgnoreCase(b1.matricula);
        if (result == 0)
            result = Integer.compare(codBus, b1.codBus);
        return result;
    }

}
