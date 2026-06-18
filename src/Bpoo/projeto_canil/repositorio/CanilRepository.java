package Bpoo.projeto_canil.repositorio;

import Bpoo.projeto_canil.modelo.Cachorro;
import Bpoo.projeto_canil.util.MenuUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável pela persistência e gerenciamento
 * dos dados dos cachorros.
 *
 * Atua como camada de acesso aos dados
 * armazenados em memória e em arquivo.
 *
 * @author José Maurício
 * @version 1.0
 */
public class CanilRepository {

    private ArrayList<Cachorro> cachorros;

    /**
     * Construtor padrão da classe {@link CanilRepository}.
     * <p>
     * Inicializa a lista interna de cachorros como um novo {@link ArrayList} vazio,
     * garantindo que o repositório esteja pronto para receber dados desde a sua criação.
     * </p>
     */
    public CanilRepository() {
        this.cachorros = new ArrayList<>();
    }

    /**
     * Adiciona um novo cachorro ao repositório em memória.
     *
     * @param cachorro O objeto {@link Cachorro} a ser adicionado.
     */
    public void adicionar(Cachorro cachorro) {

        cachorros.add(cachorro);
    }

    /**
     * Recupera todos os cachorros armazenados.
     *
     * @return Uma {@link List} contendo todos os cachorros.
     */
    public ArrayList<Cachorro> listarTodos() {

        return cachorros;
    }

    /**
     * Verifica se existem cachorros cadastrados.
     *
     * @return true se não houver registros.
     */
    public boolean estaVazio() {

        return cachorros.isEmpty();
    }

    /**
     * Retorna a quantidade total de cachorros.
     *
     * @return número de registros cadastrados.
     */
    public int quantidadeTotal() {

        return cachorros.size();
    }

    /**
     * Busca um cachorro pelo nome.
     *
     * @param nome Nome para busca (case-insensitive).
     * @return O objeto Cachorro encontrado ou null caso não exista.
     */
    public Cachorro buscarPorNome(String nome) {

        for (Cachorro c : cachorros) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Remove um cachorro do repositório baseado no nome.
     *
     * @param nome Nome do cachorro a ser removido.
     * @return true se removido com sucesso, false caso contrário.
     */
    public boolean removerPorNome(String nome) {

        Cachorro c = buscarPorNome(nome);

        if (c != null) {
            return cachorros.remove(c);
        }

        return false;

    }

    /**
     * Salva todos os cachorros atuais do sistema em um arquivo .txt.
     *
     * @param arquivoCachorros Nome do arquivo de destino.
     */
    public void salvarEmArquivo(String arquivoCachorros) {
        try (PrintWriter escrever = new PrintWriter(new BufferedWriter(new FileWriter(arquivoCachorros)))) {
            for (Cachorro c : cachorros) {
                escrever.printf("%s;%s;%d;%n",
                        c.getNome(),
                        c.getRaca(),
                        c.getIdade());

            }

            MenuUtil.exibirMensagemSucesso(" - ARQUIVO SALVO COM SUCESSO");

        } catch (IOException e) {
            MenuUtil.exibirMensagemErro("ERRO AO SALVAR O ARQUIVO: " + e.getMessage());
        }
    }

    /**
     * Carrega todos os registros persistidos
     * em arquivo texto.
     *
     * Caso o arquivo não exista,
     * retorna uma lista vazia.
     *
     * @param arquivoCachorro caminho do arquivo.
     * @return lista de cachorros carregados.
     */
    public List<Cachorro> carregarDeArquivo(String arquivoCachorro) {
        this.cachorros = new ArrayList<>();
        File arquivo = new File(arquivoCachorro);

        if (!arquivo.exists()) {
            return cachorros;
        }

        try (BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = ler.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    String nome = dados[0];
                    String raca = dados[1];
                    int idade = Integer.parseInt(dados[2]);

                    cachorros.add(new Cachorro(nome, raca, idade));
                }
            }

        } catch (IOException | NumberFormatException e) {
            MenuUtil.exibirMensagemErro("ERRO AO LER O ARQUIVO: " + e.getMessage());
        }
        return cachorros;
    }


}
