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
public class Room_Game extends Room{
    
    private final BlackJack game;
    private Boolean gameAlreadyPlayed = false;
       
    public Room_Game(Room left, Room right, int roomNumber){
            if(left != null){
                setRoomLeft(left);
            }
            if(right != null){
                setRoomRight(right);
            }
            game = new BlackJack(roomNumber);
    }

    
    public BlackJack getGame(){
        return game;
    }
    
    public void setGamePlayed(){
        gameAlreadyPlayed = true;
    }
    
    public Boolean getGamePlayed(){
        return gameAlreadyPlayed;
    }

}
