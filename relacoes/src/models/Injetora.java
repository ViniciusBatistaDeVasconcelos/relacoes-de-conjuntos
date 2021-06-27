package models;

public class Injetora {

    private static Injetora instancia = new Injetora();

    public static Injetora getInstancia() {
        return instancia;
    }

    public boolean get(int[][] matriz) {
        
        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            int contador = 0;

            for (int linha = 0; linha < matriz.length; linha++) {

                if (matriz[linha][coluna] >= 1) {
                    ++contador;
                }
            }
            if (contador > 1) {
                return false;
            }
        }

        return true;
    }
}
