package com.mycompany.cardgame;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CardGame {
    protected static int maxNumPlayers;

    public static void main(String[] args) throws IOException, InputMismatchException {
        Scanner myObjScanner = new Scanner(System.in);
        System.out.println("Please enter the number of players:");
        int n = myObjScanner.nextInt();
        maxNumPlayers = n;
        myObjScanner.nextLine();
        System.out.println("Please enter location of pack to load:");
        String filename = myObjScanner.nextLine();
        Player.createPlayer(n);
        CardDeck.createDeck(n);
        CardPack.inputPack(filename);
        Shuffle.inputCards(n);
        for (int i=1; i<(maxNumPlayers+1); i++) {
            PlayerThread thisThread = new PlayerThread(i);
            Thread playerThread = new Thread(thisThread);
            playerThread.start();
            }
        }

    public static int getMaxNumPlayers() {
        return maxNumPlayers;
    }
}
