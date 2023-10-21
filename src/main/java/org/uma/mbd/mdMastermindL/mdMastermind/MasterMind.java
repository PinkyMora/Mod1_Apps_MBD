package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.Random;

public class MasterMind {

    protected String combinacionSecreta;

    private Random alea = new Random();

    static public final int TAMANO_POR_DEFECTO = 4;

    public MasterMind(int tamano){
        if (tamano < 1 || tamano > 10){
            throw new MasterMindException("Tamano no valido");
        }


    }
    public int getLongitud(){
        return combinacionSecreta.length();
    }

    private boolean validaCombinacion(String cifras){
        boolean bLongitud = (cifras.length() > getLongitud());
        boolean bNumerico = cifras.matches("[0-9]*");
    }

    public MasterMind(){
        this(TAMANO_POR_DEFECTO);
    }

}
