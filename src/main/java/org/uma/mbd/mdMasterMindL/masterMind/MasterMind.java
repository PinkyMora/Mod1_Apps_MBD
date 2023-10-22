package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.Random;

public class MasterMind {

    protected String combinacionSecreta;

    private Random alea = new Random();

    static public final int TAMANO_POR_DEFECTO = 4;

    public MasterMind(int tamano){
        if (tamano < 1 || tamano > 10){
            throw new MasterMindException("Tamano no valido");
        }
        generaCombinacionSecreta(tamano);

    }

    public MasterMind(){
        this(TAMANO_POR_DEFECTO);
    }

    private void generaCombinacionSecreta(int tamano){
        StringBuilder combinacion = new StringBuilder(tamano);

        while(combinacion.length() < tamano){
            String digit = Integer.toString(alea.nextInt(10));

            if (combinacion.indexOf(digit) == -1){
                combinacion.append(digit);
            }
        }
        combinacionSecreta = combinacion.toString();
    }
    public int getLongitud(){
        return combinacionSecreta.length();
    }

    private boolean validaCombinacion(String cifras){
        boolean bNumerico = cifras.matches("[0-9]+");
        boolean bLongitudYNoRepes = getLongitud() == cifras.chars().distinct().count();
        return bNumerico && bLongitudYNoRepes;
    }


    public Movimiento intento(String cifras){
        if (!validaCombinacion(cifras))
            throw new MasterMindException("Combinacion no valida.");

        int colocadas = 0;
        int descolocadas = 0;
        for (int i = 0; i < getLongitud(); i++ ){

            if (combinacionSecreta.indexOf(cifras.charAt(i)) == i){
                colocadas++;
            }else if (combinacionSecreta.indexOf(cifras.charAt(i)) == -1){
                descolocadas++;
            }
        }

        return new Movimiento(cifras, colocadas,descolocadas);

    }

    public String getSecreto(){
        return combinacionSecreta;
    }

}
