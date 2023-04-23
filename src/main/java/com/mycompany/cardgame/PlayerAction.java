package com.mycompany.cardgame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PlayerAction {
    
    public static synchronized void drawCard(int n) throws IOException {
        if (n > CardGame.getMaxNumPlayers() || n < 1) {
            System.out.println("Must take in a value between 1 and maximum amount of players");
            throw new IllegalArgumentException();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("player" + n + "_output.txt", true));
        try {
            if (n == CardGame.getMaxNumPlayers()) {
                writer.append("player " + n + " draws a "+CardDeck.getFirstCard(n).getCardNum()+" from deck 1");
            } else {
                writer.append("player " + n + " draws a "+CardDeck.getFirstCard(n).getCardNum()+" from deck " + n);
            }
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Input/output error please try again");
        }
        Player.getPlayersHand(n).add(CardDeck.getFirstCard(n));
        CardDeck.removeCardFromDeck(n);
    }
    
    public static synchronized void removeCard(int n) throws IOException {
        if (n > CardGame.getMaxNumPlayers() || n < 1) {
            System.out.println("Must take in a value between 1 and maximum amount of players");
            throw new IllegalArgumentException();
        }
        while (true) {
            Random rand = new Random();
            // When the player draws a card their hand will contain 5 cards not 4
            int randomIndex = rand.nextInt(5);
            if (Player.getPlayersHand(n).get(randomIndex).getCardNum() != n) {
                Card card = Player.getPlayersHand(n).get(randomIndex);
                Player.getPlayersHand(n).remove(randomIndex);
                // If the player is the last player then the card needs to be sent to deck 1 instead of n+1
                if (n == CardGame.getMaxNumPlayers()) {
                    CardDeck.addCardToDeck(1, card);
                } else {
                    CardDeck.addCardToDeck(n + 1, card);
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter("player" + n + "_output.txt", true));
                try {
                    if (n == CardGame.getMaxNumPlayers()) {
                        writer.append("player " + n + " discards a "+card.getCardNum()+" to deck 1");
                    } else {
                        writer.append("player " + n + " discards a "+card.getCardNum()+" to deck " + (n+1));
                    }
                    writer.append("\n");
                    writer.append("player " + n + " current hand is " + Player.showPlayerCardNums(n));
                    writer.append("\n");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Input/output error please try again");
                }
                break;
            }
        }
    }
}
