package projetotres;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashSet;


public class Main {

        private static final int Porta = 8089;

        private static Set<PrintWriter> escritores = new HashSet<>();
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(Porta) ) {
            System.out.println("Servidor rodando na porta " + Porta + "...");
            while (true) {
                new ClienteHandler(server.accept(), escritores
                
                ).start();
            }

            
        } catch (IOException ioException) {
            ioException.printStackTrace();
            
        }
    }
    
}
