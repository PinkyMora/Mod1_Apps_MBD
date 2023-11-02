package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.*;

public class ClubParejas extends Club{
    Set<Pareja> parejas = new HashSet<>();

    @Override
    protected void creaSocioDesdeString(String nombrePareja) {
        try(Scanner sc = new Scanner(nombrePareja);) {
            sc.useDelimiter("-");
            String nombre1 = sc.next();
            super.creaSocioDesdeString(nombre1);
            if (sc.hasNext()) {
                String nombre2 = sc.next();
                parejas.add(new Pareja(new Persona(nombre1), new Persona(nombre2)));
                super.creaSocioDesdeString(nombre2);
            }
        }catch (NoSuchElementException e){
            System.err.println("Error de fichero. Falta nombre en la pareja o amigo:" + nombrePareja);
        }
    }

    @Override
    protected void hacerAmigos() {
        List<Integer> posAmigos = new ArrayList<>(socios.size());
        for (int idx = 0; idx < socios.size(); idx++) {
            posAmigos.add(idx);
        }

        while(hayCoincidencias(posAmigos) || hayParejas(posAmigos))
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

    private boolean hayParejas(List<Integer> lista){
        for(int i = 0; i< lista.size(); i++){
            if(parejas.contains(new Pareja( socios.get(i), socios.get(lista.get(i))))){
                return true;
            }
        }
        return false;
    }
}
