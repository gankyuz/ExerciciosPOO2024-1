package SistemaAdotivoGabriela.Animal;

import Excessões.AdotanteJaCadastradoException;
import Excessões.AdotanteNaoCadastradoException;
import Excessões.AnimalJaCadastradoException;
import Excessões.AnimalNaoCadastradoException;
import PctAdotante.Adotante;

import java.io.IOException;
import java.util.List;

public interface InterfaceSistemaAnimal {
    public void cadastrarAnimal(Animal animal) throws AnimalJaCadastradoException;
    public void cadastrarAdotante(Adotante adotante) throws AdotanteJaCadastradoException;
    public Animal pesquisarAnimal(String nomeAnimal, String idade) throws AnimalNaoCadastradoException;
    public Adotante pesquisarAdotante(String nomeAdotante, String idade) throws AdotanteNaoCadastradoException;
    public void sistemaAdocao(Animal animal, Adotante adotante);
    public void apagarAnimal(String nome, String idade) throws AnimalNaoCadastradoException;
    public void apagarAdotante(String nome, String idade) throws AdotanteNaoCadastradoException;
    public void gravaDadosAnimal() throws IOException;
    public void gravaDadosAdotante() throws IOException;
    public void recuperaDadosAnimal() throws IOException;
    public void recuperaDadosAdotante() throws IOException;
    public List<Animal> relacaoAnimal() throws IOException;
    public List<Adotante> relacaoAdotantes() throws IOException;
    public List<Adocao> relacaoAdocoes() throws IOException;
    public void gravaDadosDoacoes() throws IOException;
    public void recuperaDadosAdocoes() throws IOException;
}
