package projetodois;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ConversorMoedas {
    public static String moedas[] = {"USD", "EUR", "JPY", "GBP", "BRL"};
    public static double taxas[] = {1.0, 0.85, 110.0, 0.75, 5.4};
    public static String desejaConverter;
    public static String moedafinal;

    public static int findCurrencyIndex(String currency){
        for(int i = 0; i < moedas.length; i++){
            if(moedas[i].equalsIgnoreCase(currency)){
                return i;
            }
        }
            return -1;
    }   
    


    public static String formatarMoeda(double valor, String moeda){
        Locale locale;

        switch (moeda.toUpperCase()) {
            case "USD":
                locale = Locale.US;
                break;
            case "EUR":
                locale = Locale.FRANCE;
                break;
            case "JPY":
                locale = Locale.JAPAN;
                break;
            case "GBP":
                locale = Locale.UK;
                break;
            case "BRL":
                locale = new Locale("pt", "BR");
            default:
            locale = Locale.getDefault();
                break;
        }
        NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
        return formatador.format(valor);
    }
    public static void convert(){
        Scanner moeada = new Scanner(System.in);
        double amount;
        double convertido;
         String fromCurrency;
         String toCurrency;

         
            do{
            System.out.println("Digite a moeda inicial: \"USD\", \"EUR\", \"JPY\", \"GBP\", \"BRL\"");
            fromCurrency = moeada.next();
            if (findCurrencyIndex(fromCurrency) == -1) {
                System.out.println("Moeda invalida, tente novamente");
            }
            }while (findCurrencyIndex(fromCurrency) == -1);


            do{
            System.out.println("Digite a moeda para qual deseja converter: \"USD\", \"EUR\", \"JPY\", \"GBP\", \"BRL\"");
            toCurrency = moeada.next();
            if (findCurrencyIndex(toCurrency) == -1) {
                System.out.println("Moeda invalida, tente novamente");
            }
        }while (findCurrencyIndex(toCurrency) == -1);

         System.out.println("Digite o valor: ");
         amount = moeada.nextDouble();
        


            int moedaNativa  = findCurrencyIndex(fromCurrency);

            int moedaConversao = findCurrencyIndex(toCurrency);

            

            double amountToUSD = amount / taxas[moedaNativa];

            convertido = amountToUSD * taxas[moedaConversao];

            String valorFormatado = formatarMoeda(convertido, toCurrency);

            System.out.println("Valor convertido: " + valorFormatado);
               
            System.out.println(); 
    }


}


    
