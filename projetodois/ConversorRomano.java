package projetodois;

import java.util.Scanner;

public class ConversorRomano {
    public static void ToRoman() {
        Scanner conversor = new Scanner(System.in);
        String resultado = " ";
        int numero;
        int vetorNumeros[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1, };
        String vetorRomano[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        do{
        System.out.println("Digite um numero inteiro entre 1 e 3999 para converte para romano: ");
        numero = conversor.nextInt();
        if(numero > 3999 || numero < 1){
            System.out.println("Insira um numero valido para o programa\n");
        }
        } while( numero > 3999 || numero < 1);

        for (int i = 0; i < vetorNumeros.length; i++) {
           while( numero >= vetorNumeros[i]){
            resultado += vetorRomano[i];
            numero -= vetorNumeros[i];
           }
        }

           System.out.println(resultado);
        }

        

    }

