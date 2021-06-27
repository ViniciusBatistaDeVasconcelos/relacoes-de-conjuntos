package models;

public class Isomorfismo {

    private static Isomorfismo instancia = new Isomorfismo();

    public static Isomorfismo getInstancia() {
        return instancia;
    }
    
    public boolean get(int[][] matriz) {
        boolean monomorfismo = Monomorfismo.getInstancia().get(matriz);
        boolean epimorfismo= Epimorfismo.getInstancia().get(matriz);
        
        return monomorfismo && epimorfismo;
    }
}
