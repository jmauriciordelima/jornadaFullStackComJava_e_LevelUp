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
public class Cachorro extends Animal {

    private String raca;

    /**
     * Construtor completo para a criação de uma nova instância de {@link Cachorro}.
     *
     * @param id    O identificador único do cachorro.
     * @param nome  O nome atribuído ao animal.
     * @param raca  A raça específica do animal.
     * @param idade A idade do animal em anos.
     */
    public Cachorro(int id, String nome, String raca, int idade) {
        super(id, nome, idade);
        this.raca = raca;
    }

    /**
     * Determina a fase da vida do cachorro com base na idade.
     *
     * @return Uma String indicando se é "Filhote", "Adulto" ou "Idoso".
     */
    @Override
    public FaseVida faseDaVida() {

        if (getIdade() > 10) {
            return FaseVida.IDOSO;
        } else if (getIdade() <= 10 && getIdade() > 2) {
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
     * Exibe no console as informações detalhadas do cachorro,
     * incluindo cálculos de idade humana e meses.
     */
    @Override
    public void exibirInformacoes() {
        System.out.printf("""
                ID: %d\
                
                NOME: %s\
                
                IDADE: %d\
                
                FASE DA VIDA: %s\
                
                IDADE EM MESES: %d\
                
                IDADE HUMANA: %d\
                
                %s É UM %s DE %s\
                
                
                """, getId(), getNome(), getIdade(), faseDaVida(), calcularIdadeEmMeses(), calcularIdadeHumana(), getNome(), getRaca(), formatarMensagemIdade());
    }

    /**
     * Retorna a raça do cachorro.
     *
     * @return Uma String representando a raça.
     */
    public String getRaca() {
        return raca;
    }

    /**
     * Define a raça do cachorro.
     *
     * @param raca A nova raça a ser atribuída.
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "CACHORRO [ID: " + getId() + ", NOME: " + getNome() + ", RAÇA: " + getRaca() + ", IDADE: " + getIdade() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cachorro cachorro = (Cachorro) o;
        return getId() == cachorro.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
