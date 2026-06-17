package Bpoo.projeto_canil.modelo;

/**
 * Representa um animal do tipo Cachorro no sistema.
 * Contém informações sobre nome, raça, idade e estado comportamental.
 */
public class Cachorro {

    private String nome;
    private String raca;
    private int idade;
    private boolean latindo;

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
     * Construtor completo.
     *
     * @param nome    O nome do cachorro.
     * @param raca    A raça do cachorro.
     * @param idade   A idade em anos.
     * @param latindo Estado atual do cachorro (true se estiver latindo).
     */
    public Cachorro(String nome, String raca, int idade, boolean latindo) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.latindo = latindo;
    }

    /**
     * Determina a fase da vida do cachorro com base na idade.
     *
     * @return Uma String indicando se é "Filhote", "Adulto" ou "Idoso".
     */
    public String faseDaVida() {
        String faseDaVida = "";

        if (this.idade > 10) {
            faseDaVida = "Idoso";
        } else if (this.idade <= 10 && this.idade > 2) {
            faseDaVida = "Adulto";
        } else {
            faseDaVida = "Filhote";
        }

        return faseDaVida;
    }

    private int calcularIdadeEmMeses() {
        return getIdade() * 12;
    }

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

    private String formatarMensagemIdade() {
        if (getIdade() == 1) {
            return getIdade() + " ano.";
        }

        return getIdade() + " anos.";
    }

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

    // Getters e Setters omitidos por brevidade, mas devem ser documentados se forem parte de API pública.
    public String getNome() {
        return nome;
    }

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

    public boolean isLatindo() {
        return latindo;
    }

    public void setLatindo(boolean latindo) {
        this.latindo = latindo;
    }
}
