
package blackjack;

public class Player {
   public boolean playerwin=false;
    public String name;
    int score=0;
    Card cards[] = new Card[11];
    int counter=0;
    void setScore(Card card){
        if (counter <11 ) {
           cards[counter]= card;
           counter++;
           score += card.getValue();
        
        }}
    public String getName() {
        return name;}
    public int getScore() {
        return score;}
    public Card[] getCards() {
        return cards;}}