package org.uma.mbd.mdAlturas.alturas;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Mundo {

    List<Pais> paises;

    public Mundo(){
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises(){
        return paises;
    }

    public void leePaises(String file) throws IOException{

        Path fichero = Path.of(file);
        try(BufferedReader br = Files.newBufferedReader(fichero)){
            String linea = br.readLine();
            while(linea != null){
                Pais paisAdd = null;
                try(Scanner sc = new Scanner(linea);){
                    sc.useDelimiter(",");
                    sc.useLocale(Locale.ENGLISH);
                    String nombre = sc.next();
                    String continente = sc.next();
                    double altura = sc.nextDouble();
                    paisAdd = new Pais(nombre, continente,altura);
                    paises.add(paisAdd);
                }catch (InputMismatchException e){
                    System.err.println("Error de fichero. Número erróneo en la linea:" + linea);
                }catch (NoSuchElementException e){
                    System.err.println("Error de fichero. Faltan datos en la linea:" + linea);
                }
                linea = br.readLine();
            }
        }

    }

    public List<Pais> selecciona(Seleccion sel){
        return paises.stream().filter(pais -> sel.test(pais)).toList();
    }
}
