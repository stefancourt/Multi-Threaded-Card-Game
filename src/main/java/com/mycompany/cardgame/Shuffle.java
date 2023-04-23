package com.mycompany.cardgame;

public class Shuffle {
    public static void inputCards(int n){
        // All cards get added to the hand before the decks
        if (n != CardGame.getMaxNumPlayers()) {
            System.out.println("Must take in the correct number of players");
            throw new IllegalArgumentException();
        } else if (CardPack.getCounter() != 8*n) {
            System.out.println("Pack must contain number of integers equal to 8*n players");
            throw new IndexOutOfBoundsException();
        }
        // Should put 4*n cards to hand and deck, as 8*n/2 = 4*n
        for (int i = 0; i < 4 * n; i++) {
        Player.getPlayersHand((i % n) + 1).add(CardPack.getFirstCard());
        CardPack.removeFromPack(CardPack.getPack());
        }
        for (int i = 0; i < 4 * n; i++) {
        CardDeck.getCardsInDeck((i % n) + 1).add(CardPack.getFirstCard());
        CardPack.removeFromPack(CardPack.getPack());
        }
    }
}
