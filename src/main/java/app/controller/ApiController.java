package app.controller;

import app.dto.CreateBankCardDTO;
import app.model.BankCard;
import app.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping(value = "/ATMAPI")
public class ApiController {

    @Autowired
    private BankCardService bankCardService;

    @RequestMapping(value = "/newCard", method = RequestMethod.GET)
    public String newCard(Map model){
        CreateBankCardDTO createBankCardDTO = new CreateBankCardDTO();
        model.put("newCard", createBankCardDTO);

        return null;
    }

    @RequestMapping(value = "/createCard", method = RequestMethod.POST)
    public String createCard(@RequestBody CreateBankCardDTO createBankCardDTO,
                           HttpServletRequest request, HttpServletResponse response){
        return bankCardService.createBankCard(createBankCardDTO);
    }
}
