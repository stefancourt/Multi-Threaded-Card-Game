package com.mycompany.cardgame;

import java.io.IOException;


public class PlayerThread implements Runnable{
    private final int threadNumber;
    private static Boolean flag = false;
    
    public PlayerThread (int threadNumber) {
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run() {
        try {
            while (!flag)  {
                // Allow threads to recognise that the flag has changed
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                if (Winner.playerWinner(threadNumber)) {
                    flag = true;
                }
                // Allow threads to recognise that the flag has changed
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                // Stops players from unnecessarily doing a card action if the game is over
                if (!flag) {
                    PlayerAction.drawCard(threadNumber);
                    PlayerAction.removeCard(threadNumber);
                }
            }
        } catch (IOException ex) {
            System.out.println("Input/Output error has occured please try again");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Index has become out of bounds");
        }
    }
}
