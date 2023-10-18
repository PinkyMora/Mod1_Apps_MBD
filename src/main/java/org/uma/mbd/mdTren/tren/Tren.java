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
        int idx = 0;
        while( ton > 0){
            ton = vagones.get(idx).carga(ton);
            idx++;
            if (idx == vagones.size() && ton != 0){
                vagones.add(new Vagon(vagones.get(idx-1).getCapacidad()));
            }
        }

    }

    public void gasta(int ton){
        for (Vagon vagon:vagones) {
            ton = vagon.descarga(ton);
        }
        if (ton != 0)
            throw new IllegalArgumentException("El tren gasta más de lo que carga");
    }

    public void optimiza(){
        for (int i = 0; i< vagones.size();i++){
            if (vagones.get(i).getCarga() == 0) {
                vagones.remove(i);
                i--;
            }
        }

    }

    @Override
    public String toString(){
        return "Tren"+vagones.toString();
    }


}
