package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Indice {
    protected List<String> texto;
    public Indice(){
        texto = new ArrayList<>();
    }

    public void agregarLinea(String linea){
        texto.addLast(linea);
    }

    public abstract void resolver(String delimitadores, Collection<String> noSignificativas);

    public abstract void presentarIndiceConsola();
}
