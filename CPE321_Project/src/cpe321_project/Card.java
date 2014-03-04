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
    
    public Card(String suit, String face, int value)
    {
        cardSuit = suit;
        cardFace = face;
        cardValue = value;
    }
    
    public String getSuit()
    {
        return cardSuit;
    }
        
    public String getFace()
    {
        return cardFace;
    }
    
    public int getValue()
    {
        return cardValue;
    }
}
