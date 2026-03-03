package Aarraylist.exercicioA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TamanhoPalavra {

    private ArrayList<String> listaDeNomes = new ArrayList<>();
    private boolean validarOpcao = true;
    private Scanner entrada = new Scanner(System.in);

    public TamanhoPalavra() {
        this.listaDeNomes = new ArrayList<>();
    }


    private void adicionar() {

        System.out.print("Adicionar -> ");
        String entradaUsuarioParaAdicionar = entrada.nextLine().toUpperCase();
        if (verificarListaPorNome(entradaUsuarioParaAdicionar)) {
            System.out.println(entradaUsuarioParaAdicionar + " já existe.");
            return;
        }
        listaDeNomes.add(entradaUsuarioParaAdicionar);
    }

    public void menu() {
        String menu = "---- Escolha uma das opções ----" +
                "\n1 - adicionar" +
                "\n2 - remover" +
                "\n3 - listar" +
                "\n4 - Busca por nome" +
                "\n5 - Ordenar lista" +
                "\n6 - sair" +
                "\n";

        do {

            System.out.print(menu +
                    "\n-> ");

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
                    System.out.println("Finalizando...");
                    validarOpcao = false;
                    break;

                default:
                    System.out.println("\nOpção inválida\n");
            }


        } while (validarOpcao);
    }

    private void remover() {

        String menu = "Remover por NOME ou por NÚMERO?\n" +
                "\n1 - NOME" +
                "\n2 - NÚMERO" +
                "\n3 - VOLTAR" +
                "\n -> ";
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

    private boolean verificarListaPorNome(String usuarioParaRemocao) {

        boolean encontrou = listaDeNomes.contains(usuarioParaRemocao);

        return encontrou;
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

        String menu = "Digite [1] para Nomes maiores que 5 letras" +
                "\nDigite [2] para Nomes menores que 5 letras" +
                "\nDigite [3] para Voltar ao Menu inicial.";


        System.out.println(menu);

        try {
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
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido!");
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

        String menu = "\n1 - Ordem alfavética (A - Z)" +
                "\n2 - Ordem reversa (Z - A)" +
                "\n3 - Voltar\n-> ";

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

    private void exibirListaFormatada() {

        for (int i = 0; i < listaDeNomes.size(); i++) {
            System.out.println((i + 1) + " - " + listaDeNomes.get(i));
        }
        System.out.println("Total: " + listaDeNomes.size() + " nomes\n");
    }

}