package models;

public class Sobrejetora {

    private static Sobrejetora instancia = new Sobrejetora();

    public static Sobrejetora getInstancia() {
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
            if (contador == 0) {
                return false;
            }
        }

        return true;
    }
}
