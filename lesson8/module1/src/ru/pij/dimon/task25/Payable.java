package ru.pij.dimon.task25;

public interface Payable {
    void topUpCard(int money);

    void checkBalance();

    void withdrawMoneyFromCard(int amount);

    void payCard(int amount);
}
