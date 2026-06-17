package Bpoo.projeto_canil.servico;

import Bpoo.projeto_canil.modelo.Cachorro;
import Bpoo.projeto_canil.repositorio.CanilRepository;
import Bpoo.projeto_canil.util.MenuUtil;

import java.util.ArrayList;

/**
 * Contém a regra de negócio do sistema.
 * Processa dados providos pelo {@link CanilRepository}.
 */
public class CanilService {

    private CanilRepository repository;

    public CanilService(CanilRepository repository) {
        this.repository = repository;
    }

    /**
     * Localiza o cachorro com a maior idade no canil.
     * @return O objeto {@link Cachorro} mais velho, ou {@code null} se o canil estiver vazio.
     */
    public Cachorro buscarMaisVelho() {
        // 1. Verificar se está vazio
        if (repository.estaVazio()) {
            return null;
        }
        // 2. Inicializar candidato com primeiro da lista
        ArrayList<Cachorro> cachorros = repository.listarTodos();
        // 3. Loop comparando idades
        Cachorro maisVelho = cachorros.get(0);
        for (Cachorro cachorro : cachorros) {
            if (cachorro.getIdade() > maisVelho.getIdade()) {
                maisVelho = cachorro;
            }
        }
        // 4. Retornar candidato final
        return maisVelho;

    }

    public Cachorro buscarMenorIdade() {
        // Idêntico ao buscarMaisVelho, muda só a comparação
        if (repository.estaVazio()) {
            return null;
        }

        ArrayList<Cachorro> cachorros = repository.listarTodos();

        Cachorro menorIdade = cachorros.get(0);
        for (Cachorro cachorro : repository.listarTodos()) {
            if (cachorro.getIdade() < menorIdade.getIdade()) {
                menorIdade = cachorro;
            }
        }

        return menorIdade;
    }

    /**
     * Calcula a média de idade de todos os cachorros no canil.
     * @return A média das idades como {@code double}.
     */
    public double calcularIdadeMedia() {

        if (repository.estaVazio()) {
            return 0;
        }

        int total = repository.quantidadeTotal();
        int somaTotalIdade = 0;

        for (Cachorro listarTodo : repository.listarTodos()) {
            somaTotalIdade += listarTodo.getIdade();
        }

        double resultado = (double) somaTotalIdade / total;

        return resultado;

    }

    public ArrayList<Cachorro> listarPorFase(String fase) {
        // 1. Criar lista resultado vazia
        ArrayList<Cachorro> faseDaVida = new ArrayList<>();
        // 2. Loop pela lista
        for (Cachorro cachorro : repository.listarTodos()) {
            if (cachorro.faseDaVida().equalsIgnoreCase(fase)) {
                faseDaVida.add(cachorro);
            }
        }
        // 3. Se faseDaVida() == fase → adicionar no resultado
        return faseDaVida;
        // 4. Retornar resultado
    }

    public void exibirEstatisticas() {
        // Chama os métodos acima e exibe formatado
        MenuUtil.exibirCabecalho("ESTATÍSTICAS DO CANIL");

        System.out.println("Total de cachorros: " + repository.quantidadeTotal());

        System.out.printf("Idade média: %.1f" +
                "%n", calcularIdadeMedia());

        Cachorro maisVelho = buscarMaisVelho();

        if (maisVelho != null) {
            System.out.printf("Mais velho: %s (%d idade.)%n",
                    maisVelho.getNome(),
                    maisVelho.getIdade());
        }

        Cachorro maisNovo = buscarMenorIdade();

        if (maisNovo != null) {
            System.out.printf("Menor idade: %s (%d idade.)%n",
                    maisNovo.getNome(),
                    maisNovo.getIdade());
        }

        System.out.println("Filhotes: " + listarPorFase("Filhote").size());
        System.out.println("Adultos: " + listarPorFase("Adulto").size());
        System.out.println("Idosos: " + listarPorFase("Idoso").size());
    }

}
