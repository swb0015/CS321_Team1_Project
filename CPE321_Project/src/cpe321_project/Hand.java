/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

import java.util.ArrayList;

/**
 *
 * @author Breck
 */
public class Hand {
    private final ArrayList<Card> cards;
    private int handScore;
    private Boolean playerBust = false;
    
    public Hand(){
        cards = new ArrayList<>();
        handScore = 0;
    }
    
    public void addCard(Card card){
        cards.add(card);
        handScore += card.getValue();
        if(handScore > 21 && containsAce()){
            handScore -=10;
        }
        if(handScore > 21){
            playerBust = true;
        }
    }
    
    public void printHand()
    {
        for(Card card:cards){
            System.out.println(card.getFace()+" "+card.getSuit());
        }
    }
    
    public Boolean containsAce(){
        Boolean hasAce = false;
        for (Card card:cards){
            if("A".equals(card.getFace())){
                hasAce = true;
            }
        }
        return hasAce;
    }
    
    public int getScore(){
        if(playerBust){
            playerBusted();
        }
        return handScore;
    }
    
    public void clearHole(){
        for(Card card:cards){
            card.setHidden(false);
        }
    }
    
    public void clearHand(){
        cards.clear();
    }
    
    public void playerBusted(){
        System.out.println("Player Busted with:");
    }
}
