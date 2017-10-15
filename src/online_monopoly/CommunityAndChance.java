/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.util.ArrayList;
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
			type = cardtype;  // 1 = pay get, 3=goto, 4=return, 5=out of jail
			label = cardname;
		}
                public Card(int cardtype, String cardname, int ammount2)
		{
			type = cardtype;  // 1 = payget, 3=goto, 4=return, 5=out of jail
			label = cardname;
                        ammount=ammount2;
		}
                public Card(int cardtype, String cardname, Point p2)
		{
			type = cardtype;  // 1 = pay,get, 3=goto, 4=return, 5=out of jail
			label = cardname;
                        p=p2;
		}
                
	}

public class CommunityAndChance{
    
    ArrayList<Card> ChanceCards;
    ArrayList<Card> ChestCards;
    
    
    
    public CommunityAndChance(){
        
        ChanceCards = new ArrayList<Card>();
        ChestCards = new ArrayList<Card>();
        
        // 1 = pay,get, 3=goto, 4=return, 5=out of jail
        ChanceCards.add(new Card(1,"Bank pays you dividend of $50",50));
        ChanceCards.add(new Card(1,"Pay poor tax of $15",-15));
        ChanceCards.add(new Card(1,"our building {and} loan matures – Collect $150",150));
        ChanceCards.add(new Card(1,"You have won a crossword competition - Collect $100",100));
        //ChanceCards.add(new Card(5,"Get out of Jail Free – This card may be kept until needed, or traded/sold\n"));
        
        ChestCards.add(new Card(1,"Bank error in your favor – Collect $200",200));
        ChestCards.add(new Card(1,"Doctor's fees {fee} – Pay $50",-50));
        ChestCards.add(new Card(1,"From sale of stock you get $50",50));
        ChestCards.add(new Card(1,"Holiday {Xmas} Fund matures - Receive {Collect} $100",100));
        ChestCards.add(new Card(1,"HIncome tax refund – Collect $20",20));
        ChestCards.add(new Card(1,"Life insurance matures – Collect $100",100));
        ChestCards.add(new Card(1,"Pay hospital fees of $100",-100));
        ChestCards.add(new Card(1,"Pay school fees {tax} of $150",150));
        ChestCards.add(new Card(1,"You have won second prize in a beauty contest – Collect $10",10));
        ChestCards.add(new Card(1,"You inherit $100",100));
        ChestCards.add(new Card(1,"Receive $25 consultancy fee",25));
        
        
            
    }
    public void DrawCard(String type, Player hassan){
        this.DrawCard(type,hassan, false);        
    }
    
    public void DrawCard(String type, Player hassan, boolean print){
        
        
        Random r = new Random();
        Card s = new Card(0,"0");
        if(type.equalsIgnoreCase("chance")){
            int cardid = r.nextInt(ChanceCards.size());
            s = ChanceCards.get(cardid);
            
                    
        }
        
        else if(type.equalsIgnoreCase("chest")){
            r.ints(ChestCards.size());
            int cardid = r.nextInt(ChanceCards.size());
            s = ChanceCards.get(cardid);
        }
        else return;
        
        if(s.type==1){
            hassan.addMoney(s.ammount);
            JOptionPane.showMessageDialog(null, s.label);
        }
    }
    
    //void RandomChance(){
        /*Advance to Go (Collect $200)
Advance to Illinois Ave. - If you pass Go, collect $200 
Advance to St. Charles Place – If you pass Go, collect $200 
Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled.

Go Back 3 Spaces
Go to Jail – Go directly to Jail – Do not pass Go, do not collect $200
Make general repairs on all your property – For each house pay $25 – For each hotel $100 

Take a trip to Reading Railroad {Take a ride on the Reading} – If you pass Go, collect $200 
Take a walk on the Boardwalk 
You have been elected Chairman of the Board – Pay each player $50  */
   // }
   // void RandomChest(){
        /*Advance to Go (Collect $200) <Mr. M strides in 7-league boots>
Get Out of Jail Free {Get out of Jail, Free} – This card may be kept until needed or sold <A winged Mr. M flutters out of a bird cage>
Go to Jail – Go directly to jail – Do not pass Go – Do not collect $200 <A truncheon-wielding policeman in a light-colored uniform lifts a surprised Mr M by the collar>
Grand Opera Night {Opening} – Collect $50 from every player for opening night seats <A wall sign near steps reads "Opera Tonite - 8 PM Sharp"; Mr. M leans against it checking his pocket watch in annoyance>
It is your birthday - Collect $10 from each player {Not in the deck}
You are assessed for street repairs – $40 per house – $115 per hotel <Mr. M., supported by his near-ubiquitous cane in his left hand, holds a pick and shovel over his right shoulder>
  */
// }
    
}
