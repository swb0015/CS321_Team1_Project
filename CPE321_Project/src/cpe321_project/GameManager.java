/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

import java.util.Scanner;

/**
 *
 * @author Stephen
 */
public class GameManager {
    
    private static GameManager instance = null;
    private Boolean gameInProgress = false;
    private Boolean endOfGame = false;

    private Room currentRoom;
    private BlackJack currentGame;
    private Floor currentFloor;
    private static GameCharacter player;
    Scanner in = new Scanner(System.in);
        
    protected GameManager() {
       // Exists only to defeat instantiation.
    }
    public static GameManager getInstance() {
       if(instance == null) {
          instance = new GameManager();
       }
       player = new GameCharacter();
       return instance;
    }
    
    public void initializeGame(){
        currentFloor = new Floor();
        currentRoom = currentFloor.getCurrentRoom();
        currentGame = ((Room_Game)currentRoom).getGame();
    }
    
    public GameCharacter getPlayer(){
        return player;
    }

     public void setCurrentRoom(){
         currentRoom = currentFloor.getCurrentRoom();
     }

     public void setCurrentGame(){
         currentGame = ((Room_Game)currentRoom).getGame();
     }
     public BlackJack getCurrentGame(){
         return currentGame;
     } //probably not needed either

     public void setCurrentFloor(Floor floor){
         currentFloor = floor;
     } // likely not needed due to 1 floor arrangement

     public Floor getCurrentFloor(){
         return currentFloor;
     }
     
     public Boolean playGame(){
         gameInProgress = true;
         
         currentGame.deal();
         
         while(gameInProgress){
            String input = in.next();
             switch (input) {
                 case "hit":
                     gameInProgress = !currentGame.hit();
                     break;
                 case "stay":
                     gameInProgress = !currentGame.stay();
                     break;
             }
         }
         
         ((Room_Game)currentRoom).setGamePlayed();
         
         return gameInProgress;
     }
     
     public void listenForMove(){
            String input = in.next();
             switch (input) {
                 case "left":
                     if(currentRoom!=currentFloor.getStore()){
                        currentRoom = currentFloor.moveLeft();
                        if(!((Room_Game)currentRoom).getGamePlayed()){
                           playGame();
                        }
                     }
                     break;
                 case "right":
                     if(currentRoom!=currentFloor.getStore()){
                        currentRoom = currentFloor.moveRight();
                        if(!((Room_Game)currentRoom).getGamePlayed()){
                            playGame();
                        }
                     }
                     break;
                 case "store":
                     currentRoom = currentFloor.goToStore();
                     break;
                 case "exit":
                     currentRoom = currentFloor.exitStore();
                     break;
             }
     }
     
     public void saveGame(){
         
     }
     
     public GameManager loadGame(){
         return instance;
     }
     
     public Boolean getEndOfGame(){
         return endOfGame;
     }
}
