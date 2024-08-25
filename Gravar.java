package projetoum;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Gravar {
    public static File arquivo = new File("registros.csv");

    public static void LerColunas(){
        if (arquivo.exists()) {
            try (BufferedReader ler = new BufferedReader(new FileReader(arquivo))){
                String linha = ler.readLine();
                if (linha != null && !linha.trim().isEmpty()) {
                    String[] colunasExistentes = linha.split(";");
                    for (String coluna : colunasExistentes) {
                        Usuario.colunas.add(coluna);
                    }
                }
            }catch (IOException excecao){
                excecao.printStackTrace();
                System.out.println("Erro ao ler o arquivo: " + excecao.getMessage());
            }
            
        }
    }


    public static void GravarResposta(){
    
        try (FileWriter append = new FileWriter(arquivo, true)) {
            for (String resposta : Usuario.respostas) {
                append.write(resposta + ";");
            }
            append.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar as respostas no arquivo: " + e.getMessage());
        }
    }
    

    public static void GravarColunas(){
        try (FileWriter writer = new FileWriter(arquivo, false)) {
            for (String coluna : Usuario.colunas) {
                writer.write(coluna + ";");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar as colunas no arquivo: " + e.getMessage());
        
    }

}
}
