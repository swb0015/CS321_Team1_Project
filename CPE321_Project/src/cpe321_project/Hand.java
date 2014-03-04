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
    
    public Hand(){
        cards = new ArrayList<>();
    }
    
    public void addCard(Card card){
        cards.add(card);
    }
    
    public void printHand()
    {
        for(Card card:cards){
            System.out.println(card.getFace()+" "+card.getSuit());
        }
    }
    
    public int getScore(){
        int score = 0;
        for(Card card:cards){
            score += card.getValue();
        }
        return score;
    }
    
    public void clearHole(){
        for(Card card:cards){
            card.setHoleCard(false);
        }
    }
    
    public void clearHand(){
        cards.clear();
    }
}
