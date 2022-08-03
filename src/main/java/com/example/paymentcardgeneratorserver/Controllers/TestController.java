package com.example.paymentcardgeneratorserver.Controllers;
import com.example.paymentcardgeneratorserver.Enums.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.paymentcardgeneratorserver.PaymentCardImpl;

@RestController
public class TestController {

    @Autowired
    PaymentCardImpl p;
    @RequestMapping
    public String helloWorld() throws Exception {
        return p.generateCard(CardType.VISA);
    }
}
