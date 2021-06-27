package models;

import java.util.ArrayList;
import java.util.List;

public class TipoRelacionamento {

    private static TipoRelacionamento instancia = new TipoRelacionamento();

    public static TipoRelacionamento getInstancia() {
        return instancia;
    }

    public int[][] maiorQue(Conjunto conjunto1, Conjunto conjunto2) {
        List<Elemento[]> pares = new ArrayList<>();
        int[][] matriz = new int[conjunto1.getElementos().size()][conjunto2.getElementos().size()];

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {

                if (conjunto1.getElementos().get(i).getValor() > conjunto2.getElementos().get(j).getValor()) {

                    Elemento[] par = new Elemento[2];
                    par[0] = conjunto1.getElementos().get(i);
                    par[1] = conjunto2.getElementos().get(j);
                    pares.add(par);

                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        mostrarMatriz(matriz, conjunto1, conjunto2);
        System.out.print("\n");
        mostrarPares(pares);
        return matriz;
    }

    public int[][] menorQue(Conjunto conjunto1, Conjunto conjunto2) {
        List<Elemento[]> pares = new ArrayList<>();
        int[][] matriz = new int[conjunto1.getElementos().size()][conjunto2.getElementos().size()];

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {

                if (conjunto1.getElementos().get(i).getValor() < conjunto2.getElementos().get(j).getValor()) {

                    Elemento[] par = new Elemento[2];
                    par[0] = conjunto1.getElementos().get(i);
                    par[1] = conjunto2.getElementos().get(j);
                    pares.add(par);

                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        mostrarMatriz(matriz, conjunto1, conjunto2);
        System.out.print("\n");
        mostrarPares(pares);
        return matriz;
    }

    public int[][] igualA(Conjunto conjunto1, Conjunto conjunto2) {
        List<Elemento[]> pares = new ArrayList<>();
        int[][] matriz = new int[conjunto1.getElementos().size()][conjunto2.getElementos().size()];

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {

                if (conjunto1.getElementos().get(i).getValor() == conjunto2.getElementos().get(j).getValor()) {

                    Elemento[] par = new Elemento[2];
                    par[0] = conjunto1.getElementos().get(i);
                    par[1] = conjunto2.getElementos().get(j);
                    pares.add(par);

                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        mostrarMatriz(matriz, conjunto1, conjunto2);
        System.out.print("\n");
        mostrarPares(pares);
        return matriz;
    }

    public int[][] quadradoDe(Conjunto conjunto1, Conjunto conjunto2) {
        List<Elemento[]> pares = new ArrayList<>();
        int[][] matriz = new int[conjunto1.getElementos().size()][conjunto2.getElementos().size()];

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {

                if (conjunto1.getElementos().get(i).getValor() == (conjunto2.getElementos().get(j).getValor() * conjunto2.getElementos().get(j).getValor())) {

                    Elemento[] par = new Elemento[2];
                    par[0] = conjunto1.getElementos().get(i);
                    par[1] = conjunto2.getElementos().get(j);
                    pares.add(par);

                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        mostrarMatriz(matriz, conjunto1, conjunto2);
        System.out.print("\n");
        mostrarPares(pares);
        return matriz;
    }

    public int[][] raizQuadradaDe(Conjunto conjunto1, Conjunto conjunto2) {
        List<Elemento[]> pares = new ArrayList<>();
        int[][] matriz = new int[conjunto1.getElementos().size()][conjunto2.getElementos().size()];

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {

                if (conjunto1.getElementos().get(i).getValor() == Math.sqrt(conjunto2.getElementos().get(j).getValor())) {

                    Elemento[] par = new Elemento[2];
                    par[0] = conjunto1.getElementos().get(i);
                    par[1] = conjunto2.getElementos().get(j);
                    pares.add(par);

                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        mostrarMatriz(matriz, conjunto1, conjunto2);
        System.out.print("\n");
        mostrarPares(pares);
        return matriz;
    }

    private void mostrarPares(List<Elemento[]> pares) {
        for (int i = 0; i < pares.size(); i++) {
            if (i == pares.size() - 1) {
                System.out.print("<" + pares.get(i)[0].getValor() + ", " + pares.get(i)[1].getValor() + ">.\n");
            } else {
                System.out.print("<" + pares.get(i)[0].getValor() + ", " + pares.get(i)[1].getValor() + ">, ");
            }
        }
    }

    public void gerarPares(int[][] matriz, Conjunto conjunto1, Conjunto conjunto2) {
        List<Elemento[]> pares = new ArrayList<>();

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                for (int i = 0; i < matriz[linha][coluna]; i++) {

                    Elemento[] par = new Elemento[2];
                    par[0] = conjunto1.getElementos().get(linha);
                    par[1] = conjunto2.getElementos().get(coluna);
                    pares.add(par);
                }
            }
        }
        System.out.print("\n");
        mostrarPares(pares);
    }

    public Conjunto dominioDefinicao(int[][] matriz, Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto dominioDefinicao;
        if(conjunto1.getNome().isEmpty()){
            dominioDefinicao = new Conjunto();
        }else{
            dominioDefinicao = new Conjunto(conjunto1.getNome());
        }
        
        for (int linha = 0; linha < matriz.length; linha++) {

            int contador = 0;

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                if (matriz[linha][coluna] >= 1) {
                    ++contador;
                }
            }
            if (contador != 0) {
               dominioDefinicao.adicionarElemento(conjunto1.getElementos().get(linha));
            }
        }

        return dominioDefinicao;
    }

    public void mostrarMatriz(int[][] matriz, Conjunto conjunto1, Conjunto conjunto2) {

        for (int i = 0; i < conjunto2.getElementos().size(); i++) {
            if (conjunto2.getElementos().size() - 1 == i) {
                System.out.print(conjunto2.getElementos().get(i).getValor() + "\n");
            } else if (i == 0) {
                System.out.print("-\t" + conjunto2.getElementos().get(i).getValor() + "\t");
            } else {
                System.out.print(conjunto2.getElementos().get(i).getValor() + "\t");
            }
        }
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                if (coluna == 0) {
                    System.out.print(conjunto1.getElementos().get(linha).getValor() + "\t" + matriz[linha][coluna] + "\t");
                } else if (matriz[0].length - 1 == coluna) {
                    System.out.print(matriz[linha][coluna] + "\n");
                } else {
                    System.out.print(matriz[linha][coluna] + "\t");
                }
            }
        }
    }
}
