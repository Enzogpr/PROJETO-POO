package projetodois;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner escolha = new Scanner(System.in);
       int opcao;
    
       do{
       System.out.println("----------CONVERSOR----------");
       System.out.println("[1] - DECIMAL PARA ROMANO");
       System.out.println("[2] - CONVERSOR DE MOEDAS");
       System.out.println("[3] - SAIR");
       opcao = escolha.nextInt();

       switch (opcao) {
           case 1:
               ConversorRomano.ToRoman();
               break;
           case 2:
           ConversorMoedas.convert();
           default:
               break;
             }
            }while(opcao != 3);
    }
}

