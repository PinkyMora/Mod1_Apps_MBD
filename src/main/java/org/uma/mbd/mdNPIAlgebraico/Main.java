package org.uma.mbd.mdNPIAlgebraico;

import org.uma.mbd.mdNPIAlgebraico.npi.*;

import java.util.List;

import static org.uma.mbd.mdNPIAlgebraico.npi.Elem.*;

public class Main {
    public static void main(String[] args) {

        NPI cpi = new NPI();
        List<Elem> lista = List.of(
                                valor(5),
                                valor(6),
                                valor(2),
                                fun2((a,b) -> a-b),
                                valor(3),
                                fun(a -> Math.sqrt(a)),
                                fun2((a,b)-> a*b),
                                fun2((a,b)-> a+b));

        double res = cpi.evalua(lista);
        System.out.println("Resultado "+res);

    }
}
