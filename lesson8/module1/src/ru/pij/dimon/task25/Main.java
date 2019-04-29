package ru.pij.dimon.task25;

public class Main {
    public static void main(String[] args) {
        DebitCard debitCard1 = new DebitCard("POZHARSKI DMITRI", "Visa","8796 5543 6785 6512","153","09/19","BYN");
        debitCard1.topUpCard(30);
        debitCard1.checkBalance();
        debitCard1.payCard(10);
        debitCard1.checkBalance();
        System.out.println(debitCard1);

        DebitCard debitCard2 = new PremiumDebitCard("POZHARSKI DMITRI", "Maestro","0099 1245 8324 5576","098","05/20","BYN");
        debitCard2.checkBalance();
        debitCard2.topUpCard(60);
        ((PremiumDebitCard)debitCard2).increaseWarranty(10);
        System.out.println(debitCard2);

        CreditCard creditCard1 = new CreditCard("POZHARSKI DMITRI", "Visa","3455 6853 7684 3765","209","12/19","BYN");
        creditCard1.topUpCard(100);
        creditCard1.setCreditFunds(900);
        creditCard1.checkBalance();
        creditCard1.withdrawMoneyFromCard(200);
        creditCard1.checkBalance();
        creditCard1.topUpCard(200);
        creditCard1.payOffDebt(100);
        creditCard1.checkBalance();
        System.out.println(creditCard1);

    }

}
