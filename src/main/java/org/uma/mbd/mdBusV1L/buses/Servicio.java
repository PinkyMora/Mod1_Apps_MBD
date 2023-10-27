package org.uma.mbd.mdBusV1L.buses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Servicio {
    private String ciudad;
    private List<Bus> buses;

    public Servicio(String name) {
        ciudad = name;
        buses = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws IOException {

        Path fichero = Path.of(file);
        try(BufferedReader br = Files.newBufferedReader(fichero)){
            String linea = br.readLine();
            while(linea != null){
                Bus busAdd = null;
                try(Scanner sc = new Scanner(linea);){
                    sc.useDelimiter(",");
                    int codigo = sc.nextInt();
                    String plate = sc.next();
                    int cLinea = sc.nextInt();
                    busAdd = new Bus(codigo,plate);
                    busAdd.setCodLinea(cLinea);
                    buses.add(busAdd);
                }catch (InputMismatchException e){
                    System.err.println("Error de fichero. Número erróneo en la linea:" + linea);
                }catch (NoSuchElementException e){
                    System.err.println("Error de fichero. Faltan datos en la linea:" + linea);
                }
                linea = br.readLine();
            }
        }
    }

    public List<Bus> filtra(Criterio criterio){
        return buses.stream()
                .filter(bus -> criterio.esSeleccionable(bus))
                .toList();
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException {

        // Closeable para cerrar archivo
        try(PrintWriter pw = new PrintWriter(file)){
            guarda(pw,criterio);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio){

        List<Bus> filtrada = filtra(criterio);
        pw.println(criterio);
        for (Bus bus: filtrada){
            pw.println(bus);
        }
    }
}
