/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

/**
 *
 * @author Breck
 */
public class Dealer {
    private final String description;
    private final Hand currentHand;
    private final int hitLimit;
    
    public Dealer(String desc, int limit){
        description = desc;
        hitLimit = limit;
        currentHand = new Hand();
    }
    
    public String getDescription(){
        return description;
    }
    
    public void addCardToHand(Card card){
        currentHand.addCard(card);
    }
    
    public Hand getHand(){
        return currentHand;
    }
    
    public int getHitLimit(){
        return hitLimit;
    }
}