package ru.pij.dimon.task25;

public class PremiumDebitCard extends DebitCard {
    public PremiumDebitCard(String cardHolderName, String paymentSystem, String cardNumber, String codeCVV, String cardExpiryDate, String currency) {
        super(cardHolderName, paymentSystem, cardNumber, codeCVV, cardExpiryDate, currency);
    }

    public void purchaseInsurance(){
        System.out.println("Your purchase is insured");
    }

    public void increaseWarranty (int month){
        System.out.println("Warranty on your purchase is increased on "+ month + " month");
    }

}
