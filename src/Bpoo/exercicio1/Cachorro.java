package Bpoo.exercicio1;

public class Cachorro {

    private String nome;
    private String raca;
    private int idade;

    public void exibirInformacoes() {
        System.out.printf("""
                        
                        Nome: %s\
                        
                        Raça: %s\
                        
                        Idade: %d anos\
                        
                        
                        """,
                getNome(),
                getRaca(),
                getIdade());

    }

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
}
