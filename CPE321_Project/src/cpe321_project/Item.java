/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

/**
 *
 * @author Tommy
 */
public abstract class Item {
    private String name;
    private String description;
    private int chargeTime;
    private int chargeLevel;
    
    public Item(){
        name = "Magic Item";
        description = "This item performs some arbitrary magic to help you win the game.";
        chargeTime = 5;
        chargeLevel = 5;
    }
    
    public Item(String n, String d, int t){
        name = n;
        description = d;
        chargeTime = t;
        chargeLevel = t;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDesc(){
        return description;
    }
    
    public int getChargeTime(){
        return chargeTime;
    }
    
    public int getChargeLevel(){
        return chargeLevel;
    }
    
    public void setName(String n){
        name = n;
    }
    public void setDescription(String d){
        description = d;
    }
    public void setChargeTime(int t) {
        chargeTime = t;
    }
    
    public void setChargeLevel(int l){
       chargeLevel = l;
    }
    
    abstract void use(GameCharacter opponent, GameCharacter user);
}
