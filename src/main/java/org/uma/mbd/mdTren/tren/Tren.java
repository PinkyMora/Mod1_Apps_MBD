package org.uma.mbd.mdTren.tren;

import java.util.ArrayList;
import java.util.List;

public class Tren {

    private List<Vagon> vagones = new ArrayList<>();

    public Tren(int nVagones, int capVagones){
        vagones.clear();
        for(int i = 0; i< nVagones; i++){
            vagones.add(new Vagon(capVagones));
        }
    }

    public void carga(int ton){

    }

    public void descarga(int ton){

    }

    public void optimiza(){

    }

    @Override
    public String toString(){
        return "Tren"+vagones.toString();
    }


}
