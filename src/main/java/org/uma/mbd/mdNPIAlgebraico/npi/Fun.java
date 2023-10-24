package org.uma.mbd.mdNPIAlgebraico.npi;

import java.util.function.DoubleUnaryOperator;

public record Fun(DoubleUnaryOperator op) implements Elem {}
