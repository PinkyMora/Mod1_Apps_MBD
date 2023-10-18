package org.uma.mbd.mdDegree.degree;

public sealed interface Degree permits Celsius, Farenheit{

    default boolean isFrozen(){
        return switch(this) {
            case Celsius(var x) -> x<0;
            case Farenheit(var x) -> x<32;
        };
    }
    default Degree toCelsius(){
        return switch(this){
            case Celsius(var x) -> this;
            case Farenheit(var x) -> Degree.farenheit(x-32/1.8);
        };
    }
    default Degree toFarenheit(){
        return switch(this){
            case Celsius(var x) -> Degree.celsius(x*1.8+32);
            case Farenheit(var x) -> this;
        };
    }

    // Metodos de Fabrica
    static Degree farenheit(double degree){
        return new Farenheit(degree);
    }
    static Degree celsius(double degree){
        return new Celsius(degree);
    }
}
