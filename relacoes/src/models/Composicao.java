package models;

public class Composicao {

    private static Composicao instancia = new Composicao();

    public static Composicao getInstancia() {
        return instancia;
    }

    public int[][] get(int[][] matriz1, int[][] matriz2) {

        int[][] composicao = new int[matriz1.length][matriz2[0].length];

        for (int matriz1Linha = 0; matriz1Linha < matriz1.length; matriz1Linha++) {
            for (int matriz1Coluna = 0; matriz1Coluna < matriz1[0].length; matriz1Coluna++) {

                for (int matriz2Coluna = 0; matriz2Coluna < matriz2[0].length; matriz2Coluna++) {
                    composicao[matriz1Linha][matriz2Coluna] = composicao[matriz1Linha][matriz2Coluna]
                            + (matriz1[matriz1Linha][matriz1Coluna] * matriz2[matriz1Coluna][matriz2Coluna]);
                }
            }
        }
        return composicao;
    }
}
