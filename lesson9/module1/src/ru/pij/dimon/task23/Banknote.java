package ru.pij.dimon.task23;

public class Banknote {
    private int denominationBanknote;
    private String currency;

    public Banknote(int denominationBanknote, String currency) {
        this.denominationBanknote = denominationBanknote;
        this.currency = currency;
    }

    public int getDenominationBanknote() {
        return denominationBanknote;
    }

    public String getCurrency() {
        return currency;
    }
}
