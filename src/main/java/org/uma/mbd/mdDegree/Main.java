package org.uma.mbd.mdDegree;

import org.uma.mbd.mdDegree.degree.Celsius;
import org.uma.mbd.mdDegree.degree.Degree;
import org.uma.mbd.mdDegree.degree.Farenheit;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Degree> ld = List.of(  Degree.celsius(37),
                                    Degree.farenheit(-7),
                                    Degree.celsius(29),
                                    Degree.farenheit(31));


    }
}
