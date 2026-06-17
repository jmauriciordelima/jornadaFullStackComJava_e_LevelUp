package Bpoo.projeto_canil.modelo;

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
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
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

        return String.format("%s fez aniversário, sua nova idade agora é %s", getNome(), formatarMensagemIdade());
    }

    /**
     * Formata a idade utilizando singular ou plural.
     *
     * @return idade formatada para exibição.
     */
    private String formatarMensagemIdade() {
        if (getIdade() == 1) {
            return getIdade() + " ano.";
        }

        return getIdade() + " anos.";
    }

    /**
     * Exibe no console as informações detalhadas do cachorro,
     * incluindo cálculos de idade humana e meses.
     */
    public void exibirInformacoes() {
        System.out.printf("""
                Nome: %s\
                
                Idade: %d\
                
                Fase da vida: %s\
                
                Idade em meses: %d\
                
                Idade humana: %d\
                
                %s é um %s de %s\
                
                
                """, getNome(), getIdade(), faseDaVida(), calcularIdadeEmMeses(), calcularIdadeHumana(), getNome(), getRaca(), formatarMensagemIdade());
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
