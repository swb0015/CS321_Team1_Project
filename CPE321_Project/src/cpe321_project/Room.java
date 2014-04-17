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
public class Room{
    
    private Room roomLeft;
    private Room roomRight;
    private String roomDescription;
    private String roomPictureURL;


    public Room(){  
        roomLeft = null;
        roomRight = null;
    }
    
    public void setRoomLeft(Room room){
        roomLeft = room;
    }
    
    public String getroomPictureURL(){
        return roomPictureURL;
    }
    
    public void setRoomPictureURL(String roomURL){
        roomPictureURL = roomURL;
    }
    
    public void setRoomRight(Room room){
        roomRight = room;
    }
    
    public Room getRoomLeft(){
        return roomLeft;
    }
    
    public Room getRoomRight(){
        return roomRight;
    }
    
    void setRoomDescription(String desc){
        roomDescription = desc;
    }
    String getRoomDescription(){
        return roomDescription;
    }

}
