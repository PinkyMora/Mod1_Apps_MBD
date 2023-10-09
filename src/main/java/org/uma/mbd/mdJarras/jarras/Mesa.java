package org.uma.mbd.mdJarras.jarras;

public class Mesa {

    private Jarra jarraA, jarraB;

    public Mesa(int capacidadA, int capacidadB){
        jarraA = new Jarra(capacidadA);
        jarraB = new Jarra(capacidadB);
    }

    public void llenaA(){
        jarraA.llena();
    }
    public void llenaB(){
        jarraB.llena();
    }
    public void vaciaA() { jarraA.vacia(); }
    public void vaciaB() { jarraB.vacia(); }

    public void vuelcaASobreB(){
        jarraB.llenaDesde(jarraA);
    }
    public void vuelcaBSobreA(){
        jarraA.llenaDesde(jarraB);
    }

    public int getContenidoA(){
        return jarraA.getContenido();
    }
    public int getContenidoB(){
        return jarraB.getContenido();
    }
    public int getCapacidadA(){
        return jarraA.getCapacidad();
    }
    public int getCapacidadB(){
        return jarraB.getCapacidad();
    }

    public int getContenido(){
        return jarraA.getContenido() + jarraB.getContenido();
    }

    @Override
    public String toString(){
        return "JarraA: "+jarraA+" | JarraB: "+jarraB+" ";
    }
}
