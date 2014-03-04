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
public class Card {
    
    private final String cardSuit;
    private final String cardFace;
    private final int cardValue;
    private Boolean holeCard;
    
    public Card(String suit, String face, int value)
    {
        cardSuit = suit;
        cardFace = face;
        cardValue = value;
        holeCard = false;
    }
    
    public String getSuit()
    {
        if (holeCard) return "";
        else return cardSuit;
    }
        
    public String getFace()
    {
        if (holeCard) return "Hole Card";
        else return cardFace;
    }
    
    public int getValue()
    {
        return cardValue;
    }
    
    public void setHoleCard(Boolean isHole){
        holeCard = isHole;
    }
}
