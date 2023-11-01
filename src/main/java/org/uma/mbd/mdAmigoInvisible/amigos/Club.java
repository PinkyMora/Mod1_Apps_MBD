package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Club {

    protected List<Persona> socios;

    public Club(){
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws IOException{
        Path fichero = Path.of(fEntrada);
        try(BufferedReader br = Files.newBufferedReader(fichero)){
            String linea = br.readLine();
            while(linea != null){
                leeSocios(linea,delim);
                linea = br.readLine();
            }
        }
    }

    public void leeSocios(String linea, String delim){
        try(Scanner sc = new Scanner(linea);) {
            sc.useDelimiter(delim);
            while (sc.hasNext()) {
                String nombre = sc.next();
                creaSocioDesdeString(nombre);
            }
        }catch (NoSuchElementException e){
            System.err.println("Error de fichero. Faltan datos en la linea:" + linea);
        }
    }

    protected void creaSocioDesdeString(String nombre){
        Persona newSocio = new Persona(nombre);
        if (!socios.contains(newSocio)){
            socios.add(newSocio);
        }
    }

    protected void hacerAmigos(){
        List<Integer> posAmigos = new ArrayList<>(socios.size());
        for (int idx = 0; idx < socios.size(); idx++) {
            posAmigos.add(idx);
        }

        while(hayCoincidencias(posAmigos))
            Collections.shuffle(posAmigos);

        for (int i = 0; i< socios.size(); i++) {
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
        }

    }

    private static boolean hayCoincidencias(List<Integer> lista){

        for(int j = 0; j< lista.size();j++){
            if (lista.get(j) == j)
                return true;
        }
        return false;
    }

    public void presentaAmigos(String fSalida) throws FileNotFoundException{

        try(PrintWriter fichero = new PrintWriter(fSalida)){
            presentaAmigos(fichero);
        }
    }

    public void presentaAmigos(PrintWriter pw){

        Collections.sort(socios);
        socios.stream().forEach(pw::println);
    }
}
