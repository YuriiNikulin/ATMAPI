package app.service;

import app.dto.AuthenticationBankCardDTO;
import app.dto.CreateBankCardDTO;
import app.dto.TransferDTO;
import app.model.BankCard;
import app.model.User;
import app.reposotiry.BankCardRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BankCardServiceImpl implements BankCardService {

    @Autowired
    private BankCardRepository bankCardRepository;

    public String createBankCard(CreateBankCardDTO dto) {
        Gson gson = new Gson();

        BankCard bankCard = new BankCard();
        User user = new User();

        user.setName(dto.getUser_name());
        user.setBirthday(dto.getUser_birthday());
        user.setSex(dto.getSex());
        user.setAddress(dto.getAddress());

        bankCard.setUser(user);
        bankCard.setCardNumber(dto.getCard_number());

        return gson.toJson(bankCardRepository.getBankCardByCardNumber(dto.getCard_number()));
    }

    public boolean authenticationBankCard(AuthenticationBankCardDTO dto) {

        if (cardExits(dto.getCardNumber())) {
            return chekPass(dto.getCardNumber(), dto.getUserPass());
        } else return false;

    }

    //todo
    public boolean transferFromCardToCard(TransferDTO dto) {
        BankCard senderCard = bankCardRepository.getBankCardByCardNumber(dto.getSenderCardNumber());
        BankCard recipientCard = bankCardRepository.getBankCardByCardNumber(dto.getRecipientCardNumber());

        if (cardExits(dto.getRecipientCardNumber()) && cardExits(dto.getSenderCardNumber())) {
            if (authenticationBankCard(new AuthenticationBankCardDTO(dto.getSenderCardNumber(), dto.getSenderPass()))) {
                if (senderCard.getScore() >= dto.getAmountForTranster()) {
                    senderCard.setScore(senderCard.getScore() - dto.getAmountForTranster());
                    recipientCard.setScore(recipientCard.getScore() + dto.getAmountForTranster());
                }//недостатньо коштів для переведення
            }//не пройшла аутинтифікація
        }//не існує одна з карток

        return false;
    }

    public List<String> allCards() {

        Gson gson = new Gson();
        List<BankCard> bankCards = bankCardRepository.getAllBankCardByOrderByCardNumberAsc();
        List<String> ress = null;

        for (BankCard bankCard : bankCards) {
            ress.add(gson.toJson(bankCard));
        }

        return ress;
    }

    private boolean cardExits(int cardNumber) {
        BankCard card = bankCardRepository.getBankCardByCardNumber(cardNumber);

        if (card != null) {
            return true;
        } else return false;
    }

    private boolean chekPass(int cardNumber, String pass) {
        BankCard card = bankCardRepository.getBankCardByCardNumber(cardNumber);

        if (pass.equals(card.getPass())) {
            return true;
        } else return false;
    }
}
