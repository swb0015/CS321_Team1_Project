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
    
    public Hand(){
        cards = new ArrayList<>();
        score = 0;
    }
    
    public void addCard(Card c){
        cards.add(c);
        calcScore();
        while (score > 21 && hasHighAce()){
            for (Card card: cards){
                if (card.getValue() == 11){
                    card.setValue(1);
                    calcScore();
                    break;
                }
            }
        }
    }
    
    public void printHand(){
        for(Card card:cards){
            card.printCard();
        }
        System.out.println();
    }
    
    public boolean hasHighAce(){
        for (Card card: cards){
            if (card.getValue() == 11) return true;
        }
        return false;
    }
    
    public int getScore(){
        return score;
    }
    
    public void calcScore(){
        score = 0;
        for (Card card: cards){
            score += card.getValue();
        }
    }
    
    public void showHidden(){
        for(Card card:cards){
            card.setHidden(false);
        }
    }
    
    public void clearHand(){
        cards.clear();
    }
    
    public int count(){
        return cards.size();
    }
}
