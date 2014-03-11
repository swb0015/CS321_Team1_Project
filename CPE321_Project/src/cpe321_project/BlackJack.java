/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe321_project;

/**
 *
 * @author Breck
 */
public class BlackJack {
    private final GameCharacter npc;
    private final GameCharacter player;
    private final int ante;
    private final Deck deck;
    
    public BlackJack(GameCharacter n, GameCharacter p, int a){
        npc = n;
        player = p;
        ante = a;
        deck = new Deck();
    }
    
    public boolean roundOver(){
        if (player.getHandScore() > 21){
            System.out.println("Bust! You lose!");
            System.out.println(npc.getWinString());
            player.changePoints(-ante);
            return true;
        } else if (npc.getHandScore() > 21){
            System.out.println(npc.getName()+" busted! You win!");
            System.out.println(npc.getLoseString());
            player.changePoints(ante*player.getMultiplier());
            return true;
        } else return false;
    }
    
    public void hit(){
        player.addCard(deck.dealCard());
        player.chargeAllItems(1);
        if (roundOver()) return;
        if (npc.getHandScore() < npc.getLimit()){
            npc.addCard(deck.dealCard());
            player.chargeAllItems(1);
            roundOver();
        }
    }
}
