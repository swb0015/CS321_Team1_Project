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
public class GameCharacter {
    private final String name;
    private final String description;
    private final String winString;
    private final String loseString;
    private final ArrayList<Item> items;
    private final ArrayList<Card> hand;
    
    public GameCharacter(){
        name = "John Default";
        description = "Ethnically ambiguous native tribesman.";
        winString = "You suck!";
        loseString = "You cheated!";
        items = new ArrayList<>();
        hand = new ArrayList<>();
    }
    
    public GameCharacter(String n, String d, String w, String l){
        name = n;
        description = d;
        winString = w;
        loseString = l;
        items = new ArrayList<>();
        hand = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void printItems(){
        for (Item item: items){
            System.out.println(items.indexOf(item)+1+") "+item.getName()+": "+item.getDesc());
            System.out.println("   Charge level: "+item.getChargeLevel()+"/"+item.getChargeTime());
        }
        System.out.println();
    }
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public void useItem(int item, GameCharacter opponent){
        items.get(item-1).use(opponent, this);
    }
    
    public void chargeItem(int item, int adjust){ // accepts a value by which to adjust the charge level: negative values decrement, positive values increment
       Item i = items.get(item-1);
       int level = i.getChargeLevel();
       int time = i.getChargeTime();
       level += adjust;
       if (level < 0) level = 0;
       else if (level > time) level = time;
       i.setChargeLevel(level);
    }
}
