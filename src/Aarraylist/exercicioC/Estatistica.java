package Aarraylist.exercicioC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Estatistica {

    private ArrayList<String> listaDeNomes = new ArrayList<>();
    private boolean validarOpcao = true;
    private final Scanner entrada = new Scanner(System.in);

    public Estatistica() {
        this.listaDeNomes = new ArrayList<>();
    }

    public void menu() {

        String menu = """
                ╔════════════════════════════════╗\
                
                ║     GERENCIADOR DE NOMES       ║\
                
                ╠════════════════════════════════╣\
                
                ║ [1] ADICIONAR NOME             ║\
                
                ║ [2] REMOVER NOME               ║\
                
                ║ [3] LISTAR POR TAMANHO         ║\
                
                ║ [4] BUSCAR POR NOME            ║\
                
                ║ [5] ORDENAR LISTA              ║\
                
                ║ [6] VER TODOS OS NOMES         ║\
                
                ║ [7] FILTRAR POR LETRA          ║\
                
                ║ [8] ESTATISTICAS               ║\
                
                ║ [0] SAIR                       ║\
                
                ╚════════════════════════════════╝\
                
                →""";

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
                case "8":
                    estatisticas();
                    break;
                case "0":
                    System.out.print("""
                            ╔═════════════════════════════════════════╗\
                            
                            ║               FINALIZANDO               ║\
                            
                            ╚═════════════════════════════════════════╝\
                            
                            """);
                    validarOpcao = false;
                    break;

                default:
                    System.out.print("""
                            ╔════════════════════════════════════════╗\
                            
                            ║             OPÇÃO INVÁLIDA             ║\
                            
                            ╚════════════════════════════════════════╝\
                            
                            """);

            }

        } while (validarOpcao);

    }


    //Opcao 1

    /**
     * Adiciona um nome à lista após converter para maiúsculas.
     * Verifica se o nome já existe antes de inserir para evitar duplicatas.
     */
    private void adicionar() {
        System.out.print("║ ADICIONAR → ");

        String entradaUsuarioParaAdicionar = entrada.nextLine().toUpperCase().trim();

        String cabecalho = """
                ║ %s - JÁ EXISTE.\
                
                ╚════════════════════════════════════════╝\
                
                """;

        if (verificarListaPorNome(entradaUsuarioParaAdicionar)) {

            System.out.printf(cabecalho,
                    entradaUsuarioParaAdicionar);
            return;
        }

        System.out.printf("""
                ║ %s - ADICIONADO COM SUCESSO!\
                
                ╚════════════════════════════════════════╝\
                
                """, entradaUsuarioParaAdicionar);

        listaDeNomes.add(entradaUsuarioParaAdicionar);
    }

    //Opcao 2

    /**
     * Gerencia a remoção de nomes da lista.
     * Oferece um submenu para remover por texto (NOME) ou por índice (NÚMERO).
     */
    private void remover() {

        String menuRemover = """
                ╔════════════════════════════════════════╗\
                
                ║    REMOVER POR NOME OU POR NÚMERO?     ║\
                
                ╠════════════════════════════════════════╣\
                
                ║ 1 - NOME\
                
                ║ 2 - NÚMERO\
                
                ║ 3 - VOLTAR\
                
                ╚════════════════════════════════════════╝\
                
                → """;

        int antesDaRemocao = listaDeNomes.size();

        if (verificaLista()) {
            return;
        }

        System.out.print(menuRemover);
        String opcao = entrada.nextLine().trim();

        if (!opcao.matches("[1-3]")) {

            System.out.print("""
                    ╔════════════════════════════════════════╗\
                    
                    ║             OPÇÃO INVÁLIDA             ║\
                    
                    ╚════════════════════════════════════════╝\
                    
                    """);

            return;
        }

        switch (opcao) {

            case "1":
                System.out.print("""
                        ╔════════════════════════════════════════╗\
                        
                        ║                REMOVER                 ║\
                        
                        ╚════════════════════════════════════════╝\
                        
                        →""");
                String usuarioParaRemocao = entrada.nextLine().toUpperCase();

                if (verificarListaPorNome(usuarioParaRemocao)) {
                    listaDeNomes.remove(usuarioParaRemocao);

                    System.out.printf("""
                                    ║ QUANTIDADE: %d ANTES | %d AGORA!\
                                    
                                    ║ NOME: %s REMOVIDO COM SUCESSO!\
                                    
                                    """,
                            antesDaRemocao,
                            listaDeNomes.size(),
                            usuarioParaRemocao);

                } else {
                    System.out.printf("""
                                    ║ NOME [%s] NÃO ENCONTRADO\
                                    
                                    ╚════════════════════════════════════════╝\
                                    
                                    """,
                            usuarioParaRemocao
                    );
                }

                break;

            case "2":
                System.out.print("║ REMOVER (DIGITE O NÚMERO) → ");

                try {
                    int indiceDoUsuario = Integer.parseInt(entrada.nextLine());

                    if (verificarListaPorIndice(indiceDoUsuario)) {
                        System.out.printf("""
                                        ║ QUANTIDADE : %d ANTES | %d AGORA!\
                                        
                                        ╚════════════════════════════════════════╝\
                                        
                                        """,
                                antesDaRemocao,
                                listaDeNomes.size()
                        );
                    }
                } catch (NumberFormatException e) {
                    System.out.print("""
                                    ║ ERRO: DIGITE APENAS NÚMEROS!\
                                    
                                    ╚════════════════════════════════════════╝\
                                    
                                    """);
                }
                break;

            case "3":
                break;

            default:
                System.out.println("""
                        ╔════════════════════════════════════════╗\
                        
                        ║             OPSÃO INVÁLIDA.            ║\
                        
                        ╚════════════════════════════════════════╝\
                        
                        """);
                break;
        }

    }

    /**
     * Verifica se um nome específico já está presente na lista.
     *
     * @param verificaNome O nome a ser buscado.
     * @return true se o nome existir, false caso contrário.
     */
    private boolean verificarListaPorNome(String verificaNome) {

        return listaDeNomes.contains(verificaNome);
    }

    /**
     * Remove um nome da lista baseado na posição informada pelo usuário (1-base).
     *
     * @param posicaoInformada O número exibido na tela para o usuário.
     * @return true se a remoção foi bem-sucedida.
     */
    private boolean verificarListaPorIndice(int posicaoInformada) {

        int indiceReal = posicaoInformada - 1;

        if (!(indiceReal >= 0 && indiceReal < listaDeNomes.size())) {
            System.out.println("""
                    ║ POSIÇÃO NÃO ENCONTRADA.\
                    
                    ╚════════════════════════════════════════╝\
                    
                    """);
            return false;
        } else {
            String nomeRemovido = listaDeNomes.get(indiceReal);
            listaDeNomes.remove(indiceReal);

            System.out.printf("""
                            
                            ║ NOME: [%s] NA POSIÇÃO [%d] REMOVIDO COM SUCESSO!
                            
                            ╚════════════════════════════════════════╝\
                            
                            """,
                    nomeRemovido,
                    posicaoInformada);
            return true;
        }
    }

    //Opcao 3

    /**
     * Submenu para filtrar a exibição dos nomes com base na quantidade de caracteres.
     */
    private void listaDeNomesAdicionados() {
        if (verificaLista()) {
            return;
        }

        System.out.print("""
                ╔═════════════════════════════════╗\
                
                ║       LISTAR POR TAMANHO        ║\
                
                ╠═════════════════════════════════╣\
                
                ║ 1 - MAIORES QUE 5 LETRAS\
                
                ║ 2 - MENORES QUE 5 LETRAS\
                
                ║ 3 - VOLTAR AO MENU ANTERIOR\
                
                ╚════════════════════════════════╝\
                
                → """);

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
                System.out.println("""
                                ╔════════════════════════════════════════╗\
                        
                                ║             OPÇÃO INVÁLIDA             ║\
                        
                                ╚════════════════════════════════════════╝\
                
                                """);
        }
    }

    /**
     * Percorre a lista e imprime apenas os nomes que possuem tamanho entre o mínimo e o máximo.
     *
     * @param tamanhoMinimo Quantidade mínima de letras.
     * @param tamanhoMaximo Quantidade máxima de letras.
     */
    private void listarNomesPorTamanho(int tamanhoMinimo, int tamanhoMaximo) {
        if (tamanhoLista() == 0) {
            return;
        }

        System.out.println("""
                ╔════════════════════════════════════════╗\
                
                ║           LISTAR POR TAMANHO           ║\
                
                ╠════════════════════════════════════════╣\
                """);

        int contador = 0;

        for (int i = 0; i < listaDeNomes.size(); i++) {
            String nome = listaDeNomes.get(i);
            int tamanho = nome.length();

            if (tamanho >= tamanhoMinimo && tamanho <= tamanhoMaximo) {
                System.out.printf("║ %d - %s - [%d]%n", (i + 1), nome, tamanho);
                contador++;
            }
        }

        System.out.printf("""
                        ║ NESTE INTERVALO: %d\
                        
                        ║ TOTAL CADASTRADOS: %d\
                        
                        ╚════════════════════════════════════════╝\
                        
                        """,
                contador, listaDeNomes.size());
    }

    /**
     * Atalho para retornar o tamanho da lista após verificar se ela está vazia.
     */
    private int tamanhoLista() {

        verificaLista();

        return listaDeNomes.size();
    }

    /**
     * Verifica se a lista de nomes está vazia e exibe um aviso ao usuário.
     *
     * @return true se a lista estiver vazia.
     */
    private boolean verificaLista() {

        boolean vazio = listaDeNomes.isEmpty();

        if (vazio) {
            System.out.println("""
                    ╔════════════════════════════════════════╗\
                    
                    ║            *LISTA VAZIA *              ║\
                    
                    ╚════════════════════════════════════════╝\
                    
                    """);
        }

        return vazio;
    }

    //OPÇÃO 4

    /**
     * Busca a posição exata (índice) de um nome na lista.
     */
    private void buscarNomes() {

        if (verificaLista()) {
            return;
        }

        System.out.print("""
                ╔════════════════════════════════════════╗\
                
                ║           BUSCAR POR NOME              ║\
                
                ╚════════════════════════════════════════╝\
                
                →""");
        String nome = entrada.nextLine().toUpperCase();

        int indice = listaDeNomes.indexOf(nome);

        if (indice != -1) {
            System.out.printf("""
                            ║ [%s] - ENCONTRADO NA POSIÇÃO %d%n
                            
                            ╚════════════════════════════════════════╝\
                            
                            """,
                    nome,
                    (indice + 1));
        } else {
            System.out.printf("""
                            ║ [%s] - NÃO ENCONTRADO.\
                            
                            ╚════════════════════════════════════════╝\
                            
                            """,
                    nome);
        }
    }

    //Opcao 5

    /**
     * Submenu para ordenar a lista em ordem crescente (A-Z) ou decrescente (Z-A).
     */
    private void ordenarLista() {

        if (verificaLista()) {
            return;
        }

        String menu = """
                ╔════════════════════════════════════════╗\
                
                ║             ORDENAR LISTA              ║\
                
                ╚════════════════════════════════════════╝\
                
                ║ 1 - ORDEM ALFABÉTICA(A - Z)\
                
                ║ 2 - ORDEM REVERSA(Z - A)\
                
                ║ 3 - VOLTAR\
                
                →""";

        System.out.print(menu);
        String opcao = entrada.nextLine().trim();

        if (!opcao.matches("[1-3]")) {

            System.out.print("""
                    ╔════════════════════════════════════════╗\
                    
                    ║             OPÇÃO INVÁLIDA             ║\
                    
                    ╚════════════════════════════════════════╝\
                    
                    """);

            return;
        }

        switch (opcao) {

            case "1":
                listaDeNomes.sort(null);
                System.out.print("""
                        ╔════════════════════════════════════════╗\
                        
                        ║         LISTA ORDENADA (A - Z)         ║\
                        
                        ╚════════════════════════════════════════╝\
                        
                        """);
                exibirListaFormatada();
                break;

            case "2":
                listaDeNomes.sort(Collections.reverseOrder());
                System.out.print("""
                        ╔════════════════════════════════════════╗\
                        
                        ║        LISTA ORDENADA (Z - A)          ║\
                        
                        ╚════════════════════════════════════════╝\
                        
                        """);
                exibirListaFormatada();
                break;

            case "3":
                break;

            default:
                System.out.print("""
                        ║ OPÇÃO INVÁLIDA, DIGIE UMA OPÇÃO VÁLIDA.\
                        
                        ╚════════════════════════════════════════╝\
                        
                        """);
                break;
        }
    }

    /**
     * Percorre toda a lista e imprime os nomes com sua numeração correspondente.
     */
    private void exibirListaFormatada() {
        for (int i = 0; i < listaDeNomes.size(); i++) {
            System.out.printf("║ %d - %s%n", (i + 1), listaDeNomes.get(i));
        }
        System.out.printf("""
                        ║ TOTAL: %d - CADASTRADOS\
                        
                        ╚════════════════════════════════════════╝\
                        
                        """,
                listaDeNomes.size());
    }


    //Opcao 6

    /**
     * Exibe todos os nomes cadastrados sem formatações adicionais de ordenação.
     */
    private void listarTodosOsNomes() {

        if (verificaLista()) {
            return;
        }

        String cabecalho = """
                ╔════════════════════════════════════════╗\
                
                ║       LISTA COMPLETA - CADASTRO        ║\
                
                ╠════════════════════════════════════════╣\
                """;
        System.out.println(cabecalho);

        for (int i = 0; i < listaDeNomes.size(); i++) {

            System.out.printf("""
                            ║ %d - %s\
                            
                            """,
                    (i + 1),
                    listaDeNomes.get(i));

        }

        System.out.print("╚════════════════════════════════════════╝\n");

    }

    //Opcao 7

    /**
     * Filtra e exibe nomes que começam com uma letra específica informada pelo usuário.
     * Também calcula a porcentagem que esses nomes representam no total da lista.
     */
    private void filtrarPorLetra() {

        if (verificaLista()) {
            return;
        }

        System.out.print("""
                ╔════════════════════════════════════════╗\
                
                ║           FILTRAR POR LETRA            ║\
                
                ╠════════════════════════════════════════╣\
                
                →""");

        String letra = entrada.nextLine().toUpperCase();

        if (!letra.matches("[A-Z]")) {
            System.out.print("""
                           ║ ERRO: DIGITE APENAS UMA LETRA.\
                           
                           ╚════════════════════════════════════════╝\
                           
                           """);
            return;
        }

        int contador = 0;

        listaDeNomes.sort(null);

        int quantidadeTotal = listaDeNomes.size();

        for (String nome : listaDeNomes) {
            if (nome.startsWith(letra)) {
                System.out.printf("║ %d - %s%n", ++contador, nome);
            }
        }

        if (contador == 0) {
            System.out.printf("""
                            ║ NENHUM NOME ENCONTRADO COM A LETRA [%s]\
                            
                            ║ TOTAL CADASTRADOS: %d NOMES\
                            
                            ╚═════════════════════════════════════════╝\
                            
                            """,
                    letra,
                    quantidadeTotal);

        } else {
            double porcentagemNomes = ((double) contador / quantidadeTotal) * 100;
            System.out.printf("""
                            ║ TOTAL ENCONTRADO: %d DE %d NOMES (%.2f%%)\
                            
                            ╚═════════════════════════════════════════╝\
                            """,
                    contador,
                    quantidadeTotal,
                    porcentagemNomes);
        }

    }

    //Opcao 8

    /**
     * Consolida e exibe no console um relatório com: total de nomes,
     * nome mais longo, nome mais curto e a letra que mais aparece no sistema.
     */
    private void estatisticas() {

        if (verificaLista()) {
            return;
        }

        int quantidadeTotal = listaDeNomes.size();
        String nomeMaisLongo = listaDeNomes.get(0);
        String nomeMenor = listaDeNomes.get(0);

        for (String nome : listaDeNomes) {

            if (nome.length() > nomeMaisLongo.length()) {
                nomeMaisLongo = nome;
            }

            if (nome.length() < nomeMenor.length()) {
                nomeMenor = nome;
            }

        }

        char letraMaisFrequente = encontrarLetraMaisFrequente();
        int contadorLetra = contarLetra(letraMaisFrequente);

        System.out.printf("""
                        ╔════════════════════════════════════════╗\
                        
                        ║              ESTATÍSTICAS              ║\
                        
                        ╠════════════════════════════════════════╣\
                        
                        ║ TOTAL DE NOMES INSERIDOS: %d\
                        
                        ║ NOME MAIS LONGO: %s\
                        
                        ║   └─ %d LETRAS\
                        
                        ║ NOME MAIS CURTO: %s\
                        
                        ║   └─ %d LETRAS\
                        
                        ║ LETRA MAIS FREQUENTE: %c\
                        
                        ║   └─ APARECE %d VEZES\
                        
                        ╚═════════════════════════════════════════╝\
                        
                        """,
                quantidadeTotal,
                nomeMaisLongo,
                nomeMaisLongo.length(),
                nomeMenor,
                nomeMenor.length(),
                letraMaisFrequente,
                contadorLetra);
    }

    /**
     * Algoritmo que utiliza um array de inteiros (frequência) para descobrir qual
     * caractere de A-Z aparece mais vezes somando todos os nomes da lista.
     *
     * @return O caractere (char) mais frequente.
     */
    private char encontrarLetraMaisFrequente() {

        int[] contadorLetras = new int[26];

        for (String nome : listaDeNomes) {
            for (char letra : nome.toCharArray()) {
                if (letra >= 'A' && letra <= 'Z') {
                    int posicao = letra - 'A';
                    contadorLetras[posicao]++;
                }
            }
        }

        int maiorContagem = -1;
        int posicaoMaiorLetra = 0;

        for (int i = 0; i < 26; i++) {

            if (contadorLetras[i] > maiorContagem) {
                maiorContagem = contadorLetras[i];
                posicaoMaiorLetra = i;
            }
        }

        return (char) ('A' + posicaoMaiorLetra);
    }

    /**
     * Conta individualmente quantas vezes um caractere específico aparece em todos os nomes.
     *
     * @param letra A letra que deseja contar.
     * @return O número total de ocorrências.
     */
    private int contarLetra(char letra) {

        int total = 0;

        char letraBusca = letra;

        for (String nome : listaDeNomes) {
            for (char c : nome.toCharArray()) {
                if (c == letraBusca) {
                    total++;
                }
            }
        }
        return total;
    }
}
