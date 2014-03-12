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
    private final GameCharacter player;
    private final GameCharacter npc;
    private int playerScore;
    private int npcScore;
    private int playerCardCount;
    private int npcCardCount;
    private boolean playerStay;
    private boolean npcStay;
    private boolean playerBlackJack;
    private boolean npcBlackJack;
    private final int ante;
    private final Deck deck;
    
    public BlackJack(GameCharacter p, GameCharacter n, int a){
        player = p;
        npc = n;
        playerScore = 0;
        npcScore = 0;
        playerCardCount = 0;
        npcCardCount = 0;
        playerStay = false;
        npcStay = false;
        playerBlackJack = false;
        npcBlackJack = false;
        ante = a;
        deck = new Deck();
    }
    
    private boolean roundOver(){
        player.chargeAllItems(1);
        playerScore = player.getHandScore();
        npcScore = npc.getHandScore();
        
        if (playerScore > 21){
            playerLose("Bust! You lose!");
            return true;
        } else if (npcScore > 21){
            playerWin(npc.getName()+" busted! You win!");
            return true;
        }
        
        playerCardCount = player.getCardCount();
        npcCardCount = npc.getCardCount();
        
        if (playerScore == 21){
            playerStay = true;
            if (playerCardCount == 2) playerBlackJack = true;
        }
        if (!npcStay && npcScore >= npc.getLimit()){
            System.out.println(npc.getName()+" chose to stay.\n");
            npcStay = true;
            if (npcScore == 21 && npcCardCount == 2) npcBlackJack = true;
        }        
        
        if (playerBlackJack && npcBlackJack){
            gameTied();
            return true;
        } else if (playerBlackJack && npcStay){
            playerWin("You win!");
            return true;
        } else if (npcBlackJack && playerStay){
            playerLose("You lose!");
            return true;
        } else if (playerStay && npcStay && playerScore == npcScore){
            gameTied();
            return true;
        } else if (playerStay && npcStay && playerScore > npcScore){
            playerWin("You win!");
            return true;
        } else if (playerStay && npcStay && playerScore < npcScore){
            playerLose("You lose!");
            return true;
        } else return false;
    }
    
    public void playerWin(String msg){
        npc.showHiddenCards();
        System.out.println("Your hand:");
        player.printHand();
        System.out.println(npc.getName()+"'s hand:");
        npc.printHand();
        System.out.println(msg);
        System.out.println(npc.getName()+" says: "+npc.getLoseString()+"\n");
        player.changePoints(ante*player.getMultiplier());
    }
    
    public void playerLose(String msg){
        npc.showHiddenCards();
        System.out.println("Your hand:");
        player.printHand();
        System.out.println(npc.getName()+"'s hand:");
        npc.printHand();
        System.out.println(msg);
        System.out.println(npc.getName()+" says: "+npc.getWinString()+"\n");
        player.changePoints(-ante);
    }
    
    public void gameTied(){
        System.out.println("It's a tie!");
    }
    
    public boolean hit(){
        System.out.println("You chose to hit.");
        player.addCard(deck.dealCard());
        System.out.println("Your hand:");
        player.printHand();
        if (roundOver()) return true;
        else if (npcStay) return false;
        else {
            System.out.println(npc.getName()+" chose to hit.");
            npc.addCard(deck.dealCard());
            System.out.println(npc.getName()+"'s hand:");
            npc.printHand();
            return roundOver();
        }
    }
    
    public boolean stay(){
        System.out.println("You chose to stay.\n");
        playerStay = true;
        if (roundOver()) return true;
        else {
            while (!roundOver()){
                System.out.println(npc.getName()+" chose to hit.");
                npc.addCard(deck.dealCard());
                System.out.println(npc.getName()+"'s hand:");
                npc.printHand();
            }
            return true;
        }
    }
    
    public boolean deal(){
        System.out.print("Player ");
        player.addCard(deck.dealCard());
        Card holeCard = deck.dealCard();
        holeCard.setHidden(true);
        System.out.print(npc.getName()+" ");
        npc.addCard(holeCard);
        System.out.print("Player ");
        player.addCard(deck.dealCard());
        System.out.print(npc.getName()+" ");
        npc.addCard(deck.dealCard());
        System.out.println("\nYour hand:");
        player.printHand();
        System.out.println(npc.getName()+"'s hand:");
        npc.printHand();
        return false;
        //return roundOver();
    }
}
