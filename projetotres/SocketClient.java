package projetotres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) {

        System.out.println("Escreva o seu nome: ");
        String usuario = new Scanner(System.in).nextLine();
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 8089);
             BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true); 
        ) {

            escritor.println(usuario);

       
            Thread receptor = new Thread(() -> {
                try {
                    String mensagemRecebida;
                    while ((mensagemRecebida = leitor.readLine()) != null) {
                        System.out.println(mensagemRecebida);
                    }
                } catch (IOException e) {
                    System.out.println("Socket finalizado");
                }
            });

            receptor.start();

            while (true) {
                Thread.sleep(300); 

                System.out.println("Escreva sua mensagem: ");
                String mensagem = scanner.nextLine();

                if (mensagem.equalsIgnoreCase("sair")) break; 
                escritor.println(mensagem);  
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
