/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe321_project;

/**
 *
 * @author Breck
 */
public class BlackJack {
    private final GameManager manager = GameManager.getInstance();
    private final GameCharacter player;
    private GameCharacter dealer;
    private int playerScore;
    private int dealerScore;
    private int playerCardCount;
    private int dealerCardCount;
    private boolean playerStay;
    private boolean dealerStay;
    private boolean playerBlackJack;
    private boolean dealerBlackJack;
    private int ante;
    private final Deck deck;
    private final mainForm form = mainForm.getInstance();;
    public BlackJack(int gameNumber){
        dealer = initialize(gameNumber);
        player = manager.getPlayer();
        playerScore = 0;
        dealerScore = 0;
        playerCardCount = 0;
        dealerCardCount = 0;
        playerStay = false;
        dealerStay = false;
        playerBlackJack = false;
        dealerBlackJack = false;
        deck = new Deck();
    }
    public GameCharacter getDealer(){
        return dealer;
    }
    private boolean roundOver(){
        player.chargeAllItems(1);
        playerScore = player.getHandScore();
        dealerScore = dealer.getHandScore();
        
        if (playerScore > 21){
            playerLose("Bust! You lose!");
            return true;
        } else if (dealerScore > 21){
            playerWin(dealer.getName()+" busted! You win!");
            return true;
        }
        
        playerCardCount = player.getCardCount();
        dealerCardCount = dealer.getCardCount();
        
        if (playerScore == 21){
            playerStay = true;
            if (playerCardCount == 2) playerBlackJack = true;
        }
        if (!dealerStay && dealerScore >= dealer.getLimit()){
            dealerStay = true;
            if (dealerScore == 21 && dealerCardCount == 2) dealerBlackJack = true;
        }        
        
        if (playerBlackJack && dealerBlackJack){
            gameTied();
            return true;
        } else if (playerBlackJack && dealerStay){
            playerWin("You win!");
            return true;
        } else if (dealerBlackJack && playerStay){
            playerLose("You lose!");
            return true;
        } else if (playerStay && dealerStay && playerScore == dealerScore){
            gameTied();
            return true;
        } else if (playerStay && dealerStay && playerScore > dealerScore){
            playerWin("You win!");
            return true;
        } else if (playerStay && dealerStay && playerScore < dealerScore){
            playerLose("You lose!");
            return true;
        } else return false;
    }
    
    public void playerWin(String msg){
        dealer.showHiddenCards();
        form.AddToStatusBar("Your hand:");
        player.printHand();
        form.AddToStatusBar(dealer.getName()+"'s hand:");
        dealer.printHand();
        form.AddToStatusBar(msg);
        form.AddToStatusBar(dealer.getName()+" says: "+dealer.getLoseString()+"\n");
        player.changePoints(ante*player.getMultiplier());
    }
    
    public void playerLose(String msg){
        dealer.showHiddenCards();
        form.AddToStatusBar("Your hand:");
        player.printHand();
        form.AddToStatusBar(dealer.getName()+"'s hand:");
        dealer.printHand();
        form.AddToStatusBar(msg);
        form.AddToStatusBar(dealer.getName()+" says: "+dealer.getWinString()+"\n");
        player.changePoints(-ante);
    }
    
    public void gameTied(){
        form.AddToStatusBar("It's a tie!");
    }
    
    public boolean hit(){
        form.AddToStatusBar("You chose to hit.");
        form.AddToStatusBar("You chose to hit.");
        player.addCard(deck.dealCard());
        form.AddToStatusBar("Your hand:");
        player.printHand();
        if (roundOver()) return true;
        else if (dealerStay){
            form.AddToStatusBar(dealer.getName()+" stands with "+dealerScore+".\n");
            return roundOver();
        }
        else {
            do {
                form.AddToStatusBar(dealer.getName()+" chose to hit.");
                dealer.addCard(deck.dealCard());
                form.AddToStatusBar(dealer.getName()+"'s hand:");
                dealer.printHand();
            } while (playerStay || !roundOver());
            form.AddToStatusBar(dealer.getName()+" chose to stay.\n");
            return roundOver();
        }
    }
    
    public boolean stay(){
        form.AddToStatusBar("You chose to stay.\n");
        playerStay = true;
        if (roundOver()) return true;
        else {
            while (!roundOver()){
                form.AddToStatusBar(dealer.getName()+" chose to hit.");
                dealer.addCard(deck.dealCard());
                form.AddToStatusBar(dealer.getName()+"'s hand:");
                dealer.printHand();
            }
            return true;
        }
    }
    
    public boolean deal(){
        player.setupForGame();
        dealer.setupForGame();
        form.AddToStatusBarNoReturn("Player ");
        player.addCard(deck.dealCard());
        Card holeCard = deck.dealCard();
        holeCard.setHidden(true);
        form.AddToStatusBarNoReturn(dealer.getName()+" ");
        dealer.addCard(holeCard);
        form.AddToStatusBarNoReturn("Player ");
        player.addCard(deck.dealCard());
        form.AddToStatusBarNoReturn(dealer.getName()+" ");
        dealer.addCard(deck.dealCard());
        form.AddToStatusBar("\nYour hand:");
        player.printHand();
        form.AddToStatusBar(dealer.getName()+"'s hand:");
        dealer.printHand();
        return false;
        //return roundOver();
    }
    
    private GameCharacter initialize(int i){
        switch(i){
            case 1:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 2:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 3:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 4:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 5:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 6:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 7:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 8:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 9:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
            case 10:
                dealer = new GameCharacter("Example Guy " + i,"Example description.","You are the loser!","You are the winner!",17);
                ante = 20 * i;
                break;
                                                
            default:
                dealer = new GameCharacter("Example Guy","Example description.","You are the loser!","You are the winner!",17);
                ante = 20;
                break;
        }  
        return dealer;
    }
}
