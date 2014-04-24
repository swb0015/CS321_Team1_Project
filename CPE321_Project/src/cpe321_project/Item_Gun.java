/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

/**
 *
 * @author Breck
 */
public class Item_Gun extends Item{
    public Item_Gun(String n, String d, int t){
        super(n, d, t);
    }
    
    @Override
    public void use(GameCharacter opponent, GameCharacter user){
        System.out.println("You used Gun: Pew Pew.\n");
        this.setChargeLevel(0);
    } 
}
