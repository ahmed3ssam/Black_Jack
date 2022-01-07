package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public int validScores[];
    public Player player[] = new Player[4];
    public Card deck[] = new Card[52];
    int highScore;
    public Game() 
    {this.validScores = new int[4];} 
    public void Deck(){
        for(int i=0; i < 4; i++){
           for(int j=0; j < 13; j++){
              if(j > 9)
              {highScore = 10;}
              else
              {highScore = j++;}
              deck[i*13 + j] = new Card(i, j,highScore);}}}
     public Card draw(){
        Random rand = new Random();
        int randomCard;
        do{randomCard = rand.nextInt(52);}
        while(null == deck[randomCard]);
        Card returedCard = deck[randomCard];
        deck[randomCard] = null;
        return returedCard;}
    
     public void setplayer(){
         Scanner scaner = new Scanner(System.in);
         for (int i = 0; i < player.length - 1; i++) {
             System.out.println("Enter Name of Player " +(i +1 )+ " : " );
             player[i]= new Player();
             player[i].name=scaner.next();
             player[i].setScore(this.draw());
             player[i].setScore(this.draw());}
         player[3]= new Player();
         player[3].name="Dealr";
         player[3].setScore(this.draw());
         player[3].setScore(this.draw());} 
    public void updateGameScores (){
        for (int i = 0; i < validScores.length; i++) {
            if(player[i].score <= 21)
          {validScores[i] = player[i].score;}
         else
            {validScores[i]=0;}}}}