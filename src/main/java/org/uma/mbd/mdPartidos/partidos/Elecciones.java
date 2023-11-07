package org.uma.mbd.mdPartidos.partidos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.file.Files.createFile;
import static java.nio.file.Files.readAllLines;

public class Elecciones {
    private List<Partido> partidos;

    static private Partido stringToPartido(String dato){
        try(Scanner sc = new Scanner(dato)){
         sc.useDelimiter(",+");
         String name = sc.next();
         int nVotos = sc.nextInt();
         Partido newPartido = new Partido(name, nVotos);
         return newPartido;
        }catch(NoSuchElementException e){
            throw new EleccionesException("Error leyendo datos de la linea" + dato);
        }
        // HACER CON STREAMS?? TAKEWHILE HASTA LA COMA???
    }

    public void leeDatos(String [] datos){
        // toCollection and new ArrayList to be sure that create the one we want
        partidos = Arrays.stream(datos).map(linea -> stringToPartido(linea)).collect(Collectors.toCollection(()->new ArrayList<Partido>()));

    }
    public void leeDatos(String nombreFichero)throws IOException {
        Path path = Path.of(nombreFichero);
        String [] listaPartidos = readAllLines(path).toArray(new String [0]); // Size = 0 due to this blogpost I found https://shipilev.net/blog/2016/arrays-wisdom-ancients/
        leeDatos(listaPartidos);
    }

    public Map<Partido,Integer> generaResultados(CriterioSeleccion cs, int numEsc){
        return cs.ejecuta(partidos,numEsc);
    }

    public void presentaResultados(String nombreFichero, Map<Partido,Integer> map) throws FileNotFoundException{
        // print map entero, hacer pw??
    }
}
