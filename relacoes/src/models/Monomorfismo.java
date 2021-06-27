package models;

public class Monomorfismo {

    private static Monomorfismo instancia = new Monomorfismo();

    public static Monomorfismo getInstancia() {
        return instancia;
    }
    
    public boolean get(int[][] matriz) {
        boolean total = Total.getInstancia().get(matriz);
        boolean injetora = Injetora.getInstancia().get(matriz);
        
        return total && injetora;
    }
}
