package com.mycompany.cardgame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;

public class CardDeck {
    private static HashMap<Integer, LinkedList<Card>> cardsInDecks = new HashMap<>();

    public static void createDeck(int n) {
        if (n != CardGame.getMaxNumPlayers()) {
            System.out.println("Must take in the correct number of players");
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; i++) {
            cardsInDecks.put(i + 1, new LinkedList<Card>(Arrays.asList()));
        }
    }

    public static LinkedList<Card> getCardsInDeck(int n) {
        return cardsInDecks.get(n);
    }
    
    public static LinkedList<Integer> showDeckCardNums(int n) {
        LinkedList<Integer> showsNum = new LinkedList<>();
        for (Card card : cardsInDecks.get(n)) {
            showsNum.add(card.getCardNum());
        }
        return showsNum;
    }
    public static synchronized void addCardToDeck(int n, Card card) {
        cardsInDecks.get(n).addLast(card);
    }

    public static synchronized void removeCardFromDeck(int n) {
        cardsInDecks.get(n).removeFirst();
    }

    public static Card getFirstCard(int n) {
        return cardsInDecks.get(n).getFirst();
    }
}
