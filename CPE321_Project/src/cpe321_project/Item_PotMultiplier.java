/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe321_project;

/**
 *
 * @author Chris
 */
public class Item_PotMultiplier extends Item{
    public Item_PotMultiplier(String n, String d, int t){
        super(n,d,t);
    }
    @Override
    public void use(GameCharacter opponent, GameCharacter user){
        System.out.println("You're pot is now multiplied by 5!\n");
    }  
}


