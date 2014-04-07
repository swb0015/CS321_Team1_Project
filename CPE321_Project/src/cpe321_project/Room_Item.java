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
public class Room_Item extends Room{
        public Room_Item(Room left, Room right){
            if(left != null){
                setRoomLeft(left);
            }
            if(right != null){
                setRoomRight(right);
            }
    }
}
