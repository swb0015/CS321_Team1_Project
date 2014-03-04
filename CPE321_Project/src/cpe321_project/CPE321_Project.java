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
        Card holeCard = deck.dealCard();
        holeCard.setHoleCard(true);
        dealerHand.addCard(holeCard);
        dealerHand.addCard(deck.dealCard());
        dealerHand.printHand();
        System.out.println(dealerHand.getScore());
        dealerHand.clearHole();
        dealerHand.printHand();
        
        
        //deck.shuffleDeck();
        //deck.printDeck();
    }
    
}
