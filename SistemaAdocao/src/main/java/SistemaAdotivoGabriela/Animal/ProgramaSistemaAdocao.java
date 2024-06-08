package SistemaAdotivoGabriela.Animal;

import Excessões.AdotanteJaCadastradoException;
import Excessões.AdotanteNaoCadastradoException;
import Excessões.AnimalJaCadastradoException;
import Excessões.AnimalNaoCadastradoException;
import PctAdotante.Adotante;
import PctAdotante.Contato;

import javax.swing.*;
import java.io.IOException;

public class ProgramaSistemaAdocao {
    public static void main(String[] args) {
        InterfaceSistemaAnimal sistemaAnimaisAdocao = new SistemaAnimal();

        try {
            sistemaAnimaisAdocao.recuperaDadosAnimal();
            JOptionPane.showMessageDialog(null, "<html><font color='green'>Dados de animais recuperado com sucesso!</font></html>");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "<html><font color='red'>Dados de animais NÃO puderam ser recuperados</font></html>");
            e.printStackTrace();
        }
        try {
            sistemaAnimaisAdocao.recuperaDadosAdotante();
            JOptionPane.showMessageDialog(null, "<html><font color='green'>Dados de adotantes recuperado com sucesso!</font</html>");
        }catch (IOException a){
            JOptionPane.showMessageDialog(null, "<html><font color='red'>Dados de adotantes NÃO puderam ser recuperados</font</html>");
            a.printStackTrace();
        }

        //menu

