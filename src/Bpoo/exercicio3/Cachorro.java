package Bpoo.exercicio3;

public class Cachorro {

    private String nome;
    private String raca;
    private int idade;
    private boolean latindo = false;

    public Cachorro() {
    }

    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public Cachorro(String nome, String raca, int idade) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    public String faseDaVida(int idade) {

        String qualIdade = "";

        if (idade > 10) {
            qualIdade = "Idoso";
        } else if (idade <= 10 && idade > 2) {
            qualIdade = "Adulto";
        } else {
            qualIdade = "Filhote";
        }

        return qualIdade;
    }

    private int calcularIdadeEmMeses() {
        return getIdade() * 12;
    }

    private int calcularIdadeHumana() {
        return getIdade() * 7;
    }

    public String fazerAniversario() {
        setIdade((getIdade() + 1));
        return String.format("%s fez aniversário, sua nova idade agora é %s",
                getNome(), formatarMensagemIdade());
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
                        
                        %s\
                        
                        
                        """,
                getNome(),
                getIdade(),
                faseDaVida(getIdade()),
                calcularIdadeEmMeses(),
                calcularIdadeHumana(),
                getNome(),
                getRaca(),
                formatarMensagemIdade(),
                fazerAniversario());
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

    public boolean getLatindo() {
        return latindo;
    }

    public void setLatindo(boolean latindo) {
        this.latindo = latindo;
    }
}
