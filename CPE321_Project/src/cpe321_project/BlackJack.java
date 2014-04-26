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
    private final mainForm form = mainForm.getInstance();
    
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
    private boolean roundOver(mainForm m){
        player.chargeAllItems(1);
        playerScore = player.getHandScore();
        dealerScore = dealer.getHandScore();
        
        if (playerScore > 21){
            playerLose("Bust! You lose!",m);
            return true;
        } else if (dealerScore > 21){
            playerWin(dealer.getName()+" busted! You win!",m);
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
            gameTied(m);
            return true;
        } else if (playerBlackJack && dealerStay){
            playerWin("You win!",m);
            return true;
        } else if (dealerBlackJack && playerStay){
            playerLose("You lose!",m);
            return true;
        } else if (playerStay && dealerStay && playerScore == dealerScore){
            playerLose("It was a tie! You keep your money!",m);
            return true;
        } else if (playerStay && dealerStay && playerScore > dealerScore){
            playerWin("You win!",m);
            return true;
        } else if (playerStay && dealerStay && playerScore < dealerScore){
            playerLose("You lose!",m);
            return true;
        } else return false;
    }
    
    public void playerWin(String msg, mainForm m){
        form.ClearStatusBar();
        dealer.showHiddenCards();
        m.DiplayAllHands();
        //form.AddToStatusBar("Your hand:");
        //player.printHand();
        //form.AddToStatusBar(dealer.getName()+"'s hand:");
        //dealer.printHand();
        form.AddToStatusBar(msg);
        form.AddToStatusBar(dealer.getName()+" says: "+dealer.getLoseString()+"\n");
        player.changePoints(ante*player.getMultiplier());
        m.handOver();
    }
    
    public void playerLose(String msg, mainForm m){
        form.ClearStatusBar();
        dealer.showHiddenCards();
        m.DiplayAllHands();
        //form.AddToStatusBar("Your hand:");
        //player.printHand();
        //form.AddToStatusBar(dealer.getName()+"'s hand:");
        //dealer.printHand();
        form.AddToStatusBar(msg);
        form.AddToStatusBar(dealer.getName()+" says: "+dealer.getWinString()+"\n");
        player.changePoints(-ante);
        m.handOver();
    }
    
    public void gameTied(mainForm m){
        m.DiplayAllHands();
        form.ClearStatusBar();
        form.AddToStatusBar("It was a tie, so you lose!");
        m.handOver();
    }
    
    public boolean hit(mainForm m){
        form.ClearStatusBar();
        //form.AddToStatusBar("You chose to hit.");
        //form.AddToStatusBar("You chose to hit.");
        player.addCard(deck.dealCard());
        m.DiplayAllHands();
        Boolean roundStatus = roundOver(m);
        //form.AddToStatusBar("Your hand:");
        //player.printHand();
        if (roundStatus) return true;
        else if (dealerStay){
            //form.AddToStatusBar(dealer.getName()+" chose to stay.\n");
            return roundStatus;
        }
        else {
            do {
                //form.AddToStatusBar(dealer.getName()+" chose to hit.");
                dealer.addCard(deck.dealCard());
                m.DiplayAllHands();
                roundStatus = roundOver(m);
                //form.AddToStatusBar(dealer.getName()+"'s hand:");
                //dealer.printHand();
            } while (!roundStatus && !dealerStay);
            //form.AddToStatusBar(dealer.getName()+" chose to stay.\n");
            return roundStatus;
        }
    }
    
    public boolean stay(mainForm m){
        form.ClearStatusBar();
        //form.AddToStatusBar("You chose to stay.\n");
        playerStay = true;
        if (roundOver(m)) return true;
        else {
            while (!roundOver(m)){
                //form.AddToStatusBar(dealer.getName()+" chose to hit.");
                dealer.addCard(deck.dealCard());
                m.DiplayAllHands();
                //form.AddToStatusBar(dealer.getName()+"'s hand:");
                //dealer.printHand();
            }
            return true;
        }
    }
    
    public boolean deal(mainForm m){
        //form.ClearStatusBar();
        deck.shuffleDeck();
        player.setupForGame();
        dealer.setupForGame();
        //form.AddToStatusBarNoReturn("Player ");
        player.addCard(deck.dealCard());
        m.DiplayAllHands();
        Card holeCard = deck.dealCard();
        m.DiplayAllHands();
        holeCard.setHidden(true);
        //form.AddToStatusBarNoReturn(dealer.getName()+" ");
        dealer.addCard(holeCard);
        m.DiplayAllHands();
        //form.AddToStatusBarNoReturn("Player ");
        player.addCard(deck.dealCard());
        m.DiplayAllHands();
        //form.AddToStatusBarNoReturn(dealer.getName()+" ");
        dealer.addCard(deck.dealCard());
        m.DiplayAllHands();
        //form.AddToStatusBar("\nYour hand:");
        //player.printHand();
        //form.AddToStatusBar(dealer.getName()+"'s hand:");
        //dealer.printHand();
        return false;
        //return roundOver();
    }
    
    private GameCharacter initialize(int i){
        switch(i){
            case 1:
                dealer = new GameCharacter("Frank ","Example description.","You are the loser!","You are the winner!",20);
                ante = (int)(20 * 1);
                break;
            case 2:
                dealer = new GameCharacter("Le Chiffre ","Example description.","You are the loser!","You are the winner!",17);
                ante = (int) (20 * 1.5);
                break;
            case 3:
                dealer = new GameCharacter("Spock ","Example description.","You are the loser!","You are the winner!",17);
                ante = (int) (20 * 2.5);
                break;
            case 4:
                dealer = new GameCharacter("Bubba ","Example description.","You are the loser!","You are the winner!",17);
                ante = (int)(20 * 3);
                break;
            case 5:
                dealer = new GameCharacter("Sarah ","Example description.","You are the loser!","You are the winner!",17);
                ante = (int)(20 * 3.5);
                break;
            case 6:
                dealer = new GameCharacter("Sheldon ","Example description.","You are the loser!","You are the winner!",17);
                ante = (int)(20*4);
                break;
            case 7:
                dealer = new GameCharacter("Arnold ","Example description.","You are the loser!","You are the winner!",17);
                ante = (int)(20 * 4.5);
                break;
            case 8:
                dealer = new GameCharacter("Obama ","Example description.","You are the loser!","You are the winner!",17);
                ante = (int)(20 * 5);
                break;
            case 9:
                dealer = new GameCharacter("Dr. Beard ","Example description.","You suck at this!","You won, but I am still going to fail you!",17);
                ante = (int)(20 *5.5);
                break;
            case 10:
                dealer = new GameCharacter("Example Guy ","Example description.","You are the loser!","You are the winner!",17);
                ante = (int)(20 * 8.0);
                break;
                                                
            default:
                dealer = new GameCharacter("Example Guy","Example description.","You are the loser!","You are the winner!",17);
                ante = 20;
                break;
        }  
        return dealer;
    }
}
