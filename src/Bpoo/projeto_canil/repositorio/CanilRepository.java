package Bpoo.projeto_canil.repositorio;

import Bpoo.projeto_canil.modelo.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por gerenciar o armazenamento e persistência da coleção de cachorros.
 */
public class CanilRepository {

    private ArrayList<Cachorro> cachorros;

    public CanilRepository() {

        this.cachorros = new ArrayList<>();
    }

    /**
     * Adiciona um novo cachorro ao repositório em memória.
     * @param cachorro O objeto {@link Cachorro} a ser adicionado.
     */
    public void adicionar(Cachorro cachorro) {

        cachorros.add(cachorro);
    }

    /**
     * Recupera todos os cachorros armazenados.
     * @return Uma {@link List} contendo todos os cachorros.
     */
    public ArrayList<Cachorro> listarTodos() {

        return cachorros;
    }

    public boolean estaVazio() {

        return cachorros.isEmpty();
    }

    public int quantidadeTotal() {

        return cachorros.size();
    }

    /**
     * Busca um cachorro pelo nome.
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
     * @param arquivoCachorros Nome do arquivo de destino.
     */
    public void salvarEmArquivo(String arquivoCachorros) {
        try (PrintWriter escrever = new PrintWriter(new BufferedWriter(new FileWriter(arquivoCachorros)))) {
            for (Cachorro c : cachorros) {
                escrever.printf("%s;%s;%d;%b%n",
                        c.getNome(),
                        c.getRaca(),
                        c.getIdade(),
                        c.isLatindo());
            }

            System.out.println("Arquivo salvo com sucesso!");

        } catch (IOException e) {
            System.err.printf("Erro ao salvar o arquivo: %s", e.getMessage());
        }
    }

    /**
     * Carrega a lista de cachorros a partir de um arquivo .txt.
     * @param arquivoCachorro Nome do arquivo de origem.
     * @return A lista de cachorros carregada do arquivo.
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
                if (dados.length == 4) {
                    String nome = dados[0];
                    String raca = dados[1];
                    int idade = Integer.parseInt(dados[2]);
                    boolean latindo = Boolean.parseBoolean(dados[3]);

                    cachorros.add(new Cachorro(nome, raca, idade, latindo));
                }
            }

        }catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return cachorros;
    }


}
