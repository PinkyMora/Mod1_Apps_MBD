package org.uma.mbd.mdBusV1L;

import org.uma.mbd.mdBusV1L.buses.Bus;
import org.uma.mbd.mdBusV1L.buses.Servicio;

import java.io.IOException;

public class MainPrueba {
    public static void main(String[] args) throws IOException{
        Servicio service = new Servicio("Málaga");
        service.leeBuses("recursos/mdBusV1/buses.txt");

        System.out.println(service.getBuses());
    }
}
