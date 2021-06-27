package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import models.Composicao;
import models.GerenciadorArquivo;
import models.exceptions.ExceptionSintaxeArquivo;

public class TesteComposicao {

    public static void main(String[] args) throws IOException, FileNotFoundException, ExceptionSintaxeArquivo {
        GerenciadorArquivo arquivo = new GerenciadorArquivo();
        arquivo.leitura();
        int matriz1[][] = {{2, 3}, {4, 6}};
        int matriz2[][] = {{1, 3, 0}, {2, 1, 1}};
        
        Composicao.getInstancia().get(matriz1, matriz2);

    }
}
