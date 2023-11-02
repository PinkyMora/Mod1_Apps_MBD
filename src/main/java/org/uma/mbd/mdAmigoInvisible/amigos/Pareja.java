package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public record Pareja(Persona uno, Persona otro) {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Pareja pareja && ((pareja.uno.equals(uno)  && (pareja.otro.equals(otro))) || ((pareja.uno.equals(otro) && (pareja.otro.equals(uno)))));
    }

    @Override
    public int hashCode() {
        return Objects.hash(uno.getNombre().toLowerCase(), otro.getNombre().toLowerCase()) + Objects.hash(otro.getNombre().toLowerCase(), uno.getNombre().toLowerCase());
    }
}

