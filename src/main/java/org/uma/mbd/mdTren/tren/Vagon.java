package org.uma.mbd.mdTren.tren;

public class Vagon {

    private int capacidad;
    private int carga;

    public Vagon(int cap){
        capacidad = cap;
        carga = 0;
    }

    public int carga(int ton){
        int sobra = 0;
        if (ton >= (capacidad-carga)) {
            carga = capacidad;
            sobra = ton-(capacidad-carga);
        }else{
            carga += ton;
        }
        return sobra;
    }
    public int descarga(int ton){

        int falta = 0;
        if (ton > carga) {
            falta = ton-carga;
            carga = 0;
        }else{
            carga -= ton;
        }
        return falta;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCarga() {
        return carga;
    }

    @Override
    public String toString(){
        return "V("+carga+"/"+capacidad+")";
    }
}
