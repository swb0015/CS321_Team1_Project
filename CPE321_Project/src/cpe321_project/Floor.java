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
    private final Room firstRoom;
    private Room currentRoom;
    private Room previousRoom;
    private final Room_Store store;
    private final Room winRoom;
    private static final int numRooms = 9;
    
    public Floor(){
        roomArray = new ArrayList<>();
        winRoom = new Room();
        winRoom.setRoomDescription("You Win");
        winRoom.setRoomPictureURL("/cpe321_project/win_screen.jpg");
        store = new Room_Store();
        firstRoom = new Room_Game(null,null,1);
        firstRoom.setRoomDescription("This is the first room\n");
        firstRoom.setRoomPictureURL("/cpe321_project/Room_1.jpg");
        previousRoom = firstRoom;
        roomArray.add(firstRoom);
        
        for (int i =2;i<=numRooms;i++){
            currentRoom = new Room_Game(previousRoom,null,i);
            currentRoom.setRoomDescription("This is game room " + i + "\n");
            currentRoom.setRoomPictureURL("/cpe321_project/Room_" + i + ".jpg");
            previousRoom.setRoomRight(currentRoom);
            previousRoom = currentRoom;
            roomArray.add(currentRoom);
        }
        firstRoom.setRoomLeft(currentRoom);
        currentRoom.setRoomRight(firstRoom);
        currentRoom = firstRoom;
        
        
        //Add Store Image
        //store.setRoomPictureURL("/cpe321_project/.jpg");
        //store.setRoomDescription("This is the Store");
      
    }
    
    public Room moveLeft(){
        if(currentRoom != store){
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
        return currentRoom;
    }
    
    public Room moveRight(){
        if(currentRoom != store){
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
        return currentRoom;
    }
    
    public Room goToStore(){
        previousRoom = currentRoom;
        currentRoom = store;
        System.out.print(currentRoom.getRoomDescription());
        return currentRoom;
    }
    public Room goToWinRoom(){
        previousRoom = currentRoom;
        currentRoom = winRoom;
        System.out.print(currentRoom.getRoomDescription());
        return currentRoom;
    }
    
    public Room exitStore(){
        currentRoom = previousRoom;
        System.out.print(currentRoom.getRoomDescription());
        return currentRoom;
    }
    
    public Room_Store getStore(){
        return store;
    }
    
    public Room getCurrentRoom(){
        return currentRoom;
    }
}
