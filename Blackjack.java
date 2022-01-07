package blackjack;
import java.util.Scanner;
public class Blackjack {
  static Game game = new Game();
    public static void main(String[] args) {
       GUI gui = new GUI();
       game.Deck();
       game.setplayer();
       gui.runGUI( game.deck,game.player[0].getCards(),game.player[1].getCards(),game.player[2].getCards(),game.player[3].getCards());
        Player_Turn(gui);
        game.updateGameScores();
        Dealer_Turn(gui);
        game.updateGameScores();
        check();}
 public static void Player_Turn(GUI gui){
         Scanner scaner = new Scanner(System.in);
         for (int i = 0; i < game.player.length -1; i++) {
            String input ="hit";
            while(!input.toLowerCase().equals("stand")){
                System.out.println("player number "+(i+1)+ " Choose hit || stand");
               
                input=scaner.next();
               
                if(!input.toLowerCase().equals("stand")){
                 add_card_player(i,gui);}
              if(game.player[i].getScore()>=21)
                {
                    break;
              }
               
             System.out.println(game.player[i].getScore());
            }
         
         }
 
 
 }     

 public static void add_card_player(int index,GUI gui){
        Card card =game.draw();
        game.player[index].setScore(card);
        gui.updatePlayerHand(card, index);} 
 public static void Dealer_Turn(GUI gui){
     boolean win =true ;
     int highscore=0;
     for (int i = 0; i < game.player.length -1 ; i++) {
       if(game.validScores[i]>= game.player[3].score){
          win=false;
      } 
       if(game.validScores[i]>highscore ){
           highscore = game.validScores[i];}}
        if(win){return;} 
     else{add_Dealr(gui,highscore);}}
 public static void add_Dealr(GUI gui,int highscore){
     while(game.player[3].score < highscore){
        Card card =game.draw();
        game.player[3].setScore(card);
        gui.updateDealerHand(card, game.deck);}}
 public static void check(){
     int high =0;
     int win =-1;
     int cnt =0;
     for (int i = 0; i < game.player.length ; i++) {
      if (game.validScores[i] > high){
          high=game.validScores[i];
          win=i;
      cnt++;
      }
      
     }
     if (cnt>1)
     {System.err.println("Push");}
     else 
         
     {System.out.println("The Winner is "+ game.player[win].name);}
}}
