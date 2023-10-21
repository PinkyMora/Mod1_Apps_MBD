package org.uma.mbd.mdGenetico.genetico;
import java.util.Arrays;

public class OneMax implements Problema {

    /**
     * El fitness de un individuo es el número de unos que tiene el cromosoma.
     * @see Problema#evalua(Cromosoma)
     */
    public double evalua(Cromosoma cromosoma) {
        // COMPLETAR
        return Arrays.stream(cromosoma.datos).filter(x -> x ==1).count();

    }
}
