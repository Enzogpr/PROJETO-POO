package com.fag;

import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.infra.celcoin.CelcoinBassRepository;
//import com.fag.domain.repositories.IUserInterface;
import com.fag.infra.console.ConsoleUI;
import com.fag.infra.pg.PgSupabase;
import com.fag.infra.pg.PostgresConnection;
//import com.fag.infra.postgres.PostgresConnection;
import com.fag.infra.swing.SwingUserInterface;
import com.fag.infra.testdb.UserTestDBRepository;
//import com.fag.infra.testdb.UserTestDBRepository;
//import com.fag.service.Application;
import com.fag.service.BankingService;

public class Main {

    public static void main(String[] args) throws Exception {

        ConsoleUI consoleUI = new ConsoleUI();
        SwingUserInterface swing = new SwingUserInterface();
        UserTestDBRepository userTestDb = new UserTestDBRepository();
        PgSupabase pg = new PgSupabase();
        CelcoinBassRepository celcoin = new CelcoinBassRepository();
        BankingService bankingService = new BankingService(swing, pg, celcoin);

        PostgresConnection.getInstance();

    while (true) {
        Integer opcao = bankingService.showMenu();
        System.out.println("Opção escolhida " + opcao);
    
    switch (opcao) {
        case 1:
            LoginDTO loginDTO = bankingService.getLoginDTO();
            UserAccountDTO user = bankingService.findUser(loginDTO);

            if (user != null) {
                bankingService.login(user);
            }
            break;
        case 2:
       UserAccountDTO accountDTO = bankingService.getRegisterUserDTO();

bankingService.createUserAccountDTO(accountDTO);
        bankingService.login(accountDTO);
            break;
        case 3:
        bankingService.showExitMessage();
           return;
        default:
            break;
    }
    }

    }
   
}
