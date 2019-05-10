package ru.pij.dimon.task25;

public class DebitCard extends AbstactBankCard {

    private int balance;


    public DebitCard(String cardHolderName, String paymentSystem, String cardNumber, String codeCVV, String cardExpiryDate, String currency) {
        super(cardHolderName, paymentSystem, cardNumber, codeCVV, cardExpiryDate, currency);
    }

    @Override
    public void topUpCard(int money){
        balance = balance+money;
        System.out.println("Funds have credited to the card");
    }

    @Override
    public void checkBalance() {
        System.out.println("Card balance is "+balance+" "+getCurrency());
    }

    @Override
    public void withdrawMoneyFromCard(int amount) {
        if(amount<=balance){
            System.out.println("Take money");
            balance = balance-amount;
        }else {
            System.out.println("Insufficient funds in the account");
        }
    }

    @Override
    public void payCard(int amount) {
        if(amount<=balance){
            System.out.println("Paid");
            balance = balance-amount;
        }else {
            System.out.println("Insufficient funds in the account");
        }
    }


    @Override
    public String toString() {
        return super.toString()+" balance= " + balance+" "+getCurrency();
    }
}
