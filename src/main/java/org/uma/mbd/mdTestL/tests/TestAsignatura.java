package org.uma.mbd.mdTestL.tests;

import java.util.*;

public class TestAsignatura {
    private String nombreAsignatura;
    private double valorAciertos, valorErrores;
    private List<Test> examenes;

    private final static double APROBADO = 5.0;

    public TestAsignatura(String asignatura, double valAc, double valErr, List<String> lista){
        if(valErr > 0 || valAc <= 0)
            throw new IllegalArgumentException("Valoracion de aciertos o fallos erronea");

        nombreAsignatura = asignatura;
        valorAciertos = valAc;
        valorErrores = valErr;
        examenes = new ArrayList<>();

        extraeDatos(lista);
    }

    public TestAsignatura(String alumno, List<String> lista){
        this(alumno, 1, 0, lista);
    }

    private void extraeDatos(List<String> lista){
        for (String alumno: lista){
            try(Scanner sc = new Scanner(alumno)){
                sc.useDelimiter("[:+]");
                String alum = sc.next();
                int aciertos = sc.nextInt();
                int errores = sc.nextInt();

                examenes.add(new Test(alum, aciertos, errores));
            }catch(NoSuchElementException e){
                System.err.println("No hay dato para leer siguiente");
            }
        }
    }

    public double notaMedia(){
        return examenes.stream().mapToDouble(t -> t.calificacion(valorAciertos, valorErrores)).average().getAsDouble();
    }
    public int aprobados(){
        return (int)examenes.stream().filter(examen -> examen.calificacion(valorAciertos,valorErrores) >= APROBADO).count();
    }

    public String getNombre() {
        return nombreAsignatura;
    }
}
