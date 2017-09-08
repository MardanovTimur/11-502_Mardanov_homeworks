package ru.itis.inform;

public class Card {
    private double cash;
    private Human owner;

    public Card(Human owner, double cash) {
        this.cash = cash;
        this.owner = owner;
        owner.setCard(this);
    }

    public synchronized void giftTo(Card humanCard, double cash) {
        System.out.println("Get own cash");
        if (this.cash>=cash) {
            reduceGift(this, cash);
            humanCard.updateCash(cash);
        } else {
            System.out.println("No more money!");
        }
    }
    private synchronized void reduceGift(Card humanCard, double cash) {
        System.out.println("Reduce own cash");
        this.cash = this.cash - cash;
    }

    private synchronized void updateCash(double cash) {
        System.out.println("Updated!");
        this.cash += cash;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }
}
