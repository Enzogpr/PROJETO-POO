package projetoum;

import java.util.Scanner;

public class Controle {

    public static void main(String[] args) {
        Scanner opcao = new Scanner(System.in);

        int escolha; 
        Gravar.LerColunas();

        do{
            
        System.out.println("--------------MENU--------------");
        System.out.println("[1] - Registrar Colunas");
        System.out.println("[2] - Registrar resposta");
        System.out.println("[3] - Sair");
        escolha = opcao.nextInt();
        
        switch (escolha) {
            case 1:
                 Usuario.Colunas();
                 Gravar.GravarColunas();
                break;
            case 2:
                Usuario.informacoes();
                break;
            default:
                break;
        }
    }while(escolha != 3);
    }
    
}
