package app.service;

import app.dto.AuthenticationBankCardDTO;
import app.dto.CreateBankCardDTO;
import app.dto.TransferDTO;

import java.util.List;

public interface BankCardService {

    String createBankCard (CreateBankCardDTO dto);

    boolean authenticationBankCard(AuthenticationBankCardDTO dto);

    boolean transferFromCardToCard(TransferDTO dto);

    List<String> allCards();
}
