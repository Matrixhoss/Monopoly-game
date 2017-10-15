//Hossam
package online_monopoly;


public class Property extends BoardObject {

    private int groupID;               // the id of the group of the property
    private Player ownerPlayer;        // the player how own the Property
    private Player standingPlayer;     //the player how stand on the Property
    private int[] rent;                // all rent of the property (with and without houses and hotel)
    private char numOfHouses;          // the number of houses on the property (0 - 4)
    private char numOfHotels;          // the number of hotels on the property (0 - 1)
    private int mortgageValue ;        // the value of mortgage
    private boolean isMortgaged ;      // the property is Mortgaged or not

    public Property(String name, int id, int groupID, Point p, int[] rent,int mortgageValue) {
        super(name, id, p);
        this.groupID = groupID;
        this.ownerPlayer = null;
        this.standingPlayer = null;
        this.mortgageValue = mortgageValue;
        this.numOfHotels = 0;
        this.numOfHotels = 0;
        this.isMortgaged = false;
    }

    
    public Player getOwner() {  
        return this.ownerPlayer;
    }

    public void setOwner(Player owner) {
        this.ownerPlayer = owner;
    }
    
    // get the rent if the property had been  owned
    public int getRent() {
        if(this.ownerPlayer != null && this.isMortgaged == false){  // if the property is owned and not Mortgaged
        if (numOfHotels == 0) {
            switch (this.numOfHouses) {
                case 0:
                    return this.rent[0]; // if the property have no houses
                case 1:
                    return this.rent[1]; // if the property have 1 houses
                case 2:
                    return this.rent[2]; // if the property have 2 houses
                case 3:
                    return this.rent[3]; // if the property have 3 houses
                case 4:
                    return this.rent[4]; // if the property have 4 houses
            }
        } else if (numOfHotels == 1) {
            return this.rent[5];         // if the property have a hotel
        }
        }
        return 0;
        
    }
    
    // not completed
    
    public void buildHouse(){
   if(this.isMortgaged == true ) return ;     
    // check the number of houses and hotels //and check if the bank have enough houses    
    if(numOfHouses>4 && numOfHotels == 0){
    numOfHotels ++ ;
    }
    else if (numOfHotels == 4){
    numOfHotels = 0 ;
    numOfHotels = 1  ; 
    }
    }
    
    public void mortgage (){
    if (this.isMortgaged == false){
    this.isMortgaged = true ;
    // Player.setMoney(this.mortgageValue)
    }
    else{
    //show message that the property is mortgaged
    }
    
    }
    
    public void redemption (){
    
    
    }
}
