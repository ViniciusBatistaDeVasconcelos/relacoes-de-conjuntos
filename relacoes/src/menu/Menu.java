package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import models.Composicao;
import models.Conjunto;
import models.Epimorfismo;
import models.Funcional;
import models.GerenciadorArquivo;
import models.Injetora;
import models.Isomorfismo;
import models.Monomorfismo;
import models.Sobrejetora;
import models.TipoRelacionamento;
import models.Total;
import models.exceptions.ExceptionSintaxeArquivo;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);

    public static String getMenu() {

        String str = "\n\n"
                + "--------------------------- <Menu> ---------------------------\n"
                + " 1) Ler arquivo\n"
                + " 2) Maior que ( > )\n"
                + " 3) Menor que ( < )\n"
                + " 4) Igual a ( = )\n"
                + " 5) Ser o quadrado de ( x^2 )\n"
                + " 6) Ser a raiz quadrada de ( sqrt(x) )\n"
                + " 7) Composição ( ABoBC = BC )\n"
                + " 8) Sair\n"
                + "--------------------------------------------------------------\n";
        return str;
    }

    public static String getMenuReduzido() {

        String str = ""
                + "1) Maior que\t2) Menor que ( < )\t3) Igual a ( = )\n"
                + "4) Ser o quadrado de ( x^2 )\t5) Ser a raiz quadrada de ( sqrt(x) )\n";
        return str;
    }

    public static void mostrarConjunto(Conjunto conjunto) {
        if (conjunto.getNome() != null) {
            System.out.print(conjunto.getNome() + " = ");
        }
        if (conjunto.getElementos().isEmpty()) {
            System.out.println("{}");
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

    public static void resultadoClassificassao(int[][] matriz) {

        System.out.println("\nClassificação da relação:");

        if (Funcional.getInstancia().get(matriz)) {
            System.out.println("->\tÉ funcional.");
        } else {
            System.out.println("->\tNÃO é funcional.");
        }

        if (Injetora.getInstancia().get(matriz)) {
            System.out.println("->\tÉ injetora.");
        } else {
            System.out.println("->\tNÃO é injetora.");
        }

        if (Total.getInstancia().get(matriz)) {
            System.out.println("->\tÉ total.");
        } else {
            System.out.println("->\tNÃO é total.");
        }

        if (Sobrejetora.getInstancia().get(matriz)) {
            System.out.println("->\tÉ sobrejetora.");
        } else {
            System.out.println("->\tNÃO é sobrejetora.");
        }

        if (Monomorfismo.getInstancia().get(matriz)) {
            System.out.println("->\tÉ monomórfica.");
        } else {
            System.out.println("->\tNÃO é monomórfica.");
        }

        if (Epimorfismo.getInstancia().get(matriz)) {
            System.out.println("->\tÉ epimórfica.");
        } else {
            System.out.println("->\tNÃO é epimórfica.");
        }

        if (Isomorfismo.getInstancia().get(matriz)) {
            System.out.println("->\tÉ isomórfica.");
        } else {
            System.out.println("->\tNÃO é isomórfica.");
        }

    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ExceptionSintaxeArquivo {
        GerenciadorArquivo arquivo = new GerenciadorArquivo();
        int escolhaMenu;
        do {
            System.out.println(getMenu());
            System.out.println("Escolha uma Opção: ");
            escolhaMenu = scanner.nextInt();

            switch (escolhaMenu) {

                case 1:
                    arquivo.leitura();

                    System.out.println("O arquivo foi lido com sucesso...");

                    if (!arquivo.getConjuntos().isEmpty()) {
                        System.out.println("\nConjunto(s):\n");
                        for (Conjunto conjunto : arquivo.getConjuntos()) {
                            mostrarConjunto(conjunto);
                        }
                    }
                    break;

                case 2:
                    if (arquivo.getConjuntos().size() >= 2
                            && !arquivo.getConjuntos().get(0).getElementos().isEmpty()
                            && !arquivo.getConjuntos().get(1).getElementos().isEmpty()) {
                        int[][] matriz = TipoRelacionamento.getInstancia().maiorQue(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                        //int[][] matriz = {{1, 0, 0},{ 0, 1, 0},{ 0, 0, 1}};
                        resultadoClassificassao(matriz);

                        System.out.println("\n");
                        System.out.println("Domínio:");
                        mostrarConjunto(arquivo.getConjuntos().get(0));
                        System.out.println("Domínio de Definição:");
                        mostrarConjunto(TipoRelacionamento.getInstancia().dominioDefinicao(matriz, arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1)));
                        System.out.println("Imagem:");
                        mostrarConjunto(arquivo.getConjuntos().get(1));
                    } else {
                        System.out.println("Insira ao menos 2 conjuntos ou certifique que os 2 primeiros não são vazios!");
                    }
                    break;
                case 3:
                    if (arquivo.getConjuntos().size() >= 2
                            && !arquivo.getConjuntos().get(0).getElementos().isEmpty()
                            && !arquivo.getConjuntos().get(1).getElementos().isEmpty()) {

                        int[][] matriz = TipoRelacionamento.getInstancia().menorQue(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                        resultadoClassificassao(matriz);

                        System.out.println("\n");
                        System.out.println("Domínio:");
                        mostrarConjunto(arquivo.getConjuntos().get(0));
                        System.out.println("Domínio de Definição:");
                        mostrarConjunto(TipoRelacionamento.getInstancia().dominioDefinicao(matriz, arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1)));
                        System.out.println("Imagem:");
                        mostrarConjunto(arquivo.getConjuntos().get(1));
                    } else {
                        System.out.println("Insira ao menos 2 conjuntos ou certifique que os 2 primeiros não são vazios!");
                    }
                    break;
                case 4:
                    if (arquivo.getConjuntos().size() >= 2
                            && !arquivo.getConjuntos().get(0).getElementos().isEmpty()
                            && !arquivo.getConjuntos().get(1).getElementos().isEmpty()) {

                        int[][] matriz = TipoRelacionamento.getInstancia().igualA(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                        resultadoClassificassao(matriz);

                        System.out.println("\n");
                        System.out.println("Domínio:");
                        mostrarConjunto(arquivo.getConjuntos().get(0));
                        System.out.println("Domínio de Definição:");
                        mostrarConjunto(TipoRelacionamento.getInstancia().dominioDefinicao(matriz, arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1)));
                        System.out.println("Imagem:");
                        mostrarConjunto(arquivo.getConjuntos().get(1));
                    } else {
                        System.out.println("Insira ao menos 2 conjuntos ou certifique que os 2 primeiros não são vazios!");
                    }
                    break;
                case 5:
                    if (arquivo.getConjuntos().size() >= 2
                            && !arquivo.getConjuntos().get(0).getElementos().isEmpty()
                            && !arquivo.getConjuntos().get(1).getElementos().isEmpty()) {

                        int[][] matriz = TipoRelacionamento.getInstancia().quadradoDe(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                        resultadoClassificassao(matriz);

                        System.out.println("\n");
                        System.out.println("Domínio:");
                        mostrarConjunto(arquivo.getConjuntos().get(0));
                        System.out.println("Domínio de Definição:");
                        mostrarConjunto(TipoRelacionamento.getInstancia().dominioDefinicao(matriz, arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1)));
                        System.out.println("Imagem:");
                        mostrarConjunto(arquivo.getConjuntos().get(1));
                    } else {
                        System.out.println("Insira ao menos 2 conjuntos ou certifique que os 2 primeiros não são vazios!");
                    }
                    break;
                case 6:
                    if (arquivo.getConjuntos().size() >= 2
                            && !arquivo.getConjuntos().get(0).getElementos().isEmpty()
                            && !arquivo.getConjuntos().get(1).getElementos().isEmpty()) {

                        int[][] matriz = TipoRelacionamento.getInstancia().raizQuadradaDe(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                        resultadoClassificassao(matriz);

                        System.out.println("\n");
                        System.out.println("Domínio:");
                        mostrarConjunto(arquivo.getConjuntos().get(0));
                        System.out.println("Domínio de Definição:");
                        mostrarConjunto(TipoRelacionamento.getInstancia().dominioDefinicao(matriz, arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1)));
                        System.out.println("Imagem:");
                        mostrarConjunto(arquivo.getConjuntos().get(1));
                    } else {
                        System.out.println("Insira ao menos 2 conjuntos ou certifique que os 2 primeiros não são vazios!");
                    }
                    break;
                case 7:
                    if (arquivo.getConjuntos().size() >= 3
                            && !arquivo.getConjuntos().get(0).getElementos().isEmpty()
                            && !arquivo.getConjuntos().get(1).getElementos().isEmpty()
                            && !arquivo.getConjuntos().get(2).getElementos().isEmpty()) {

                        System.out.println("______________________________________________________________");
                        System.out.println("1 Domínio:");
                        mostrarConjunto(arquivo.getConjuntos().get(0));
                        System.out.println("1 Imagem:");
                        mostrarConjunto(arquivo.getConjuntos().get(1));

                        System.out.print("\n");
                        System.out.println(getMenuReduzido());
                        System.out.println("Escolha uma Opção: ");
                        int escolhaTipo1;
                        escolhaTipo1 = scanner.nextInt();

                        int[][] matrizRelacao1 = null;
                        switch (escolhaTipo1) {
                            case 1:
                                matrizRelacao1 = TipoRelacionamento.getInstancia().maiorQue(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                                resultadoClassificassao(matrizRelacao1);
                                break;
                            case 2:
                                matrizRelacao1 = TipoRelacionamento.getInstancia().menorQue(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                                resultadoClassificassao(matrizRelacao1);
                                break;
                            case 3:
                                matrizRelacao1 = TipoRelacionamento.getInstancia().igualA(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                                resultadoClassificassao(matrizRelacao1);
                                break;
                            case 4:
                                matrizRelacao1 = TipoRelacionamento.getInstancia().quadradoDe(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                                resultadoClassificassao(matrizRelacao1);
                                break;
                            case 5:
                                matrizRelacao1 = TipoRelacionamento.getInstancia().raizQuadradaDe(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                                resultadoClassificassao(matrizRelacao1);
                                break;
                            default:
                                System.out.println("Selecione somente as opções listadas no menu...");
                                break;
                        }
                        System.out.println("______________________________________________________________");

                        System.out.println("2 Domínio:");
                        mostrarConjunto(arquivo.getConjuntos().get(1));
                        System.out.println("2 Imagem:");
                        mostrarConjunto(arquivo.getConjuntos().get(2));

                        System.out.print("\n");
                        System.out.println(getMenuReduzido());
                        System.out.println("Escolha uma Opção: ");
                        int escolhaTipo2;
                        escolhaTipo2 = scanner.nextInt();
                        int[][] matrizRelacao2 = null;
                        switch (escolhaTipo2) {
                            case 1:
                                matrizRelacao2 = TipoRelacionamento.getInstancia().maiorQue(arquivo.getConjuntos().get(1), arquivo.getConjuntos().get(2));
                                resultadoClassificassao(matrizRelacao2);
                                break;
                            case 2:
                                matrizRelacao2 = TipoRelacionamento.getInstancia().menorQue(arquivo.getConjuntos().get(1), arquivo.getConjuntos().get(2));
                                resultadoClassificassao(matrizRelacao2);
                                break;
                            case 3:
                                matrizRelacao2 = TipoRelacionamento.getInstancia().igualA(arquivo.getConjuntos().get(1), arquivo.getConjuntos().get(2));
                                resultadoClassificassao(matrizRelacao2);
                                break;
                            case 4:
                                matrizRelacao2 = TipoRelacionamento.getInstancia().quadradoDe(arquivo.getConjuntos().get(1), arquivo.getConjuntos().get(2));
                                resultadoClassificassao(matrizRelacao2);
                                break;
                            case 5:
                                matrizRelacao2 = TipoRelacionamento.getInstancia().raizQuadradaDe(arquivo.getConjuntos().get(1), arquivo.getConjuntos().get(2));
                                resultadoClassificassao(matrizRelacao2);
                                break;
                            default:
                                System.out.println("Selecione somente as opções listadas no menu...");
                                break;
                        }
                        System.out.println("______________________________________________________________");

                        System.out.println("Resultado:");

                        int[][] produto = Composicao.getInstancia().get(matrizRelacao1, matrizRelacao2);
                        TipoRelacionamento.getInstancia().mostrarMatriz(produto, arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(2));
                        TipoRelacionamento.getInstancia().gerarPares(produto, arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(2));
                        
                        System.out.println("\n");
                        System.out.println("Domínio:");
                        mostrarConjunto(arquivo.getConjuntos().get(0));
                        System.out.println("Domínio de Definição:");
                        mostrarConjunto(TipoRelacionamento.getInstancia().dominioDefinicao(produto, arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(2)));
                        System.out.println("Imagem:");
                        mostrarConjunto(arquivo.getConjuntos().get(2));
                        
                        resultadoClassificassao(produto);
                    } else {
                        System.out.println("Insira ao menos 3 conjuntos ou certifique que os 3 primeiros não são vazios!");
                    }
                    break;
                case 8:
                    System.out.println("O programa foi finalizado!");
                    break;
                default:
                    System.out.println("Selecione somente as opções listadas no menu...");
                    break;
            }
        } while (escolhaMenu != 8);
    }
}
