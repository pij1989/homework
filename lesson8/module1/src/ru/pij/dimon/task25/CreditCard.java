package ru.pij.dimon.task25;


public class CreditCard extends AbstactBankCard {
    private int ownFunds;
    private int creditFunds;
    private int debt;

    public CreditCard(String cardHolderName, String paymentSystem, String cardNumber, String codeCVV, String cardExpiryDate, String currency) {
        super(cardHolderName, paymentSystem, cardNumber, codeCVV, cardExpiryDate, currency);
    }

    public int getCreditFunds() {
        return creditFunds;
    }

    public void setCreditFunds(int creditFunds) {
        this.creditFunds = creditFunds;
    }


    @Override
    public void topUpCard(int money) {
        ownFunds = ownFunds+money;
        System.out.println("Funds have credited to the card");
    }

    @Override
    public void checkBalance() {
        System.out.println("Card balance is "+(ownFunds+creditFunds)+" "+getCurrency()+"\n"+"- Own funds is "+ownFunds+" "+getCurrency()+"\n"+"- Credit funds is "+creditFunds+" "+getCurrency()+
                "\n"+"- Debt is "+debt+" "+getCurrency());

    }

    @Override
    public void withdrawMoneyFromCard(int amount) {
        int dif;
        if(amount<=ownFunds){
            System.out.println("Take money");
            ownFunds = ownFunds-amount;
        }else {
            if (amount<=creditFunds){
                System.out.println("Take money");
                dif = amount-ownFunds;
                ownFunds = 0;
                creditFunds = creditFunds-dif;
                debt = debt+dif;
            }else {
            System.out.println("Insufficient funds in the account");}
        }
    }

    @Override
    public void payCard(int amount) {
        int dif;
        if(amount<=ownFunds){
            System.out.println("Paid");
            ownFunds = ownFunds-amount;
        }else {
            if (amount<=creditFunds){
                System.out.println("Paid");
                dif = amount-ownFunds;
                ownFunds = 0;
                creditFunds = creditFunds-dif;
                debt = debt+dif;
            }else {
                System.out.println("Insufficient funds in the account");}
        }
    }

    public void payOffDebt(int amount){
        if (debt == 0){
            System.out.println("You haven't debt");
        } else {
            if(amount<=ownFunds){
                debt = debt-amount;
                ownFunds = ownFunds-amount;
                creditFunds = creditFunds+amount;
                System.out.println("You pay "+amount+ " "+ getCurrency()+". Balance owed is "+debt+" "+getCurrency());
        } else {
                System.out.println("Insufficient funds in the account");}
            }

        }

    @Override
    public String toString() {
        return  super.toString()+" ownFunds= " + ownFunds + " "+getCurrency()+
                ", creditFunds= " + creditFunds +" "+getCurrency()+
                ", debt= " + debt+" "+getCurrency();
    }
}
