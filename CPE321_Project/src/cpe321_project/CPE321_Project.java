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
        //deck.print();
        Dealer dealer = new Dealer("This is a test.",17);
        Hand dealerHand = dealer.getHand();
        
        //create and print initial hand
        Card holeCard = deck.dealCard();
        holeCard.setHidden(true);
        dealerHand.addCard(holeCard);
        dealerHand.addCard(deck.dealCard());
        dealerHand.printHand();
        System.out.println(dealerHand.getScore()+"\n");
        //player hits and prints new hand
        System.out.println("Player hit");
        dealerHand.addCard(deck.dealCard());
        dealerHand.showHidden();
        dealerHand.printHand();
        System.out.println(dealerHand.getScore()+"\n");
        //player hits and prints new hand
        System.out.println("Player hit");
        dealerHand.addCard(deck.dealCard());
        dealerHand.showHidden();
        dealerHand.printHand();
        System.out.println(dealerHand.getScore()+"\n");
        
        // testing character and item stuff
        GameCharacter player = new GameCharacter();
        player.addItem(new Item_BonusCard("Hammer","Smash shit.",5));
        player.addItem(new Item_BonusCard("Knife","Stab shit.",7));
        player.addItem(new Item_Gun("Gun","Shoot shit.",9));
        player.printItems();
        GameCharacter npc1 = new GameCharacter();
        player.useItem(1, npc1);
        player.useItem(3, npc1);
        player.useItem(99, npc1);
        player.printItems();
        player.chargeItem(1, 3);
        player.chargeItem(3, 4);
        player.printItems();
        player.chargeItem(1, 1);
        player.chargeItem(3, -2);
        player.chargeItem(99, -2);
        player.printItems();
    }  
}
