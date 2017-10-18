//Hossam
package online_monopoly;

import javax.swing.*;

public abstract class Property extends BoardObject {

    protected Player ownerPlayer;        // the player how own the Property
    protected int value;                 // the value of the property 
    protected int[] rent;                // all rent of the property (with and without houses and hotel)
    protected int mortgageValue;         // the value of mortgage
    protected boolean isMortgaged;       // the property is Mortgaged or not
    private int groupID;               // the id of the group of the property
    private int groubNum;              // the number of the porperties within this property 


    public Property(String name, int id, Point p, int value, int[] rent, int mortgageValue ,int groupID, int groubNum) {
        super(name, id, p);
        this.ownerPlayer = null;
        this.mortgageValue = mortgageValue;
        this.value = value;
        this.rent = rent;
        this.isMortgaged = false;
        this.groubNum =groubNum;
        this.groupID =groupID;
    }

    public Player getOwner() {
        return this.ownerPlayer;
    }

    public void setOwner(Player owner) {
        this.ownerPlayer = owner;
    }
        
    public int getPropertyValue(){
    return this.value;
    }
    
         public int getGroupID() {
        return this.groupID;
    }

    public int getGroupNum() {
        return this.groubNum;
    }


    // get the rent if the property had been  owned
    abstract public int getRent();

    // mortgage a property 
    public int mortgage() {
        // if the property is not Mortgaged
        if (this.isMortgaged == false) {
            this.isMortgaged = true;
            this.ownerPlayer.addMoney(this.mortgageValue);
            return 0;
        } else { // if the property is Mortgaged
            return 1;
        }

    }

    // redemption of the property from the bank 
    public int redemption() {
        // case 1 : if the property is Mortgaged and the player have the value of Mortgaged + 10 % 
        if (this.isMortgaged == true) {
            double value = this.mortgageValue + this.mortgageValue * .1;

            if (this.ownerPlayer.getMoney() >= value) {
                this.isMortgaged = false;
                this.ownerPlayer.payMoney((int) value);
                return 0;
            } // case 2 : if the property is Mortgaged and the player dont have the value of Mortgaged + 10 % return 1
            else {
                return 1;
            }

        } // case 3 : if if the property is not Mortgaged return 2
        else {
            return 2;
        }

    }
    
                   
}

class NormalProperty extends Property{
    private int houseValue;            // the house or hotel value
    private int numOfHouses;           // the number of houses on the property (0 - 4)
    private int numOfHotels;           // the number of hotels on the property (0 - 1)
  
    public NormalProperty(String name, int id, Point p,int value,int[] rent,int mortgageValue ,int groupID, int groubNum, int houseValue) {
        super(name, id, p, value, rent, mortgageValue ,groupID, groubNum);
        this.houseValue = houseValue;
        this.numOfHouses = numOfHouses;
        this.numOfHotels = numOfHotels;

    }

    public int getNumOfHouses() {
        return this.numOfHouses;
    }

    public int getNumOfHotels() {
        return this.numOfHotels;
    }
        public int getHouseValue(){
    return this.houseValue;
    }
        
        
            // get the rent if the property had been  owned
    public int getRent() {
        if (this.ownerPlayer != null && this.isMortgaged == false) {  // if the property is owned and not Mortgaged
            if (numOfHotels == 0) {
                switch (this.numOfHouses) {
                    case 0:// if the property have no houses
                        if (this.ownerPlayer.checkGroup(this) == true) {
                            return this.rent[0] * 2;
                        } else {
                            return this.rent[0];
                        }
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
    public int buildHouse() {
        // check if the propery is not Mortgaged
        if (this.isMortgaged == true) {
            return 1;
        } // check if the player have the property group 
        else if (this.ownerPlayer.checkGroup(this) == false) {
            return 2;
        } // check the number of houses and hotels //and check if the bank have enough houses    
        else {
            if (numOfHouses > 4 && numOfHotels == 0) {
                numOfHotels++;
            } else if (numOfHotels == 4) {
                numOfHotels = 0;
                numOfHotels = 1;
            } else if (numOfHotels == 1) {
                return 3; // return that you cant build her any more
            }
            return 0;
        }
    }
    
}

class Railroad extends Property{

    public Railroad(String name, int id, Point p, int value, int[] rent, int mortgageValue ,int groupID, int groubNum) {
      super(name, id, p, value, rent, mortgageValue ,groupID, groubNum);
    }
    
    public int getRent (){
    return 0 ;
    }



}

class WaterworksOrElectric extends Property {


  public WaterworksOrElectric(String name, int id, Point p, int value, int[] rent, int mortgageValue ,int groupID, int groubNum) {
      super(name, id, p, value, rent, mortgageValue ,groupID, groubNum);
    }

  public int getRent(){
      return 0 ;
  }
}
