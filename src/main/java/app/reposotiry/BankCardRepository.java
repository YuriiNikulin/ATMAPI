package app.reposotiry;

import app.model.BankCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankCardRepository extends CrudRepository<BankCard, Integer> {

    List<BankCard> getAllBankCardByOrderByCardNumberAsc();

    BankCard getBankCardByCardNumber(int cardNumber);
}
