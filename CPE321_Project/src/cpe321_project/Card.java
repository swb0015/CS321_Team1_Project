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
    
    private final String suit;
    private final String face;
    private final int value;
    private boolean hidden;
    
    public Card(String s, String f, int v){
        suit = s;
        face = f;
        value = v;
        hidden = false;
    }
    
    public String getSuit(){
        return suit;
    }
        
    public String getFace(){
        return face;
    }
    
    public int getValue(){
        return value;
    }
    
    public void printCard(){
        if (hidden) System.out.println("Hidden");
        else System.out.println(face+" of "+suit);
    }
    
    public void setHidden(boolean isHidden){
        hidden = isHidden;
    }
}
