package models;

public class Total {

    private static Total instancia = new Total();

    public static Total getInstancia() {
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
            if (contador == 0) {
                return false;
            }
        }

        return true;
    }
}
