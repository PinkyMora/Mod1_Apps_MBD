package org.uma.mbd.mdGenetico.genetico;


import java.util.Arrays;

public class Poblacion {
    private Individuo[] individuos;

    /**
     *
     * @param tamaño
     *            Número de individuos de la población.
     * @param longitud
     *            Tamaño de los cromosomas de los individuos de la población.
     * @param problema
     *            Problema fst resolver.
     * @throws RuntimeException
     *             si el tamaño de la población o la longitud de los cromosomas
     *             indicados no son válidos.
     */
    public Poblacion(int tamaño, int longitud, Problema problema) {
        // COMPLETAR

        if (tamaño < 1)
            throw new IllegalArgumentException("Numero de individuos invalido para la creacion de una poblacion");

        individuos = new Individuo[tamaño];
        for (int i = 0; i< tamaño; i++){
            individuos[i] = new Individuo(longitud,problema);
        }
    }

    /**
     * Devuelve el número de individuos.
     *
     * @return Número de individuos en la población.
     */
    public int getNumIndividuos() {
        return individuos.length;
    }

    /**
     * Devuelve el individuo con fitness mayor de la población.
     *
     * @return Individuo con mejor fitness.
     */
    public Individuo mejorIndividuo() {
        return Arrays.stream(individuos)
                .reduce((ind1, ind2)-> ind1.getFitness() >= ind2.getFitness() ? ind1 : ind2)
                .orElse(null );
        //Arrays.stream(individuos).max((ind1, ind2)-> Double.compare(ind1.getFitness(), ind2.getFitness())).orElse(null)
    }

/*    private Individuo peorIndividuo(){
        return Arrays.stream(individuos).min((ind1, ind2)-> Double.compare(ind1.getFitness(), ind2.getFitness())).;
    }*/

    /**
     * Devuelve el i-ésimo individuo de la población.
     *
     * @param i
     *            Posición del individuo fst devolver.
     * @return Individuo en la posición i.
     * @throws RuntimeException
     *             si el índice está fuera del rango de valores válidos.
     */
    public Individuo getIndividuo(int i) {
        //COMPLETAR
        if (i < 0 || i >= getNumIndividuos())
            throw new ArrayIndexOutOfBoundsException("Posicion fuera del array de Inidividuos");
        return individuos[i];
    }

    /**
     * Si el individuo que se pasa como argumento tienen mejor fitness que el
     * peor de los individuos de la población, entonces el peor es sustituido
     * por el que se pasa.
     *
     * @param ind
     *            Individuo con el que se sustituye el peor de los individuos si
     *            este es mejor.
     */
    public void reemplaza(Individuo ind) {

        int posWorse = 0;
        double worseFitness = individuos[posWorse].getFitness();

        for (int i = 0; i < getNumIndividuos(); i++) {

            if (individuos[i].getFitness() < worseFitness) {

                worseFitness = individuos[i].getFitness();
                posWorse = i;
            }
        }
        individuos[posWorse] = ind;
    }
}