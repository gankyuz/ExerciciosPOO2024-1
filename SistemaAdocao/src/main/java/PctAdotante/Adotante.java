package PctAdotante;

public class Adotante {
    private String nomeAdotante;
    private String idade;
    public Contato contato;

    public Adotante(String nomeAdotante, String idade, Contato contato){
        this.nomeAdotante = nomeAdotante;
        this.idade = idade;
        this.contato = contato;
    }

    public Adotante(){
        this("","",null);
    }

    public String getNomeAdotante() {
        return nomeAdotante;
    }

    public void setNomeAdotante(String nomeAdotante) {
        this.nomeAdotante = nomeAdotante;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adotante adotante = (Adotante) o;
        return nomeAdotante.equals(adotante.nomeAdotante) && idade.equals(adotante.idade) && contato.equals(adotante.contato);
    }

    @Override
    public int hashCode() {
        int result = nomeAdotante.hashCode();
        result = 31 * result + idade.hashCode();
        result = 31 * result + contato.hashCode();
        return result;
    }

    public String toString(){
        return "ADOTANTE:\n\n" +
                "Nome: "+this.nomeAdotante+"\n" +
                "Idade: "+this.idade+"\n" +
                "CONTATO\n"+this.contato;
    }
}
