package Bpoo.projeto_canil.modelo;

import java.util.Objects;

/**
 * Entidade que representa um cachorro cadastrado no sistema.
 * <p>
 * Contém informações básicas como nome, raça e idade,
 * além de regras de negócio relacionadas à fase da vida
 * e cálculos derivados da idade.
 *
 * @author José Maurício
 * @version 1.0
 */
public class Cachorro {

    private int id;
    private String nome;
    private String raca;
    private int idade;

    /**
     * Construtor padrão para inicialização.
     */
    public Cachorro() {
    }

    /**
     * Construtor para criar um novo cachorro com nome e raça.
     *
     * @param nome O nome do cachorro.
     * @param raca A raça do cachorro.
     */
    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    /**
     * Construtor para criar um novo cachorro com nome, raça e idade.
     *
     * @param nome  O nome do cachorro.
     * @param raca  A raça do cachorro.
     * @param idade A idade em anos.
     */
    public Cachorro(String nome, String raca, int idade) {
        this(nome, raca);
        this.idade = idade;
    }

    /**
     * Construtor utilizado pelo repositório ao carregar dados do arquivo.
     *
     * @param id    Identificador único persistido.
     * @param nome  Nome do cachorro.
     * @param raca  Raça do cachorro.
     * @param idade Idade em anos.
     */
    public Cachorro(int id, String nome, String raca, int idade) {
        this(nome, raca, idade);
        this.id = id;
    }

    /**
     * Determina a fase da vida do cachorro com base na idade.
     *
     * @return Uma String indicando se é "Filhote", "Adulto" ou "Idoso".
     */
    public FaseVida faseDaVida() {

        if (this.idade > 10) {
            return FaseVida.IDOSO;
        } else if (this.idade <= 10 && this.idade > 2) {
            return FaseVida.ADULTO;
        } else {
            return FaseVida.FILHOTE;
        }

    }

    /**
     * Converte a idade do cachorro para meses.
     *
     * @return idade em meses.
     */
    private int calcularIdadeEmMeses() {
        return getIdade() * 12;
    }

    /**
     * Calcula uma equivalência simplificada da idade
     * do cachorro em anos humanos.
     *
     * @return idade humana equivalente.
     */
    private int calcularIdadeHumana() {
        return getIdade() * 7;
    }

    /**
     * Realiza o aniversário do cachorro, incrementando sua idade.
     *
     * @return Uma mensagem formatada informando a nova idade.
     */
    public String fazerAniversario() {
        setIdade((getIdade() + 1));

        return String.format("%s FEZ ANIVERSÁRIO, SUA NOVA IDADE AGORA É %s", getNome(), formatarMensagemIdade());
    }

    /**
     * Formata a idade utilizando singular ou plural.
     *
     * @return idade formatada para exibição.
     */
    private String formatarMensagemIdade() {
        if (getIdade() == 1) {
            return getIdade() + " ANO.";
        }

        return getIdade() + " ANOS.";
    }

    /**
     * Exibe no console as informações detalhadas do cachorro,
     * incluindo cálculos de idade humana e meses.
     */
    public void exibirInformacoes() {
        System.out.printf("""
                ID: %d\
                
                NOME: %s\
                
                IDADE: %d\
                
                FASE DA VIDA: %s\
                
                IDADE EM MESES: %d\
                
                IDADE HUMANA: %d\
                
                %s É UM %s DE %s\
                
                
                """,getId(), getNome(), getIdade(), faseDaVida(), calcularIdadeEmMeses(), calcularIdadeHumana(), getNome(), getRaca(), formatarMensagemIdade());
    }

    /**
     * @return nome do cachorro.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cachorro.
     *
     * @param nome novo nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a raça do cachorro.
     * @return Uma String representando a raça.
     */
    public String getRaca() {
        return raca;
    }

    /**
     * Define a raça do cachorro.
     * @param raca A nova raça a ser atribuída.
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * Retorna a idade atual do cachorro em anos.
     * @return Um inteiro representando a idade.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Atualiza a idade do cachorro.
     * @param idade A nova idade a ser definida.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna o id
     * @return Um inteiro representando o id.
     */
    public int getId() {
        return id;
    }

    /**
     * Atualiza o id do cachorro.
     * @param id Um novo id para o cachorro.
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CACHORRO [ID: " + id + ", NOME: " + nome + ", RAÇA: " + raca + ", IDADE: " + idade + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cachorro cachorro = (Cachorro) o;
        return id == cachorro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
