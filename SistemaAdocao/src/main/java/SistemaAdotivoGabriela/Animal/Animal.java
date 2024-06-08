package SistemaAdotivoGabriela.Animal;

public class Animal {

        private String nomeAnimal;
        private String racaAnimal;
        private String idadeAnimal;
        private String porteAnimal;


        public Animal(String nomeAnimal, String racaAnimal, String idadeAnimal, String porteAnimal){
            this.nomeAnimal = nomeAnimal;
            this.racaAnimal = racaAnimal;
            this.idadeAnimal = idadeAnimal;
            this.porteAnimal = porteAnimal;
        }
        public Animal(){
            this("","","","0");
        }

    public String getPorteAnimal() {
        return porteAnimal;
    }

    public void setPorteAnimal(String porteAnimal) {
        this.porteAnimal = porteAnimal;
    }

    public String getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(String idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public String getRacaAnimal() {
        return racaAnimal;
    }

    public void setRacaAnimal(String racaAnimal) {
        this.racaAnimal = racaAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return nomeAnimal.equals(animal.nomeAnimal) && racaAnimal.equals(animal.racaAnimal) && idadeAnimal.equals(animal.idadeAnimal) && porteAnimal.equals(animal.porteAnimal);
    }

    @Override
    public int hashCode() {
        int result = nomeAnimal.hashCode();
        result = 31 * result + racaAnimal.hashCode();
        result = 31 * result + idadeAnimal.hashCode();
        result = 31 * result + porteAnimal.hashCode();
        return result;
    }

    @Override
    public String toString(){
            return "=====> Animal <=====\n" +
                    "Nome: "+this.nomeAnimal+"\n" +
                    "Idade: "+this.idadeAnimal+"\n" +
                    "Raça: "+this.racaAnimal+"\n" +
                    "Porte: "+this.porteAnimal;
    }
}
