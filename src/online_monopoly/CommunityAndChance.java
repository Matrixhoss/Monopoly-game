/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdelrahman Ossama
 */

class Card
	{
		public int type;
		public String label;
                public int ammount = 0;
                public Point p;
                public boolean used=false;
                

		public Card(int cardtype, String cardname)
		{
			type = cardtype;  // 1 = pay,get, 3=goto, 4=return, 5=out of jail, 2 go to jail, 6 get from all, 7 repairs chance, 8 repair comm
			label = cardname;
		}
                public Card(int cardtype, String cardname, int ammount2)
		{
			type = cardtype;  
			label = cardname;
                        ammount=ammount2;
		}
                public Card(int cardtype, String cardname, Point p2)
		{
			type = cardtype;  
			label = cardname;
                        p=p2;
		}
                
	}

public class CommunityAndChance{
    
    ArrayList<Card> ChanceCards;
    ArrayList<Card> ChestCards;
    Hashtable<String, Player> players;
    String[] playerNames;
    
    public CommunityAndChance(Hashtable<String, Player> ps,String[] pNames){
        this.players=ps;
        this.playerNames=pNames;
        ChanceCards = new ArrayList<Card>();
        ChestCards = new ArrayList<Card>();
        
        // 1 = pay,get, 3=goto, 4=return, 5=out of jail
        ChanceCards.add(new Card(1,"Bank pays you dividend of $50",50));
        ChanceCards.add(new Card(1,"Pay poor tax of $15",-15));
        ChanceCards.add(new Card(1,"our building {and} loan matures – Collect $150",150));
        ChanceCards.add(new Card(1,"You have won a crossword competition - Collect $100",100));
        ChanceCards.add(new Card(5,"Get out of Jail Free – This card may be kept until needed, or traded/sold"));
        ChanceCards.add(new Card(2,"Go to Jail"));
        ChanceCards.add(new Card(7,"Make general repairs on all your property – For each house pay $25 – For each hotel $100"));
        ChanceCards.add(new Card(3,"Advance to Illinois Ave. - If you pass Go, collect $200",new Point(6,10)));
        ChanceCards.add(new Card(3,"Advance to Go (Collect $200)",new Point(0,0)));
        ChanceCards.add(new Card(3,"Advance to St. Charles Place – If you pass Go, collect $200",new Point(6,10)));
        ChanceCards.add(new Card(4,"Go Back 3 Spaces"));
        ChanceCards.add(new Card(3,"Take a trip to Reading Railroad",new Point(5,0)));
        ChanceCards.add(new Card(3,"Take a walk on the Boardwalk ",new Point(0,1)));
        ChanceCards.add(new Card(3,"Advance to St. Charles Place – If you pass Go, collect $200",new Point(6,10)));
        ChanceCards.add(new Card(6,"You have been elected Chairman of the Board – Pay each player $50",-50));
        

        
        //ChanceCards.add(new Card(5,"Get out of Jail Free – This card may be kept until needed, or traded/sold\n"));
        
        ChestCards.add(new Card(1,"Bank error in your favor – Collect $200",200));
        ChestCards.add(new Card(1,"Doctor's fees {fee} – Pay $50",-50));
        ChestCards.add(new Card(1,"From sale of stock you get $50",50));
        ChestCards.add(new Card(1,"Holiday {Xmas} Fund matures - Receive {Collect} $100",100));
        ChestCards.add(new Card(1,"Income tax refund – Collect $20",20));
        ChestCards.add(new Card(1,"Life insurance matures – Collect $100",100));
        ChestCards.add(new Card(1,"Pay hospital fees of $100",-100));
        ChestCards.add(new Card(1,"Pay school fees {tax} of $150",150));
        ChestCards.add(new Card(1,"You have won second prize in a beauty contest – Collect $10",10));
        ChestCards.add(new Card(1,"You inherit $100",100));
        ChestCards.add(new Card(1,"Receive $25 consultancy fee",25));
        ChestCards.add(new Card(3,"Advance to Go (Collect $200)",new Point(0,0)));
        ChestCards.add(new Card(5,"Get out of Jail Free – This card may be kept until needed, or traded/sold"));
        ChestCards.add(new Card(2,"Go to Jail"));
        ChestCards.add(new Card(8,"You are assessed for street repairs – $40 per house – $115 per hotel"));
        ChestCards.add(new Card(6,"It is your birthday - Collect $10 from each player {Not in the deck",10));
        
        Collections.shuffle(ChanceCards);
        Collections.shuffle(ChestCards);
        
        //void RandomChance(){
        /*
    Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled.
      */
        
        
   // }
   // void RandomChest(){
        /*
}
  */
// }
        
        
            
    }
    
    public String DrawCardPrint(String type,int currentPlayer){
        Player hassan=players.get(playerNames[currentPlayer]);
        return this.DrawCardPrint(type,hassan, false, currentPlayer);         
    }
    
    public void ReturnChanceJail(){
        Card e = new Card(5,"Get Out of Jail Free");
        ChanceCards.add(e);
    }
    public void ReturnChestJail(){
        Card e = new Card(5,"Get Out of Jail Free");
        ChestCards.add(e);
    }
    
    public String DrawCardPrint(String type, Player hassan, boolean print, int currentPlayer){
        Card s;
        if(type.equalsIgnoreCase("chance")){
            s = ChanceCards.get(0);
            ChanceCards.remove(0);
            if(s.type==5){
            hassan.addChanceCard(true);
            }
            ChanceCards.add(s);
        }
        
        else if(type.equalsIgnoreCase("chest")){
            s = ChestCards.get(0);
            ChestCards.remove(0);
            if(s.type==5){
            hassan.addChanceCard(true);
            return "#sos123";
            }
            ChestCards.add(s);
        }
        else
            //error
            return "#sba7elfol213";
        
        // check for the chance/community card type and take corresponding action
        // 1 = pay,get, 3=goto, 4=return, 5=out of jail, 2 go to jail, 6 get from all, 7 repairs chance, 8 repair comm
        switch (s.type) {
            case 1:
                hassan.addMoney(s.ammount);
                break;
            case 2:
                hassan.goToJail();
                break;
            case 3:
                hassan.setPosition(s.p.getX(), s.p.getY());
                break;
            case 4:
                hassan.moveBack(3);
                break;
            case 6:
                // get money from all players somehow.
                for(int i=0;i<playerNames.length;i++){
                    if(currentPlayer != i){
                        Player otherplayer =players.get(playerNames[i]);
                        otherplayer.addMoney(-s.ammount);
                        hassan.addMoney(s.ammount);
                    }
                        
                }
                break;
            case 7:
                hassan.payMoney(25*hassan.getTotalHouses());
                hassan.payMoney(100*hassan.getTotalHotels());
                break;
            case 8:
                hassan.payMoney(40*hassan.getTotalHouses());
                hassan.payMoney(115*hassan.getTotalHotels());
                break;
            default:
                break;
        }
        //here should call the class which will draw gui for card.
        
        return s.label;
    }
    
    
    
    
}
