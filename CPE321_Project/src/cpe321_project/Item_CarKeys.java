/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

/**
 *
 * @author david_b2003
 */
public class Item_CarKeys extends Item{
    
    
   @Override
    public void use(GameCharacter opponent, GameCharacter user){
        System.out.println("You made the dealer hit!\n");
        GameManager manager = GameManager.getInstance();
        if(manager.getPlayer().getPoints() >= this.getCost())
        {
            System.out.println("You can afford it");
              mainForm form = mainForm.getInstance();
              form.PlayerWins();
        }
        
    }
    
}
