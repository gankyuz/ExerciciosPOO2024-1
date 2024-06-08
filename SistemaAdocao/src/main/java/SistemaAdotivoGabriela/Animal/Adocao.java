package SistemaAdotivoGabriela.Animal;

import PctAdotante.Adotante;

public class Adocao {
    private Animal animal;
    private Adotante adotante;

    public Adocao(Animal animal, Adotante adotante){
        this.animal = animal;
        this.adotante = adotante;
    }
    public Adocao(){
        this(null,null);
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String toString(){
        return "ADOÇÕES\n" +
                "Animal: "+this.animal.getNomeAnimal()+
                "\nAdotante:  "+this.adotante.getNomeAdotante();
    }

}
