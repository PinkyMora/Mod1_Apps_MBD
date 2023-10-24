package org.uma.mbd.mdNPIAlgebraico.npi;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public sealed interface Elem  permits Valor, Fun, Fun2{
    static Elem valor(double x) {return new Valor(x);}

    static Elem fun(DoubleUnaryOperator op){return new Fun(op);}

    static Elem fun2(DoubleBinaryOperator op){return new Fun2(op);}
}
