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
        super.hacerAmigos();
        Set<Pareja> regalanA= new HashSet<>();
        for (Persona persona : socios)
        {
            regalanA.add(new Pareja(persona,persona.getAmigo()));
        }

        }
}
