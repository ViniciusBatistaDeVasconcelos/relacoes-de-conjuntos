package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import models.GerenciadorArquivo;
import models.TipoRelacionamento;
import models.exceptions.ExceptionSintaxeArquivo;

public class TesteTipoRelacionamento {

    public static void main(String[] args) throws IOException, FileNotFoundException, ExceptionSintaxeArquivo {
        GerenciadorArquivo arquivo = new GerenciadorArquivo();
        arquivo.leitura();
        int matriz[][];
        
        System.out.println("Maior que:");
        matriz = TipoRelacionamento.getInstancia().maiorQue(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1)); 
        
        System.out.println("Menor que:");
        matriz = TipoRelacionamento.getInstancia().menorQue(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
        
        System.out.println("Igual a:");
        matriz = TipoRelacionamento.getInstancia().igualA(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
        
        System.out.println("Quadrado de:");
        matriz = TipoRelacionamento.getInstancia().quadradoDe(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
        
        System.out.println("Raiz quadrada de:");
        matriz = TipoRelacionamento.getInstancia().raizQuadradaDe(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
    }
}
