package com.fag.infra.swing;

import javax.swing.JOptionPane;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;

import com.fag.domain.repositories.IUserInterface;

public class SwingUserInterface  implements IUserInterface {

    @Override
    public Integer showInitialScreenMenu(){
        String menu = "---------BANCO FAG ------------"
            .concat("\n[1] Realizar login")
        .concat("\n[2] Criar conta")
        .concat("\n[3] Sair");

        String escolha = JOptionPane.showInputDialog(null, menu, "Menu incial do banco fag", JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(escolha);
    }

  @Override
    public Integer showHomeMenu(String userName) {
       String menu ="Olá " + userName + "! O que deseja fazer hoje?\n"
        .concat("[1] Consultar boleto\n")
        .concat("[2] Realizar pagamento boleto\n")
        .concat("[3] Gerar QR Code PIX\n")
        .concat("[4] SAIR");

        String escolha = JOptionPane.showInputDialog(null, menu, "Menu de funções do banco fag", JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(escolha);

        

    }

    @Override
    public LoginDTO getloginData() {
        LoginDTO data = new LoginDTO();

        String document = JOptionPane.showInputDialog( null, "Informe seu documento:", "Informe os dados", 0);
        
        String password = JOptionPane.showInputDialog(null, "Informe sua senha:", "Informe os dados", 0);
    
        data.setDocument(document);
        data.setPassword(password);
    
        return data;
    }

    @Override
    public UserAccountDTO getRegisterUser() {
        
        UserAccountDTO accountDTO = new UserAccountDTO();

        String document = JOptionPane.showInputDialog(null, "Informe seu documento:", "Informe os dados", 0);

        String name = JOptionPane.showInputDialog(null, "Informe seu nome:", "Informe os dados", 0);
       
        String email =  JOptionPane.showInputDialog(null, "Informe seu email:", "Informe os dados", 0);
       
        String password =   JOptionPane.showInputDialog(null, "Informe sua senha:", "Informe os dados", 0);
   

       accountDTO.setDocument(document);
       accountDTO.setPassword(password);
       accountDTO.setName(name);
       accountDTO.setEmail(email);

       return accountDTO;
    }

    @Override
    public void showErrorMsg(String msg) {
      JOptionPane.showMessageDialog(null, "Erro: " + msg,"ERRO", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showExitMessage() {
        JOptionPane.showMessageDialog(null, "Obrigado por utilizar nossa aplicação","TCHAU", JOptionPane.DEFAULT_OPTION);
    }

    @Override
    public String getBarcode() {
        String barcode = JOptionPane.showInputDialog(
            null,
            "Insira o código de barras a ser consultado",
            "Código de barras",
            JOptionPane.INFORMATION_MESSAGE);

    return barcode;
}
    

    @Override
    public BankslipDTO getPaymentBankslipInfo() {
        BankslipDTO bankslipDTO = new BankslipDTO();

        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser pago",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);
        String transactionId = JOptionPane.showInputDialog(
                null,
                "Insira o identificador de pagamento",
                "Identificador",
                JOptionPane.INFORMATION_MESSAGE);

        String valor = JOptionPane.showInputDialog(
                    null,
                    "Insira o valor do boleto",
                    "valor",
                    JOptionPane.INFORMATION_MESSAGE);
         double valorPago = Double.parseDouble(valor);
        bankslipDTO.setBarcode(barcode);
        bankslipDTO.setTransactionId(transactionId);
        bankslipDTO.setValorPago(valorPago);

        return bankslipDTO;
    }

    @Override
    public void showBankslipData(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados boleto",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Double getPixData() {
        String amount = JOptionPane.showInputDialog(
            null,
            "Insira o valor do PIX",
            "Valor transação",
            JOptionPane.INFORMATION_MESSAGE);

    return Double.parseDouble(amount);
    }

    @Override
    public void showPixData(String data) {
         JOptionPane.showMessageDialog(
            null,
            data,
            "Dados PIX",
            JOptionPane.INFORMATION_MESSAGE);
    }
    

    
}
