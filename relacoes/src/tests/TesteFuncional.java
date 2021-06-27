package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import models.Funcional;
import models.GerenciadorArquivo;
import models.TipoRelacionamento;
import models.exceptions.ExceptionSintaxeArquivo;

public class TesteFuncional {

    public static void main(String[] args) throws IOException, FileNotFoundException, ExceptionSintaxeArquivo {
        GerenciadorArquivo arquivo = new GerenciadorArquivo();
        arquivo.leitura();
        int matriz[][];

        System.out.println("Maior que:");
        matriz = TipoRelacionamento.getInstancia().maiorQue(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));

        if (Funcional.getInstancia().get(matriz)) {
            System.out.println("É funcional!");
        } else {
            System.out.println("NÃO é funcional!");
        }
    }
}
