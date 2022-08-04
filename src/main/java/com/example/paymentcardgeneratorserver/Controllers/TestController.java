package com.example.paymentcardgeneratorserver.Controllers;
import com.example.paymentcardgeneratorserver.Enums.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.paymentcardgeneratorserver.PaymentCardImpl;
import com.example.paymentcardgeneratorserver.Types.Card;
import java.util.List;
@RestController
public class TestController {

    @Autowired
    PaymentCardImpl p;
    @RequestMapping
    public String base() throws Exception {
        return "Welcome to card generator";
    }

    @RequestMapping(value = "/card/{card}", method = RequestMethod.GET)
    public Card generateCard(@PathVariable("card") String card) throws Exception {
        return p.generateCard(CardType.valueOf(card));
    }

    @RequestMapping(value = "/cards/{card}", method = RequestMethod.GET)
    public List<Card> generateCards(@PathVariable("card") String card, @RequestParam("cnt") int cnt) throws Exception {
        return p.generateListByCardType(cnt, CardType.valueOf(card));
    }
}
