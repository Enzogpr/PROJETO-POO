package projetoum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Usuario {
  
    public static List<String> colunas = new ArrayList<>();
    public static String[] respostas;

    public static void Colunas(){
        
            Scanner registro = new Scanner(System.in);
            String titulo;
            char escolha;

            if(!colunas.isEmpty()){
                System.out.println("Colunas existentes: ");
                for (String coluna : colunas){
                    System.out.println("- " + coluna);
                }
            }

            if (colunas.isEmpty()) {
                for(int i = 1; i < 4; i++){

                    System.out.println("Digite o titulo da coluna " + i + ":");
                    titulo = registro.nextLine();
                    colunas.add(titulo);
            }
       
        }
        do{
            System.out.println("Deseja adicionar mais colunas?[S/N] ");
            escolha = registro.next().charAt(0);
            registro.nextLine();

          if (escolha == 'S' || escolha == 's') {
                System.out.println("Digite o título da próxima coluna: ");
                titulo = registro.nextLine();
                colunas.add(titulo);
            }
    }while(escolha == 'S' || escolha == 's');
}

    public static void informacoes(){
        Scanner responder = new Scanner(System.in);
        respostas = new String[colunas.size()];

        for(int i = 0; i < colunas.size(); i++){
            System.out.println("Digite a informação da coluna " + colunas.get(i) + ":");
            respostas[i] = responder.nextLine();
        }
        Gravar.GravarResposta();
    }
}


