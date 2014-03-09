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
public class Items {
    private String name;
    private String description;
    private int recharge; //Used to keep track of item usage
    private int powerNeeded; //Amount of power you 
    
    public Items(String n, String desc, int power) {
        name = n;
        description = desc;
        recharge = power;
        powerNeeded = power;
    }
    
    public String useItem(){
        if(recharge == powerNeeded)
        {
            recharge = 0;
            return name; //Look into Logic for each item effect to go here
                        //Or maybe in the Black Jack Management Class
            /*
            switch (name) {
                    case "Gun":
                        
                        break;
                    case "Sleight Of Hand":
                        
                        break;
                    case "Ambiguous Ethnicity Feather":
                        
                        break;
                    case "Club Member Card":
                        
                        break;
                    case "Tomahawk":
                        
                        break;
        }*/
        }
        else
            return "Needs more time to recharge.";
    }
    
    public void incRecharge() {
        if(recharge < powerNeeded)
            recharge++;
    }
    
    public void printItem(){
        System.out.println(name + ": " + description);
        System.out.println("\tCharge Level:"+recharge+"/"+powerNeeded);
    }
    
    public String getName(){
        return name;
    } 
    public String getDescription(){
        return description;
    }  
    public int getRecharge(){
        return recharge;
    } 
    public int getPowerNeeded(){
        return powerNeeded;
    }  
    public void setName(String n){
        name = n;
    }
    public void setDescription(String desc){
        description = desc;
    }
    public void setRecharge(int i) {
        recharge = i;
    }
    public void setPowerNeeded(int i) {
        powerNeeded = i;
    }    
}
