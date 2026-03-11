package Aarraylist.exercicioB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TamanhoPalavra {

    private ArrayList<String> listaDeNomes = new ArrayList<>();
    private boolean validarOpcao = true;
    private final Scanner entrada = new Scanner(System.in);

    public TamanhoPalavra() {
        this.listaDeNomes = new ArrayList<>();
    }


    public void menu() {
        String menu = """
                ╔════════════════════════════════╗\
                
                ║     GERENCIADOR DE NOMES       ║\
                
                ╠════════════════════════════════╣\
                
                ║ [1] Adicionar nome             ║\
                
                ║ [2] Remover nome               ║\
                
                ║ [3] Listar por tamanho         ║\
                
                ║ [4] Buscar nome                ║\
                
                ║ [5] Ordenar lista              ║\
                
                ║ [6] Ver todos os nomes         ║\
                
                ║ [7] Filtrar por letra          ║\
                
                ║ [0] Sair                       ║\
                
                ╚════════════════════════════════╝\
                
                →\s""";

        do {

            System.out.print(menu);

            String entradaUsuarioMenu = entrada.nextLine().toUpperCase();

            switch (entradaUsuarioMenu) {

                case "1":
                    adicionar();
                    break;

                case "2":
                    remover();
                    break;

                case "3":
                    listaDeNomesAdicionados();
                    break;

                case "4":
                    buscarNomes();
                    break;

                case "5":
                    ordenarLista();
                    break;

                case "6":
                    listarTodosOsNomes();
                    break;

                case "7":
                    filtrarPorLetra();
                    break;

                case "0":
                    System.out.println("Finalizando...");
                    validarOpcao = false;
                    break;

                default:
                    System.out.println("\nOpção inválida\n");
            }


        } while (validarOpcao);
    }

    private void adicionar() {

        System.out.print("Adicionar → ");

        String entradaUsuarioParaAdicionar = entrada.nextLine().toUpperCase();

        if (verificarListaPorNome(entradaUsuarioParaAdicionar)) {
            System.out.println(entradaUsuarioParaAdicionar + " já existe.");
            return;
        }

        System.out.println(entradaUsuarioParaAdicionar + " - adicionado com sucesso!");
        listaDeNomes.add(entradaUsuarioParaAdicionar);
    }

    private void remover() {

        String menu = """
                Remover por NOME ou por NÚMERO?
                
                1 - NOME\
                
                2 - NÚMERO\
                
                3 - VOLTAR\
                
                 →\s""";

        int antesDaRemocao = listaDeNomes.size();

        if (verificaLista()) {
            return;
        }

        System.out.println(menu);
        String opcao = entrada.nextLine().trim();

        if (!opcao.matches("[1-3]")) {
            System.out.println("Opção inválida!");
            return;
        }

        switch (opcao) {

            case "1":
                System.out.print("Remover -> ");
                String usuarioParaRemocao = entrada.nextLine().toUpperCase();

                if (verificarListaPorNome(usuarioParaRemocao)) {
                    listaDeNomes.remove(usuarioParaRemocao);
                    System.out.println("Quantidade: " + antesDaRemocao + " antes | " + listaDeNomes.size() + " agora!");
                    System.out.println("Nome: [" + usuarioParaRemocao + "] removido com sucesso!\n");
                } else {
                    System.out.println("Nome: [" + usuarioParaRemocao + "] não encontrado\n");
                }
                break;

            case "2":
                System.out.print("Remover (digite a opção) -> ");

                try {
                    int indiceDoUsuario = Integer.parseInt(entrada.nextLine());

                    if (verificarListaPorIndice(indiceDoUsuario)) {
                        System.out.println("Quantidade: " + antesDaRemocao + " antes | " + listaDeNomes.size() + " agora!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite apenas números!\n");
                }
                break;


            case "3":
                break;

            default:
                System.out.println("Opção inválida.");
                break;

        }

    }

    private void listarTodosOsNomes() {

        if (verificaLista()) {
            return;
        }

        String cabecalho = "\n---- Lista de nomes ----\n";

        System.out.println(cabecalho);

        for (int i = 0; i < listaDeNomes.size(); i++) {

            System.out.println((i + 1) + " - " + listaDeNomes.get(i));

        }

        System.out.println();

    }

    private boolean verificarListaPorNome(String usuarioParaRemocao) {

        return listaDeNomes.contains(usuarioParaRemocao);
    }

    private boolean verificarListaPorIndice(int posicaoInformada) {

        int indiceReal = posicaoInformada - 1;

        if (indiceReal >= 0 && indiceReal < listaDeNomes.size()) {
            String nomeRemovido = listaDeNomes.get(indiceReal);
            listaDeNomes.remove(indiceReal);

            System.out.println("Nome: [" + nomeRemovido + "] na posicao [" + posicaoInformada + "]  " + "removido com sucesso!\n");
            return true;
        }

        System.out.println("Posição não encontrada.");
        return false;
    }

    private void listaDeNomesAdicionados() {

        if (verificaLista()) {
            return;
        }

        String menu = """
                Digite [1] para Nomes maiores que 5 letras\
                
                Digite [2] para Nomes menores que 5 letras\
                
                Digite [3] para Voltar ao Menu inicial.\
                
                →\s""";


        System.out.println(menu);


        String opcao = entrada.nextLine();

        switch (opcao) {

            case "1":
                listarNomesPorTamanho(5, Integer.MAX_VALUE);
                break;
            case "2":
                listarNomesPorTamanho(1, 4);
                break;
            case "3":
                return;

            default:
                System.out.println("Opção inválida!");

        }

    }


    private void buscarNomes() {

        if (verificaLista()) {
            return;
        }

        System.out.println("Digite o nome do qual deseja buscar: ");
        String nome = entrada.nextLine().toUpperCase();

        int indice = listaDeNomes.indexOf(nome);

        if (indice != -1) {
            System.out.println("\n[" + nome + "] - ENCONTRADO NA POSIÇÃO " + (indice + 1));
        } else {
            System.out.println("\n[" + nome + "] - não encontrado.");
        }
    }

    private int tamanhoLista() {

        verificaLista();

        return listaDeNomes.size();
    }

    private void listarNomesPorTamanho(int tamanhoMinimo, int tamanhoMaximo) {
        if (tamanhoLista() == 0) {
            return;
        }

        System.out.println("\n---- Lista de nomes ----");
        int contador = 0;

        for (int i = 0; i < listaDeNomes.size(); i++) {
            String nome = listaDeNomes.get(i);
            int tamanho = nome.length();

            if (tamanho >= tamanhoMinimo && tamanho <= tamanhoMaximo) {
                System.out.println((i + 1) + " - " + nome + " - [" + tamanho + "]");
                contador++;
            }
        }

        System.out.println("\nNomes neste intervalo: " + contador +
                "\nTotal cadastrados: " + listaDeNomes.size() +
                "\n------------------------\n");

    }

    private boolean verificaLista() {

        boolean empty = listaDeNomes.isEmpty();

        if (empty) {
            System.out.println("\n*** LISTA VAZIA ***\n");
        }

        return empty;
    }

    private void ordenarLista() {

        if (verificaLista()) {
            return;
        }

        String menu = """
                
                1 - Ordem alfavética (A - Z)\
                
                2 - Ordem reversa (Z - A)\
                
                3 - Voltar
                →\s""";

        System.out.println(menu);
        String opcao = entrada.nextLine().trim();

        if (!opcao.matches("[1-3]")) {
            System.out.println("Opção inválida!");
            return;
        }


        switch (opcao) {

            case "1":
                listaDeNomes.sort(null);
                System.out.println("\n=== Lista Ordenada (A - Z) ===");
                exibirListaFormatada();
                break;

            case "2":
                listaDeNomes.sort(Collections.reverseOrder());
                System.out.println("\n=== Lista Ordenada (Z - A) ===");
                exibirListaFormatada();
                break;

            case "3":
                break;

            default:
                System.out.println("Opção inválida, digite uma opção válida.");
                break;

        }

    }

    private void filtrarPorLetra() {

        if (verificaLista()) {
            return;
        }

        System.out.print("Digite uma só letra: ");
        String letra = entrada.nextLine().toUpperCase();

        if (!letra.matches("[A-Z]")) {
            System.out.println("Erro: Digite apenas UMA letra!");
            return;
        }

        int contador = 0;

        listaDeNomes.sort(null);

        int quantidadeTotal = listaDeNomes.size();

        for (String nome : listaDeNomes) {

            if (nome.startsWith(letra)) {
                System.out.println(++contador + " - " + nome);

            }

        }


        if (contador == 0) {
            System.out.println("Nenhum nome encontrado com a letra [" + letra + "]");
            System.out.println("Total cadastrados: " + quantidadeTotal + " nomes\n");
        } else {
            double porcentagemNomes = ((double) contador / quantidadeTotal) * 100;
            System.out.printf("Total encontrado: %d de %d nomes (%.2f%%)\n",
                    contador, quantidadeTotal, porcentagemNomes);
        }

    }

    private void exibirListaFormatada() {

        for (int i = 0; i < listaDeNomes.size(); i++) {
            System.out.println((i + 1) + " - " + listaDeNomes.get(i));
        }
        System.out.println("Total: " + listaDeNomes.size() + " nomes\n");
    }

}