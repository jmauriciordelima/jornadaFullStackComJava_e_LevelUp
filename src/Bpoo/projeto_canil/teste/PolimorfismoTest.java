package Bpoo.projeto_canil.teste;

import Bpoo.projeto_canil.modelo.Animal;
import Bpoo.projeto_canil.modelo.Cachorro;
import Bpoo.projeto_canil.modelo.Gato;

import java.util.ArrayList;

public class PolimorfismoTest {

    public static void main(String[] args) {

        ArrayList<Animal> animais = new ArrayList<>();
        Animal cachorro = new Cachorro(5, "mel", "shin tzu", 1);
        Animal gato = new Gato(6, "melinda", 4, false);

        animais.add(cachorro);
        animais.add(gato);

        for (Animal animal : animais) {
            animal.exibirInformacoes();
        }


    }
}