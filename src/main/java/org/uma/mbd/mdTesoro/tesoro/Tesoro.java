package org.uma.mbd.mdTesoro.tesoro;

import org.uma.mbd.mdRectas.rectas.Punto;

public class Tesoro {
    private Punto palmeraRosa, palmeraAzul, palmeraAmarilla, estacaAzul, estacaAmarilla, tesoro;

    private void calculaPosiciones(){
        //Calculamos estacas y tesoros con la pos de las palmeras

    }

    public void setPalmeraAmarilla(Punto palmeraAmarilla) {
        this.palmeraAmarilla = palmeraAmarilla;
        calculaPosiciones();
    }
    public void setPalmeraAzul(Punto palmeraAzul) {
        this.palmeraAzul = palmeraAzul;
        calculaPosiciones();
    }
    public void setPalmeraRosa(Punto palmeraRosa) {
        this.palmeraRosa = palmeraRosa;
        calculaPosiciones();
    }


}
