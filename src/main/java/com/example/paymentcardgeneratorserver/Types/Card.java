package com.example.paymentcardgeneratorserver.Types;

public class Card {
    String cardNo;
    String cvv;
    String name;
    String address;

    public Card(String cardNo, String name, String address, String cvv){
        this.cardNo = cardNo;
        this.name = name;
        this.address = address;
        this.cvv = cvv;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNo='" + cardNo + '\'' +
                ", cvv='" + cvv + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
