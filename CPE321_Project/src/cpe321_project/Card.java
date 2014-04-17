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
    private int value;
    private boolean hidden;
    private final mainForm form = mainForm.getInstance();;
    
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
    
    public void setValue(int v){
        value = v;
    }
    public boolean getHidden(){
        return hidden;
    }
    public void printCard(){
        if (hidden) form.AddToStatusBar("Hidden");
        else form.AddToStatusBar(face+" of "+suit);
    }
    
    public void setHidden(boolean isHidden){
        hidden = isHidden;
    }
}
