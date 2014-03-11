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
    private int score;
    private boolean hasAce;
    
    public Hand(){
        cards = new ArrayList<>();
        score = 0;
        hasAce = false;
    }
    
    public void addCard(Card card){
        cards.add(card);
        if (card.getFace().equals("A")) hasAce = true; 
        score += card.getValue();
        if(score > 21 && hasAce) score -=10;
    }
    
    public void printHand(){
        for(Card card:cards){
            card.printCard();
        }
    }
    
    public int getScore(){
        return score;
    }
    
    public void showHidden(){
        for(Card card:cards){
            card.setHidden(false);
        }
    }
    
    public void clearHand(){
        cards.clear();
    }
}
