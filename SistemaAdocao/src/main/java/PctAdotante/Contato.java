package PctAdotante;

public class Contato {

    private String contatoTelefonico;
    private String logradouro;
    private String numeroCasa;
    private String bairro;
    private String cidade;


    public Contato(String contatoTelefonico, String logradouro, String numeroCasa, String bairro, String cidade){
        this.contatoTelefonico = contatoTelefonico;
        this.logradouro = logradouro;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;

    }

    public Contato(){
        this("","","","","");
    }

    public String getContatoTelefonico() {
        return contatoTelefonico;
    }

    public void setContatoTelefonico(String contatoTelefonico) {
        this.contatoTelefonico = contatoTelefonico;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String toString(){
        return "Telefone: "+this.contatoTelefonico+
                "\nLogradouro:"+this.logradouro+
                "\nNúmero:"+this.numeroCasa+
                "\nBairro:"+this.bairro+
                "\nCidade:"+this.cidade;
    }
}
