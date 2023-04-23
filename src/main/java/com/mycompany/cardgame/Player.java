package com.mycompany.cardgame;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

public class Player {
    private static HashMap<Integer, LinkedList<Card>> playerHands = new HashMap<>();

    public static LinkedList<Card> getPlayersHand(int n) {
        return playerHands.get(n);
    }
    
    public static LinkedList<Integer> showPlayerCardNums(int n) {
        LinkedList<Integer> showsNum = new LinkedList<>();
        for (Card card : playerHands.get(n)) {
            showsNum.add(card.getCardNum());
        }
        return showsNum;
    }
    
    public static void createPlayer(int n) {
        if (n != CardGame.getMaxNumPlayers()) {
            System.out.println("Must take in the correct number of players");
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; i++) {
            playerHands.put(i + 1, new LinkedList<Card>(Arrays.asList()));
        }
    }
}
