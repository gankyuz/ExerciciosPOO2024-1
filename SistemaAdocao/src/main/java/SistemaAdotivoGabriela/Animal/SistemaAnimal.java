package SistemaAdotivoGabriela.Animal;

import Excessões.AdotanteJaCadastradoException;
import Excessões.AdotanteNaoCadastradoException;
import Excessões.AnimalJaCadastradoException;
import Excessões.AnimalNaoCadastradoException;
import Gravador.GravadorDeDados;
import PctAdotante.Adotante;
import PctAdotante.Contato;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class SistemaAnimal implements InterfaceSistemaAnimal{

    private List<Animal> animais;
    private List<Adotante> adotante;
    private List<Adocao> adocoes;
    GravadorDeDados gravadorDeDados;

    public SistemaAnimal(){
        this.animais = new ArrayList<>();
        this.adotante = new ArrayList<>();
        this.adocoes = new ArrayList<>();
        this.gravadorDeDados = new GravadorDeDados();
    }

    private boolean existeAnimalNoSistema(String nome, String idade){
        for (Animal a: this.animais){
            if (a.getNomeAnimal().equals(nome) && a.getIdadeAnimal().equals(idade)){
                return true;
            }
        }
        return false;
    }
    private boolean existeAdotanteNoSistema(String nome, String idade){
        for (Adotante a: this.adotante){
            if (a.getNomeAdotante().equals(nome) && a.getIdade().equals(idade)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void cadastrarAnimal(Animal animal) throws AnimalJaCadastradoException {
        if(existeAnimalNoSistema(animal.getNomeAnimal(), animal.getIdadeAnimal())){
            throw new AnimalJaCadastradoException("<html><font color='red'>=====> OPS! Animal já cadastrado <=====</font</html>");
        }else{
            this.animais.add(animal);
        }
    }

    @Override
    public void cadastrarAdotante(Adotante adotante) throws AdotanteJaCadastradoException {
        if (existeAdotanteNoSistema(adotante.getNomeAdotante(), adotante.getIdade())){
            throw new AdotanteJaCadastradoException("<html><font color='red'>=====> OPS! Adotante já cadastrado <=====</font></html>");
        }else{
            this.adotante.add(adotante);
        }
    }

    @Override
    public Animal pesquisarAnimal(String nomeAnimal, String idade) throws AnimalNaoCadastradoException {
        for(Animal a: animais){
            if (a.getNomeAnimal().equals(nomeAnimal) && a.getIdadeAnimal().equals(idade)){
                return a;
            }
        }
        throw new AnimalNaoCadastradoException("<html><font color='red'>=====> OPS! Animal não cadastrado <=====</font></html>");
    }

    @Override
    public Adotante pesquisarAdotante(String nomeAdotante, String idade) throws AdotanteNaoCadastradoException {
        for (Adotante a: adotante){
            if (a.getNomeAdotante().equals(nomeAdotante) && a.getIdade().equals(idade)){
                return a;
            }
        }
        throw new AdotanteNaoCadastradoException("<html><font color='red'>=====> OPS! Adotante não cadastrado <=====</font></html>");
    }

    @Override
    public void sistemaAdocao(Animal animal, Adotante adotante) {
        Adocao adocaoAnimal = new Adocao(animal, adotante);
        this.adocoes.add(adocaoAnimal);
    }


    @Override
    public void apagarAnimal(String nome, String idade) throws AnimalNaoCadastradoException {
        boolean animalRemovido = false;
        for (Animal c: animais){
            if (c.getNomeAnimal().equals(nome) && c.getIdadeAnimal().equals(idade)){
                animais.remove(c);
                animalRemovido = true;
                try{
                    gravaDadosAnimal();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        if (!animalRemovido){
            throw new AnimalNaoCadastradoException("<html><font color='red'>=====> OPS! Animal não cadastrado <=====</font></html>");
        }
    }

    @Override
    public void apagarAdotante(String nome, String idade) throws AdotanteNaoCadastradoException {
        boolean adotanteRemovido = false;
        for (Adotante b: adotante){
            if (b.getNomeAdotante().equalsIgnoreCase(nome) && b.getIdade().equalsIgnoreCase(idade)){
                adotante.remove(b);
                adotanteRemovido = true;
            }try{
                gravaDadosAdotante();
            }catch (IOException c){
                throw new RuntimeException(c);
            }
            break;
        }
        if (!adotanteRemovido){
            throw new AdotanteNaoCadastradoException("<html><font color='red'>=====> OPS! Adotante não cadastrado <=====</font></html>");
        }
    }

    @Override
    public void gravaDadosAnimal() throws IOException {
        List<String> dadosAnimais = new ArrayList<>();
        for (Animal a : this.animais) {
            String dado = a.getNomeAnimal()+"---"+a.getIdadeAnimal()+"---"+a.getRacaAnimal()+"---"+a.getPorteAnimal();
            System.out.println(dado);
            dadosAnimais.add(dado);
        }
        this.gravadorDeDados.gravaTextoEmArquivo(dadosAnimais, "animais.txt");
    }

    @Override
    public void gravaDadosAdotante() throws IOException{
        List<String> dadosAdotante = new ArrayList<>();
        for (Adotante a: this.adotante){
            Contato t = a.getContato();
            String contato = t.getContatoTelefonico()+"---"+t.getLogradouro()+"---"+t.getNumeroCasa()+"---"+t.getBairro()+"---"+t.getCidade();
            contato = contato.replace("\n", "").replace("\r", "");
            String dado = a.getNomeAdotante()+"---"+a.getIdade()+"---"+contato;
            System.out.println(dado);
            dadosAdotante.add(dado);
        }
        this.gravadorDeDados.gravaTextoEmArquivo(dadosAdotante, "adotantes.txt");
    }

    @Override
    public void gravaDadosDoacoes() throws IOException {
        List<String> dadosDoacoes = new ArrayList<>();
        for (Adocao a: this.adocoes){
            String dado = a.getAnimal().getNomeAnimal()+"---"+a.getAdotante().getNomeAdotante();
            System.out.println(dado);
            dadosDoacoes.add(dado);
        }
        this.gravadorDeDados.gravaTextoEmArquivo(dadosDoacoes, "adoções.txt");
    }

    @Override
    public void recuperaDadosAdocoes() throws IOException {
        List<String> dadoAdocoes = gravadorDeDados.recuperaDadosAdocoes();
        if (dadoAdocoes.isEmpty()) throw new IOException();
        for (String c: dadoAdocoes){
            String [] dados = c.split("---");
            Contato contatoRecuperado = new Contato(dados[3],dados[4],dados[5],dados[6],dados[7]);
            Adotante adotanteRecuperado= new Adotante(dados[1],dados[2],contatoRecuperado);
            Animal animalRecuperado = new Animal(dados[0],null,null,null);
            Adocao dadosRecuperados = new Adocao(animalRecuperado, adotanteRecuperado);
            this.adocoes.add(dadosRecuperados);
        }
    }

    @Override
    public void recuperaDadosAnimal() throws IOException {
        List<String> dadoAnimal = gravadorDeDados.recuperaDadosDeAnimais();
        if (dadoAnimal.isEmpty()) throw new IOException();
        for (String c : dadoAnimal) {
            String[] dados = c.split("---");
            Animal a = new Animal(dados[0], dados[1], dados[2], dados[3]);
            this.animais.add(a);
        }

    }
    @Override
    public void recuperaDadosAdotante() throws IOException {
       List<String> dadoAdotante = gravadorDeDados.recuperaDadosDeAdotantes();
       if (dadoAdotante.isEmpty()) throw new IOException();
       for (String c: dadoAdotante){
           String [] dados = c.split("---");
           Contato contatoRecuperado = new Contato(dados[2],dados[3],dados[4],dados[5],dados[6]);
           Adotante adotanteRecuperado = new Adotante(dados[0],dados[1],contatoRecuperado);
           this.adotante.add(adotanteRecuperado);
       }
    }

    @Override
    public List<Animal> relacaoAnimal() throws IOException{
        List<Animal> relacaoAnimal = new ArrayList<>();
        for (Animal a: animais){
            relacaoAnimal.addAll(animais);
        }
        if (relacaoAnimal.isEmpty()) throw new IOException();
        return relacaoAnimal;
    }

    @Override
    public List<Adotante> relacaoAdotantes() throws IOException{
        List<Adotante> relacaoAdotante = new ArrayList<>();
        for (Adotante a: adotante){
            relacaoAdotante.addAll(adotante);
        }
        if (relacaoAdotante.isEmpty()) throw new IOException();
        return relacaoAdotante;
    }
    @Override
    public List<Adocao> relacaoAdocoes() throws IOException{
        List<Adocao> relacaoAdocoes = new ArrayList<>();
        for (Adocao a: adocoes){
            relacaoAdocoes.addAll(adocoes);
        }
        if (relacaoAdocoes.isEmpty()) throw new IOException();
        return relacaoAdocoes;
    }
}
