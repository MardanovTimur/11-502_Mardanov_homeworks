package ru.itis.inform;

public class DeadLock {
    public static void main(String[] args) {
        final Human human1 = new Human("Oleg");
        final Card card1 = new Card(human1, 123.1);
        final Human human2 = new Human("Steve");
        final Card card2 = new Card(human2, 300.2);

        new Thread(new Runnable() {
            public void run() {
                human1.getCard().giftTo(card2, 20);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                human2.getCard().giftTo(card1, 30);
            }
        }).start();

    }
}
