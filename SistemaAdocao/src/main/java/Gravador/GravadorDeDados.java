package Gravador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados{
    public static final String ARQUIVO_ANIMAIS = "animais.txt";
    public static final String ARQUIVO_ADOTANTES = "adotantes.txt";
    public static final String ARQUIVO_ADOCOES = "adoções";

    public List<String> recuperaDadosDeAdotantes() throws IOException{
        List<String> dadosAdotantes = recuperaTextoDeArquivo(ARQUIVO_ADOTANTES);
        return dadosAdotantes;
    }

    public List<String> recuperaDadosDeAnimais()throws IOException{
        List<String> dadosAnimais = recuperaTextoDeArquivo(ARQUIVO_ANIMAIS);
        return dadosAnimais;
    }
    public List<String> recuperaDadosAdocoes() throws IOException{
        List<String> dadosAdocoes = recuperaTextoDeArquivo(ARQUIVO_ADOCOES);
        return dadosAdocoes;
    }
    public void gravaDadosDeAnimais(List<String> dadosAnimais) throws IOException{
        this.gravaTextoEmArquivo(dadosAnimais, ARQUIVO_ANIMAIS);
    }
    public void gravaDadosDeAdotantes(List<String> dadosAdotantes) throws IOException{
        this.gravaTextoEmArquivo(dadosAdotantes, ARQUIVO_ADOTANTES);
    }
    public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException{
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();

        try{
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;
            do{
                texto = leitor.readLine();;
                if (texto!=null){
                    textoLido.add(texto);
                }
            }while (texto!=null);
        }finally {
            if (leitor!=null){
                leitor.close();
            }
        }
        return textoLido;
    }
    public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo) throws IOException{
        BufferedWriter gravador = null;
        try{
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for (String s: texto){
                gravador.write(s+"\n");
            }
        }finally {
            if (gravador!=null){
                gravador.close();
            }
        }
    }

}
