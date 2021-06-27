package models;

public class Funcional {

    private static Funcional instancia = new Funcional();

    public static Funcional getInstancia() {
        return instancia;
    }

    public boolean get(int[][] matriz) {

        for (int linha = 0; linha < matriz.length; linha++) {

            int contador = 0;

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

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
