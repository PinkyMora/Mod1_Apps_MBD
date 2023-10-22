package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.ArrayList;
import java.util.List;

public class MasterMindMemoria extends MasterMind{

    private List<Movimiento> movimientos = new ArrayList<>();

    public MasterMindMemoria(){ super();}

    public MasterMindMemoria(int tamano){super(tamano);}

    @Override
    public Movimiento intento(String intento){

        Movimiento nuevoMove = super.intento(intento);

        if(movimientos.contains(nuevoMove) ){
            throw new MasterMindException("Movimiento anteriormente realizado");
        }

        movimientos.addLast(nuevoMove);

        return nuevoMove;

    }

    public List<Movimiento> movimientos() {return movimientos;}
}
