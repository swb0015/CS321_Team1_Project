/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

import java.util.ArrayList;

/**
 *
 * @author Stephen
 */
public class CPE321_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Deck deck = new Deck();
        Dealer dealer = new Dealer("This is a test.",17);
        Hand dealerHand = dealer.getHand();
        Items item = new Items("Gun", "Use this to win a game instantly", 3);
        
        //create and print initial hand
        Card holeCard = deck.dealCard();
        holeCard.setHoleCard(true);
        dealerHand.addCard(holeCard);
        dealerHand.addCard(deck.dealCard());
        dealerHand.printHand();
        System.out.println(dealerHand.getScore()+"\n");
        //player hits and prints new hand
        System.out.println("Player hit");
        dealerHand.addCard(deck.dealCard());
        dealerHand.clearHole();
        dealerHand.printHand();
        System.out.println(dealerHand.getScore()+"\n");
        //player hits and prints new hand
        System.out.println("Player hit");
        dealerHand.addCard(deck.dealCard());
        dealerHand.clearHole();
        dealerHand.printHand();
        System.out.println(dealerHand.getScore()+"\n");
        
        //This prints the item menu
        item.printItem();
        
        //deck.shuffleDeck();
        //deck.printDeck();
    }
    
}
