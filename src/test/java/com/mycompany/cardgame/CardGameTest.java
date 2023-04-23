package com.mycompany.cardgame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardGameTest {
    @BeforeClass
    public static void setUpClass() throws IOException{
        CardGame.maxNumPlayers = 4;
        try {
            CardPack.inputPack("test.txt");
            Player.createPlayer(CardGame.maxNumPlayers);
            CardDeck.createDeck(CardGame.maxNumPlayers);
        } catch (IOException e) {
            System.out.println("Input/output exception try again");
        }
        Shuffle.inputCards(CardGame.maxNumPlayers);
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("All tests have been completed");
    }
    
    @Test
    public void testInputCards() {
        try {
            Shuffle.inputCards(15);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            CardGame.maxNumPlayers = 8;
            Shuffle.inputCards(8);
            fail("Should have thrown an IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
        CardGame.maxNumPlayers = 4;
    }
    
    @Test
    public void testCreatePlayer() {
        try {
            Player.createPlayer(-4);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testCreateDeck() {
        try {
            CardDeck.createDeck(7);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testInputPack() throws IOException{
        try {
            CardPack.inputPack("faketest.txt");
            fail("Should have thrown an IOException");
        } catch (FileNotFoundException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testShowPlayerCardNums() {
        LinkedList<Integer> player3Hand = new LinkedList<>(Arrays.asList(3,7,13,5));
        System.out.println("testing showPlayerCardNums");
        assertEquals(player3Hand, Player.showPlayerCardNums(3));
        System.out.println("Player 3's hand: "+Player.showPlayerCardNums(3));
        
    }

    @Test
    public void testGetCardNum() {
        System.out.println("testing getCardNum");
        assertEquals(9, CardDeck.getFirstCard(3).getCardNum());
        System.out.println("Card value on the top of deck 3: "+CardDeck.getFirstCard(1).getCardNum());
        
    }


    @Test
    public void testDrawCard() throws IOException{
        System.out.println("testing drawCard");
        PlayerAction.drawCard(1);
        assertEquals(5, Player.getPlayersHand(1).size());
        assertEquals(12, Player.getPlayersHand(1).get(4).getCardNum());
        System.out.println("Player 1's hand: "+Player.showPlayerCardNums(1));
        try {
            PlayerAction.drawCard(5);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testRemoveCard() throws IOException{
        System.out.println("testing removeCard");
        PlayerAction.removeCard(1);
        assertNotEquals(1, CardDeck.getFirstCard(2));
        System.out.println("Player 1's hand: "+Player.showPlayerCardNums(1));
        try {
            PlayerAction.removeCard(0);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testPlayerWinner() throws IOException{
        System.out.println("testing playerWinner");
        assertEquals(true, Winner.playerWinner(2));
        System.out.println("Player 2 does have a winning hand: "+ Player.showPlayerCardNums(2));
        assertEquals(false, Winner.playerWinner(3));
        System.out.println("Player 3 does not have a winning hand: "+ Player.showPlayerCardNums(3));
        try {
            Winner.playerWinner(5);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
