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
public class Floor {
    
    public ArrayList<Room> roomArray;
    public Room firstRoom;
    public Room currentRoom;
    public Room previousRoom;
    private static final int numRooms = 10;
    
    public Floor(){
        roomArray = new ArrayList<>();
        
        firstRoom = new Room_Game(null,null);
        firstRoom.setRoomDescription("This is the first room");
        previousRoom = firstRoom;
        roomArray.add(firstRoom);
        
        for (int i =1;i<=numRooms;i++){
            if((i%4) == 0){
                currentRoom = new Room_Item(previousRoom,null);            
                currentRoom.setRoomDescription("This is item room " + i + "\n");
            }
            else {
                currentRoom = new Room_Game(previousRoom,null);
                currentRoom.setRoomDescription("This is game room " + i + "\n");
            }
            previousRoom.setRoomRight(currentRoom);
            previousRoom = currentRoom;
            roomArray.add(currentRoom);
        }
        firstRoom.setRoomLeft(currentRoom);
        currentRoom.setRoomRight(firstRoom);
        currentRoom = firstRoom;

    }
    
    void moveLeft(){
        if(firstRoom == currentRoom && firstRoom == previousRoom){
            currentRoom = firstRoom.getRoomLeft();
            previousRoom = firstRoom;
        }
        else {
            previousRoom = currentRoom;
            currentRoom = currentRoom.getRoomLeft();
        }
        System.out.print(currentRoom.getRoomDescription());
    }
    
    void moveRight(){
        if(firstRoom == currentRoom && firstRoom == previousRoom){
            currentRoom = firstRoom.getRoomRight();
            previousRoom = firstRoom;
        }
        else {
            previousRoom = currentRoom;
            currentRoom = currentRoom.getRoomRight();
        }
        System.out.print(currentRoom.getRoomDescription());
    }
}
