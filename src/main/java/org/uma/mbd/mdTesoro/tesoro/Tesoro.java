package org.uma.mbd.mdTesoro.tesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Vector;


public class Tesoro {
    private Punto palmeraRosa, palmeraAzul, palmeraAmarilla, estacaAzul, estacaAmarilla, tesoro;

    public Tesoro(Punto palmeraAmarilla, Punto palmeraAzul, Punto palmeraRosa){
        this.palmeraAmarilla = palmeraAmarilla;
        this.palmeraAzul = palmeraAzul;
        this.palmeraRosa = palmeraRosa;
        calculaPosiciones();
    }

    private void calculaPosiciones(){
        //Calculamos estacas y tesoros con la pos de las palmeras
        Vector rosa_Amarilla = new Vector(palmeraRosa,palmeraAmarilla);
        Vector rAmPerpe = rosa_Amarilla.ortogonal();
        estacaAmarilla = rAmPerpe.extremoDesde(palmeraAmarilla);

        Vector rosa_Azul = new Vector(palmeraRosa,palmeraAzul);
        // Giro de 270 grados ó -90
        Vector rAzPerpe = rosa_Azul.ortogonal().ortogonal().ortogonal();

        estacaAzul = rAzPerpe.extremoDesde(palmeraAzul);

        double xTesoro = (estacaAmarilla.getX() + estacaAzul.getX())/2;
        double yTesoro = (estacaAmarilla.getY() + estacaAzul.getY())/2;

        tesoro = new Punto(xTesoro, yTesoro);
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

    public Punto getEstacaAmarilla() {return estacaAmarilla;}

    public Punto getEstacaAzul() {return estacaAzul;}

    public Punto getTesoro() {return tesoro;}
}