        boolean continuar = true;
        while (continuar) {
            String opcao = JOptionPane.showInputDialog("          ====> AmigosPet <====\n\n" +
                    "             Digite uma opção:" +
                    "\n                 1. Cadastro " +
                    "\n                 2. Adoção" +
                    "\n                 3. Pesquisa" +
                    "\n                 4. Apagar dados" +
                    "\n                 5. Lista de Relação"+
                    "\n                 6. Sair");
            switch (opcao) {
                case "1":
                    String tipoCadastro = JOptionPane.showInputDialog("1. Cadastrar Animal\n2. Cadastrar Adotante");
                    switch (tipoCadastro) {
                        case "1":
                            String animalNome = JOptionPane.showInputDialog("Digite o nome do animal: ");
                            String racaAnimal = JOptionPane.showInputDialog("Digite a espécie(cachorro ou gato) do animal: ");
                            String idadeAnimal = JOptionPane.showInputDialog("Digite a idade do animal: ");
                            String porteAnimal = JOptionPane.showInputDialog("Digite o porte do animal: ");

                            Animal sistemaCadastroAnimal = new Animal(animalNome, racaAnimal, idadeAnimal, porteAnimal);
                            try {
                                sistemaAnimaisAdocao.cadastrarAnimal(sistemaCadastroAnimal);
                                sistemaAnimaisAdocao.gravaDadosAnimal();
                                JOptionPane.showMessageDialog(null, "<html><font color='green'>Cadastro realizado com sucesso</font></html>");
                            } catch (AnimalJaCadastradoException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "<html><font color='red'>Erro ao gravar dados</font</html>");
                            }
                            break;

                        case "2":
                            String nomeAdotante = JOptionPane.showInputDialog("Digite o nome do adotante:");
                            String idadeAdotante = JOptionPane.showInputDialog("Digite a idade do adotante:");
                            String numeroTelefonico = JOptionPane.showInputDialog("Digite o número telefônico do adotante:");
                            String logradouroAdotante = JOptionPane.showInputDialog("Digite logradouro(rua/av.) do endereço:");
                            String numeroCasa = JOptionPane.showInputDialog("Digite o número de endereço do adotante:");
                            String bairroAdotante = JOptionPane.showInputDialog("Digite o bairro:");
                            String cidadeAdotante = JOptionPane.showInputDialog("Digite a cidade:");

                            Contato contatoAdotante = new Contato(numeroTelefonico, logradouroAdotante, numeroCasa, bairroAdotante, cidadeAdotante);

                            Adotante cadastroAdotante = new Adotante(nomeAdotante, idadeAdotante, contatoAdotante);
                            try {
                                sistemaAnimaisAdocao.cadastrarAdotante(cadastroAdotante);
                                sistemaAnimaisAdocao.gravaDadosAdotante();
                                JOptionPane.showMessageDialog(null,"<html><font color='green'>Cadastro realizado com sucesso</font></html>");
                            } catch (AdotanteJaCadastradoException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "Erro ao gravar dados");
                            }
                            break;
                    }
                    break;
                case "2":
                    String adocaoTipo = JOptionPane.showInputDialog("O adotante é cadastrado?" +
                            "\n 1.Sim" +
                            "\n 2.Não");
                    switch (adocaoTipo){
                        case "1":
                            try{
                                JOptionPane.showMessageDialog(null, sistemaAnimaisAdocao.relacaoAnimal());
                            }catch(IOException e){
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal que irá ser adotado:");
                            String idadeAnimal = JOptionPane.showInputDialog("Digite a idade do animal que irá ser adotado:");
                            String nomeAdotante2 = JOptionPane.showInputDialog("Digite o nome do adotante:");
                            String idadeAdotante1 =   JOptionPane.showInputDialog("Digite a idade do adotante:");
                            try{
                                sistemaAnimaisAdocao.sistemaAdocao(sistemaAnimaisAdocao.pesquisarAnimal(nomeAnimal,idadeAnimal),sistemaAnimaisAdocao.pesquisarAdotante(nomeAdotante2,idadeAdotante1));
                                JOptionPane.showMessageDialog(null, "<html><font color='green'>ADOÇÃO FEITA COM SUCESSO</font></html>");
                                sistemaAnimaisAdocao.gravaDadosDoacoes();
                                sistemaAnimaisAdocao.apagarAnimal(nomeAnimal,idadeAnimal);
                            }catch(AnimalNaoCadastradoException a){
                                JOptionPane.showMessageDialog(null, a.getMessage());
                            }catch (AdotanteNaoCadastradoException e){
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }catch (IOException a){
                                JOptionPane.showMessageDialog(null, a.getMessage());
                            }
                            break;
                        case "2":
                            JOptionPane.showMessageDialog(null, "Vamos fazer o cadastro");
                            String nomeAdotante = JOptionPane.showInputDialog("Digite o nome do adotante:");
                            String idadeAdotante = JOptionPane.showInputDialog("Digite a idade do adotante:");
                            String numeroTelefonico = JOptionPane.showInputDialog("Digite o número telefônico do adotante:");
                            String logradouroAdotante = JOptionPane.showInputDialog("Digite logradouro(rua/av.) do endereço:");
                            String numeroCasa = JOptionPane.showInputDialog("Digite o número de endereço do adotante:");
                            String bairroAdotante = JOptionPane.showInputDialog("Digite o bairro:");
                            String cidadeAdotante = JOptionPane.showInputDialog("Digite a cidade:");
                            Contato contatoAdotante = new Contato(numeroTelefonico, logradouroAdotante, numeroCasa, bairroAdotante, cidadeAdotante);

                            Adotante cadastroAdotante = new Adotante(nomeAdotante, idadeAdotante, contatoAdotante);
                            try {
                                sistemaAnimaisAdocao.cadastrarAdotante(cadastroAdotante);
                                sistemaAnimaisAdocao.gravaDadosAdotante();
                            } catch (AdotanteJaCadastradoException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (IOException e) {
                                String msg = "<html>font color='red'>ERRO AO GRAVAR DADOS</font></html>";
                                JOptionPane.showMessageDialog(null, msg);
                            }
                            break;
                    }
                    break;
                case"3":
                    String opcaoPesquisa= JOptionPane.showInputDialog("Pesquisa: \n\n1. Animal \n2. Adotante");


                    switch (opcaoPesquisa){

                        case"1":
                            String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal:");
                            String idadeAnimal = JOptionPane.showInputDialog("Digite a idade do animal:");
                            try {
                                JOptionPane.showMessageDialog(null, sistemaAnimaisAdocao.pesquisarAnimal(nomeAnimal, idadeAnimal));
                            }catch(AnimalNaoCadastradoException e){
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        case"2":
                            String nomeAdotante = JOptionPane.showInputDialog("Qual o nome do adotante:");
                            String idadeAdotante = JOptionPane.showInputDialog("Qual a idade do adotante:");
                            try{
                                JOptionPane.showMessageDialog(null,sistemaAnimaisAdocao.pesquisarAdotante(nomeAdotante,idadeAdotante));
                            }catch (AdotanteNaoCadastradoException a){
                                JOptionPane.showMessageDialog(null, a.getMessage());
                            }
                            break;
                    }
                    break;
                case "4":
                    String tipoApagar = JOptionPane.showInputDialog("Qual tipo de dado deseja apagar: \n\n1.Animal\n2.Adotante");
                    switch (tipoApagar) {
                        case "1":
                            String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal:");
                            String idadeAnimal = JOptionPane.showInputDialog("Digite a idade do animal:");
                            try {
                                sistemaAnimaisAdocao.apagarAnimal(nomeAnimal, idadeAnimal);
                                JOptionPane.showMessageDialog(null,"<html><font color='green'>DADO APAGADO COM SUCESSO</font></html>");
                            } catch (AnimalNaoCadastradoException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        case "2":
                            String nomeAdotante = JOptionPane.showInputDialog("Digite o nome do adotante:");
                            String idadeAdotante = JOptionPane.showInputDialog("Digite a idade do adotante:");
                            try {
                                sistemaAnimaisAdocao.apagarAdotante(nomeAdotante, idadeAdotante);
                                JOptionPane.showMessageDialog(null, "<html><font color='green'>DADO APAGADO COM SUCESSO</font></html>");
                            } catch (AdotanteNaoCadastradoException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                    }
                    break;

                case "5":
                    String tipoDeRelacao = JOptionPane.showInputDialog("Qual lista deseja ver: \n1.Animal\n2.Adotante\n3.Adoções");
                    switch (tipoDeRelacao){
                        case "1":
                            try{
                                JOptionPane.showMessageDialog(null, sistemaAnimaisAdocao.relacaoAnimal());
                            }catch (IOException e){
                                JOptionPane.showMessageDialog(null, "<html><font color='red'>NENHUM ANIMAL CADASTRADO</font></html>");
                            }
                            break;
                        case "2":
                            try{
                                JOptionPane.showMessageDialog(null, sistemaAnimaisAdocao.relacaoAdotantes());
                            }catch (IOException a){
                                JOptionPane.showMessageDialog(null, "<html><font color='red'>NENHUM ADOTANTE CADASTRADO</font></html>");
                            }
                            break;
                        case"3":
                            try{
                                JOptionPane.showMessageDialog(null, sistemaAnimaisAdocao.relacaoAdocoes());
                            }catch (IOException e){
                                JOptionPane.showMessageDialog(null, "NENHUMA ADOÇÃO FOI REALIZADO");
                            }
                            break;
                    }
                    break;
                    case "6":
                    continuar = false;
                    break;
            }
        }
    }
}


