package com.mycompany.cardgame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Winner {
    public static Boolean playerWinner(int n) throws IOException{
        if (n > CardGame.getMaxNumPlayers() || n < 1) {
            System.out.println("must take in a value between 1 and maximum amount of players");
            throw new IllegalArgumentException();
        }
        int value = Player.getPlayersHand(n).get(0).getCardNum();
        AtomicInteger matches = new AtomicInteger(0);
        // Checks to see if the cards in the hand are all the same
        for (int i = 1; i < 4; i++) {
            if (value == Player.getPlayersHand(n).get(i).getCardNum()) {
                matches.incrementAndGet();
            }
        }
        if (matches.get() == 3) {
            try {
                for (int i=1; i < (CardGame.getMaxNumPlayers()+1); i++) {
                BufferedWriter playerWriter = new BufferedWriter(new FileWriter("player" + i + "_output.txt", true));
                BufferedWriter deckWriter = new BufferedWriter(new FileWriter("deck" + i + "_output.txt", true));
                if (n == i) {
                    try {
                        playerWriter.append("player " + n + " wins");
                        playerWriter.append("\n");
                        playerWriter.append("player " + n + " exits");
                        playerWriter.append("\n");
                        playerWriter.append("player " + n + " final hand: " + Player.showPlayerCardNums(n));
                        playerWriter.append("\n");
                        playerWriter.close();
                        deckWriter.append("deck"+n+" contents "+CardDeck.showDeckCardNums(n));
                        deckWriter.append("\n");
                        deckWriter.close();
                        System.out.println("player "+n+" wins");
                    } catch (IOException e) {
                        System.out.println("Input/output error please try again");
                    }
                } else {
                    try {
                        playerWriter.append("player " + n + " has informed player "+i+" that player "+n+" has won");
                        playerWriter.append("\n");
                        playerWriter.append("player " + i + " exits");
                        playerWriter.append("\n");
                        playerWriter.append("player " + i + " hand: " + Player.showPlayerCardNums(i));
                        playerWriter.append("\n");
                        playerWriter.close();
                        deckWriter.append("deck"+i+" contents "+CardDeck.showDeckCardNums(i));
                        deckWriter.append("\n");
                        deckWriter.close();
                    } catch (IOException e) {
                        System.out.println("Input/output error please try again");
                    }
                }
            }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index is out of bounds");
            }
            return true;
        }
        return false;
    }
}
