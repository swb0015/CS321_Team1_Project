/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class Item_BonusCard extends Item{
    public Item_BonusCard(String n, String d, int t){
        super(n, d, t);
    }
    
    @Override
    public void use(GameCharacter opponent, GameCharacter user){
        String suit="";
        String faces="";
        int choice; //choice of menu for user input of Suit
        int choice2; //choice of menu for user input of face value of card  
        int end = 0; //for the while loop of cards they pick, if they pick a card out of range it will ask for heir input again.
        
        int value=0x1;  // Have to calculate value of the card choice (like an Ace) 
        System.out.println("You used a Bonus Card: Bonus card!\n");
        this.setChargeLevel(0);
        
        Scanner in = new Scanner(System.in);
       
        
        System.out.println("Please choose you're suit from the menu:\n1.Spades\n2.Hearts\n3.Clubs\n4.Diamonds\n");
        choice=in.nextInt();
        
        if(choice==1)
        {
            System.out.println("You chose a Spade.\n");
            suit="Spades";
        }
        if(choice==2)
        {
            System.out.println("You chose a Heart.\n"); 
            suit="Hearts";
        }
        if(choice==3)
        {
            System.out.println("You chose a Club.\n");
            suit="Clubs";
        }
        if(choice==4)
        {
            System.out.println("You chose a Diamond.\n");               
            suit="Diamonds";
        }
        if(choice>4)
        {
            System.out.println("You picked a suit that does not exist. Try again.\n");           
        }
        
        //need to create loop for input if they choose an invalid card or option - cdc0012
        //while(end==-1)
     
        System.out.println("Enter the face of the card: ");
        faces=in.next();
        if(faces.equals("Ace"))
        {
  
            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("2"))
        {
     
            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("3"))
        {
   
            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("4"))
        {

            System.out.println("You chose the "+faces+ " of "+suit+"\n");
        }
        else if(faces.equals("5"))
        {

            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("6"))
        {

            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("7"))
        {

            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("8"))
        {

            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("9"))
        {

            System.out.println("You chose the "+faces+ " of "+suit+"\n");
        }
        else if(faces.equals("10"))
        {
 
            System.out.println("You chose the "+faces+ " of "+suit+"\n");
        }
        else if(faces.equals("Jack"))
        {
 
            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("Queen"))
        {

            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else if(faces.equals("King"))
        {
            System.out.println("You chose the "+faces+" of "+suit+"\n");
        }
        else
        {
            System.out.println("Error, invalid card. Try again.\n");
            //end = -1;
        }
        }
          
    }