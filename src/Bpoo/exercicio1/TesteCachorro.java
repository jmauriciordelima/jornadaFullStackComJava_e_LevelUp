package Bpoo.exercicio1;

import java.util.ArrayList;

public class TesteCachorro {

    public static void main(String[] args) {

        ArrayList<Cachorro> cachorros = new ArrayList<>();

        Cachorro rex = new Cachorro();
        rex.setNome("Rex");
        rex.setRaca("Labrador");
        rex.setIdade(3);

        cachorros.add(rex);


        Cachorro bob = new Cachorro();
        bob.setNome("Bob");
        bob.setRaca("Poodle");
        bob.setIdade(5);

        cachorros.add(bob);


        Cachorro max = new Cachorro();
        max.setNome("Max");
        max.setRaca("Vira-Lata");
        max.setIdade(2);

        cachorros.add(max);

        for (Cachorro cachorro : cachorros) {
            cachorro.exibirInformacoes();
        }

        Cachorro maisVelho = cachorros.get(0);;
        for (Cachorro cachorro : cachorros) {
            if (cachorro.getIdade() > maisVelho.getIdade()) {
                maisVelho = cachorro;
            }
        }

        System.out.println("Cachorro mais velho: " + maisVelho.getNome() + " (" +
                maisVelho.getIdade() + ") anos.");

    }
}
