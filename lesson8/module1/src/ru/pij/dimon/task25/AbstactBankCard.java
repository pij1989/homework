package ru.pij.dimon.task25;

public abstract class AbstactBankCard implements BankCard {
    private String cardHolderName;
    private String paymentSystem;
    private String cardNumber;
    private String codeCVV;
    private String cardExpiryDate;
    private String currency;

    protected AbstactBankCard(String cardHolderName, String paymentSystem, String cardNumber, String codeCVV, String cardExpiryDate, String currency) {
        this.cardHolderName = cardHolderName;
        this.paymentSystem = paymentSystem;
        this.cardNumber = cardNumber;
        this.codeCVV = codeCVV;
        this.cardExpiryDate = cardExpiryDate;
        this.currency = currency;
    }


    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getPaymentSystem() {
        return paymentSystem;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCodeCVV() {
        return codeCVV;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public String getCurrency() {
        return currency;
    }


    @Override
    public String toString() {
        return "cardHolderName='" + cardHolderName + '\'' +
                ", paymentSystem='" + paymentSystem + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", codeCVV='" + codeCVV + '\'' +
                ", cardExpiryDate='" + cardExpiryDate + '\'' +
                ", currency='" + currency + '\'';
    }
}
