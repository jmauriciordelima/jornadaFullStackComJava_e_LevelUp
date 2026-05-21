package Bpoo.exercicio3;

import java.util.ArrayList;

public class TesteCachorro {

    public static void main(String[] args) {

        ArrayList<Cachorro> cachorros = new ArrayList<>();

        Cachorro rex = new Cachorro("Rex", "Labrador");
        rex.setRaca("Labrador Retriever");
        rex.setIdade(3);
        rex.setLatindo(true);
        rex.fazerAniversario();

        cachorros.add(rex);



        Cachorro bob = new Cachorro("Bob", "Poodle", 4);
        bob.setIdade(5);
        bob.setLatindo(true);

        cachorros.add(bob);


        Cachorro max = new Cachorro();
        max.setNome("Max");
        max.setRaca("Vira-Lata");
        max.setIdade(2);
        max.setLatindo(false);

        cachorros.add(max);

        cachorros.add(new Cachorro("Petrer", "Pastor"));


        Cachorro pepper = new Cachorro();
        pepper.setNome("Pepper");
        pepper.setIdade(2);
        pepper.setLatindo(true);
        pepper.setRaca("Pastror Maiorquino");
        cachorros.add(pepper);
        pepper.fazerAniversario();


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

