package Bpoo.projeto_canil;

import Bpoo.projeto_canil.modelo.Cachorro;
import Bpoo.projeto_canil.repositorio.CanilRepository;
import Bpoo.projeto_canil.servico.CanilService;
import Bpoo.projeto_canil.util.MenuUtil;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static CanilRepository repository = new CanilRepository();
    private static CanilService service = new CanilService(repository);
    private static Scanner scanner = new Scanner(System.in);
    private static boolean executando = true;
    private static final String ARQUIVO = "canil.txt";

    public static void main(String[] args) {

        iniciarMenu();

    }

    public static void iniciarMenu() {

        repository.carregarDeArquivo(ARQUIVO);

        do {
            MenuUtil.exibirMenuPrincipal();
            String entradaMenu = scanner.nextLine().toUpperCase();
            switch (entradaMenu) {
                case "1": {
                    MenuUtil.exibirCabecalho("ADICIONAR CACHORRO");
                    System.out.print("INFORME NOME DO CACHORRO > ");
                    String nome = scanner.nextLine().toUpperCase();
                    System.out.print("INFORME A RAÇA DO CACHORRO > ");
                    String raca = scanner.nextLine().toUpperCase();
                    System.out.print("INFORME A IDADE DO CACHORRO > ");
                    try {
                        int idade = Integer.parseInt(scanner.nextLine());
                        Cachorro cachorro = new Cachorro(nome, raca, idade);
                        repository.adicionar(cachorro);
                        MenuUtil.exibirMensagemSucesso("[" + cachorro.getNome() + "] - ADICIONADO COM SUCESSO.");
                    } catch (NumberFormatException e) {
                        MenuUtil.exibirMensagemErro(" CARACTERE INVÁLIDO " + e);
                    }

                    break;
                }

                case "2": {

                    if (repository.estaVazio()) {
                        MenuUtil.exibirMensagemInfo("CANIL VAZIO");
                        break;
                    }

                    MenuUtil.exibirCabecalho("TODOS OS CACHORROS");

                    for (Cachorro cachorro : repository.listarTodos()) {
                        cachorro.exibirInformacoes();
                    }

                    break;
                }

                case "3": {

                    if (repository.estaVazio()) {
                        MenuUtil.exibirMensagemInfo("CANIL VAZIO");
                        break;
                    }

                    MenuUtil.exibirCabecalho("BUSCAR POR NOME");
                    System.out.print("NOME DO CACHORRO > ");
                    String buscarNomeCachorro = scanner.nextLine().toUpperCase();
                    Cachorro cachorro = repository.buscarPorNome(buscarNomeCachorro);

                    if (cachorro != null) {
                        cachorro.exibirInformacoes();
                    } else {
                        MenuUtil.exibirMensagemErro(" - CACHORRO NÃO ENCONTRADO");
                    }

                    break;

                }

                case "4": {

                    if (repository.estaVazio()) {
                        MenuUtil.exibirMensagemInfo("CANIL VAZIO");
                        break;
                    }

                    MenuUtil.exibirCabecalho("REMOVER CACHORRO");
                    System.out.print("NOME DO CACHORRO > ");
                    String removerCachorro = scanner.nextLine().toUpperCase();
                    boolean sucesso = repository.removerPorNome(removerCachorro);

                    if (sucesso) {
                        MenuUtil.exibirMensagemSucesso(removerCachorro + " - REMOVIDO COM SUCESSO");
                    } else {
                        MenuUtil.exibirMensagemErro(removerCachorro + "- NÃO ENCONTRADO");
                    }

                    break;

                }

                case "5": {

                    MenuUtil.exibirCabecalho("FAZER ANIVERSÁRIO");
                    System.out.print("NOME DO CACHORRO ANIVERSARIANTE > ");
                    String cachorroAniversariante = scanner.nextLine().toUpperCase();
                    Cachorro cachorro = repository.buscarPorNome(cachorroAniversariante);

                    if (cachorro != null) {
                        String mensagem = cachorro.fazerAniversario();
                        System.out.println(mensagem);
                    } else {
                        MenuUtil.exibirMensagemErro("- CACHORRO NÃO ENCONTRADO");
                    }

                    break;

                }

                case "6": {

                    if (repository.estaVazio()) {
                        MenuUtil.exibirMensagemErro("- CANIL VAZIO");
                        break;
                    }

                    MenuUtil.exibirCabecalho("ESTATÍSTICAS");

                    service.exibirEstatisticas();

                    break;
                }

                case "7": {
                    MenuUtil.exibirCabecalho("LISTAR POR FASE");


                    System.out.println("""
                            [1] - FILHOTE
                            [2] - ADULTO
                            [3] - IDOSO
                            """);

                    String fase = "";

                    String faseVida = scanner.nextLine();
                    switch (faseVida) {

                        case "1":
                            fase = "FILHOTE";
                            break;
                        case "2":
                            fase = "ADULTO";
                            break;
                        case "3":
                            fase = "IDOSO";
                            break;
                        default:
                            MenuUtil.exibirMensagemErro("- OPÇÃO INVÁLIDA");
                            break;
                    }

                    List<Cachorro> lista = service.listarPorFase(fase);
                    if (lista.isEmpty()) {
                        MenuUtil.exibirMensagemInfo("NENHUM CACHORRO NESSA FASE");
                    } else {
                        for (Cachorro cachorro : lista) {
                            cachorro.exibirInformacoes();
                        }
                    }

                    break;
                }

                case "8": {

                    if (repository.estaVazio()) {
                        MenuUtil.exibirMensagemErro("- CANIL VAZIO");
                        break;
                    }

                    MenuUtil.exibirCabecalho("MAIS VELHO / MAIS NOVO");

                    Cachorro cachorroMaisVelho = service.buscarMaisVelho();
                    Cachorro cachorroMenorIdade = service.buscarMenorIdade();

                    System.out.printf("Mais velho: %s (%d idade)%n",
                            cachorroMaisVelho.getNome(),
                            cachorroMaisVelho.getIdade());

                    System.out.printf("Mais novo: %s (%d idade)%n",
                            cachorroMenorIdade.getNome(),
                            cachorroMenorIdade.getIdade());

                    break;
                }

                case "9":
                    repository.salvarEmArquivo(ARQUIVO);
                    MenuUtil.exibirMensagemSucesso("- ARQUIVO SALVO COM SUCESSO");
                    break;

                case "0":
                    System.out.println("DESEJA SALVAR ANTES DE SAIR? (S/N)");
                    String resposta = scanner.nextLine().toUpperCase();

                    if (resposta.equals("S")) {
                        repository.salvarEmArquivo(ARQUIVO);
                        System.out.println("ATÉ LOGO");
                        MenuUtil.exibirCabecalho("FINALIZANDO...");
                        executando = false;
                    } else if (resposta.equals("N")) {
                        System.out.println("ATÉ LOGO");
                        MenuUtil.exibirCabecalho("FINALIZANDO...");
                        executando = false;
                    }
                    break;

                default:
                    MenuUtil.exibirMensagemErro("OPÇÃO INVÁLIDA!");

            }

        } while (executando);
    }
}
