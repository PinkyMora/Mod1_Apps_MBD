package org.uma.mbd.mdBusV2.buses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Servicio {
    private String ciudad;
    private Set<Bus> buses;

    public Servicio(String name) {
        ciudad = name;
        buses = new HashSet<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public Set<Bus> getBuses() {
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

    public Set<Bus> filtra(Criterio criterio, Comparator<Bus> cb){
        return buses.stream()
                .filter(criterio::esSeleccionable)
                .sorted(cb)
                .collect(Collectors.toCollection(TreeSet::new));
        // LinkedHashSet to have it sorted
    }

    public void guarda(String file, Criterio criterio, Comparator<Bus> cb) throws FileNotFoundException {

        // Closeable para cerrar archivo
        try(PrintWriter pw = new PrintWriter(file)){
            guarda(pw,criterio,cb);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio, Comparator<Bus> cb){

        Set<Bus> filtrada = filtra(criterio, cb);
        pw.println(criterio);
        for (Bus bus: filtrada){
            pw.println(bus);
        }
    }
}
