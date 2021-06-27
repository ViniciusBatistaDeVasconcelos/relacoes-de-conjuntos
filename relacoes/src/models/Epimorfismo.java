package models;

public class Epimorfismo {

    private static Epimorfismo instancia = new Epimorfismo();

    public static Epimorfismo getInstancia() {
        return instancia;
    }
    
    public boolean get(int[][] matriz) {
        boolean sobrejetora = Sobrejetora.getInstancia().get(matriz);
        boolean funcional = Funcional.getInstancia().get(matriz);
        
        return sobrejetora && funcional;
    }
}
