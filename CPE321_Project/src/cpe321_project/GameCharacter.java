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
    private int points;
    private final int hitLimit;
    private int potMultiplier;
    private final ArrayList<Item> items;
    private Hand hand;
    private final mainForm form = mainForm.getInstance();;
    
    public GameCharacter(){
        name = "";
        description = "";
        winString = "";
        loseString = "";
        points = 100;
        hitLimit = 0;
        potMultiplier = 2;
        items = new ArrayList<>();
    }
    public Hand getHand(){
        return hand;
    }
    public GameCharacter(String n, String d, String w, String l, int h){
        name = n;
        description = d;
        winString = w;
        loseString = l;
        points = 0;
        hitLimit = h;
        potMultiplier = 0;
        items = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void printItems(){
        for (Item item: items){
            form.AddToStatusBar(items.indexOf(item)+1+") "+item.getName()+": "+item.getDesc());
            form.AddToStatusBar("   Charge level: "+item.getChargeLevel()+"/"+item.getChargeTime());
        }
        form.AddToStatusBar("");
    }
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public void useItem(int item, GameCharacter opponent){
        try {
            items.get(item-1).use(opponent, this);
        } catch (IndexOutOfBoundsException e) {
            form.AddToStatusBar("No such item.\n");
        }
    }
    
    public int itemCount(){
        return items.size();
    }
    
    public void chargeItem(int id, int adjust){ // accepts a value by which to adjust the charge level: negative values decrement, positive values increment
        try {
           Item item = items.get(id-1);
           int level = item.getChargeLevel();
           int time = item.getChargeTime();
           level += adjust;
           if (level < 0) level = 0;
           else if (level > time) level = time;
           item.setChargeLevel(level);
        } catch (IndexOutOfBoundsException e) {
            form.AddToStatusBar("No such item.\n");
        }
    }
    
    public void chargeAllItems(int adjust){
        int level;
        int time;
        for (Item item: items){
            level = item.getChargeLevel();
            time = item.getChargeTime();
            level += adjust;
            if (level < 0) level = 0;
            else if (level > time) level = time;
            item.setChargeLevel(level);
        }
    }
    
    public void addCard(Card c){
        hand.addCard(c);
        //form.AddToStatusBarNoReturn("Card dealt: ");
        //c.printCard();
    }
    
    public int getHandScore(){
        return hand.getScore();
    }
    
    public String getWinString(){
        return winString;
    }
    
    public String getLoseString(){
        return loseString;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void setPoints(int p){
        points = p;
    }
    
    public void changePoints(int adjust){
        points += adjust;
        if (points < 0) points = 0;
    }
    
    public int getMultiplier(){
        return potMultiplier;
    }
    
    public void setMultiplier(int m){
        potMultiplier = m;
    }
    
    public int getLimit(){
        return hitLimit;
    }
    
    public int getCardCount(){
        return hand.count();
    }
    
    public void printHand(){
        hand.printHand();
    }
    
    public void showHiddenCards(){
        hand.showHidden();
    }
    
    public void setupForGame(){
        hand = new Hand();
    }
}
