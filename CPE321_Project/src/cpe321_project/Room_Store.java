/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

import java.util.ArrayList;

/**
 *
 * @author Stephen
 */
public class Room_Store extends Room{
    
    private ArrayList<Item> inventory;
    
    public Room_Store(){
        setRoomDescription("This is the store\n");
        setRoomLeft(this);
        setRoomRight(this);
        setRoomPictureURL("/cpe321_project/Room_store.jpg");  
        Item_CarKeys keys = new Item_CarKeys();
        keys.setCost(10000);
        keys.setIconURL("/cpe321_project/keys_icon.jpg");
        inventory = new ArrayList<>();
        inventory.add(keys);
    }
    public ArrayList<Item> GetInventory(){
        return inventory;
    }
}
