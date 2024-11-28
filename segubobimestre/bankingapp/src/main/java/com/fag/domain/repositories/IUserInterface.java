package com.fag.domain.repositories;

import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;

public interface IUserInterface {
    
 Integer showInitialScreenMenu();

 LoginDTO getloginData();

UserAccountDTO getRegisterUser();

Integer showHomeMenu(String userName);

void showErrorMsg(String msg);

void showExitMessage();

String getBarcode();

BankslipDTO getPaymentBankslipInfo();

void showBankslipData(String data);

Double getPixData();

void showPixData(String data);




}
