package com.mycompany.cardgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class CardPack {
    private static LinkedList<Card> pack = new LinkedList<>();
    private static int counter = 0;
    public static LinkedList<Card> getPack() {
      return pack;
    }

    public static void inputPack(String filename) throws IOException, FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            try {
                for (String line; (line = br.readLine()) != null;) {
                    try {
                        Integer cardValue = Integer.valueOf(line);
                        pack.addLast(new Card(cardValue));
                        counter += 1;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Make sure that the file only contains numbers");
                    }
                }
            } catch (IOException e) {
                System.out.println("Input/output error please try again");
                throw new IOException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Please enter a valid file name");
            throw new FileNotFoundException();
        }   
    }
    
    public static void removeFromPack(LinkedList<Card> pack) {
        pack.removeFirst();
    }
    
    public static Card getFirstCard() {
        return getPack().getFirst();
    }
    
    public static int getCounter() {
        return counter;
    }
}
