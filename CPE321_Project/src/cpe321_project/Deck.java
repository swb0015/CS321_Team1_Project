/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Stephen
 */
public class Deck {
    
    private final int DECK_SIZE = 52; 
    private final ArrayList<Card> cards;
    private final String suits[] = {"Spades", "Hearts", "Clubs", "Diamonds"};
    private final String faces[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final int values[] = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    
    public Deck()
    {
        cards = new ArrayList<>();
        
        for (String suit: suits)
        {
            for (int i = 0; i < 13; i++)
            {
                cards.add(new Card(suit,faces[i],values[i]));
            }
        }
        
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(cards);
    }
    
    public void printDeck()
    {
        for(Card card:cards)
        {
            System.out.println(card.getFace()+" "+card.getSuit());
        }
    }
    
}
