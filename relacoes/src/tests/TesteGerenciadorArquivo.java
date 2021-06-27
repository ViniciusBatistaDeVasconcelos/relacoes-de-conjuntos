package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import models.Conjunto;
import models.GerenciadorArquivo;
import models.exceptions.ExceptionSintaxeArquivo;

public class TesteGerenciadorArquivo {

    public static void main(String[] args) throws IOException, FileNotFoundException, ExceptionSintaxeArquivo {
        GerenciadorArquivo arquivo = new GerenciadorArquivo();

        arquivo.leitura();

        for (Conjunto conjunto : arquivo.getConjuntos()) {
            mostrarConjunto(conjunto);
        }
    }

    public static void mostrarConjunto(Conjunto conjunto) {
        if (conjunto.getNome() != null) {
            System.out.print(conjunto.getNome() + " = ");
        }
        if (conjunto.getElementos().isEmpty()) {
            System.out.println("{}\n");
        } else {
            for (int i = 0; i < conjunto.getElementos().size(); i++) {
                if (conjunto.getElementos().size() == 1) {
                    System.out.print("{" + conjunto.getElementos().get(i).getValor() + "}\n");
                } else {
                    if (i == 0) {
                        System.out.print("{" + conjunto.getElementos().get(i).getValor() + ", ");
                    } else if (i == conjunto.getElementos().size() - 1) {
                        System.out.print(conjunto.getElementos().get(i).getValor() + "}\n");
                    } else {
                        System.out.print(conjunto.getElementos().get(i).getValor() + ", ");
                    }
                }
            }
        }
    }
}
