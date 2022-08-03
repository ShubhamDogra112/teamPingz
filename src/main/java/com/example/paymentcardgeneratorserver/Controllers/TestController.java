package com.example.paymentcardgeneratorserver.Controllers;
import com.example.paymentcardgeneratorserver.Enums.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.paymentcardgeneratorserver.PaymentCardGeneratorImplementation;

@RestController
public class TestController {

    @Autowired
    PaymentCardGeneratorImplementation p;
    @RequestMapping
    public String helloWorld() {
        return p.generateByCardType(CardType.AMERICAN_EXPRESS);
    }
}
