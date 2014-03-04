/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

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
        
        deck.shuffleDeck();
        deck.printDeck();
    }
    
}
