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

    public Property(String name, int id, Point p, int value, int[] rent, int mortgageValue, int groupID, int groubNum) {
        super(name, id, p);
        this.ownerPlayer = null;
        this.mortgageValue = mortgageValue;
        this.value = value;
        this.rent = rent;
        this.isMortgaged = false;
        this.groubNum = groubNum;
        this.groupID = groupID;
    }

    public Player getOwner() {
        return this.ownerPlayer;
    }

    public void setOwner(Player owner) {
        this.ownerPlayer = owner;
    }

    public int getPropertyValue() {
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

class NormalProperty extends Property {

    private int houseValue;            // the house or hotel value
    private int numOfHouses;           // the number of houses on the property (0 - 4)
    private int numOfHotels;           // the number of hotels on the property (0 - 1)

    public NormalProperty(String name, int id, Point p, int value, int[] rent, int mortgageValue, int groupID, int groubNum, int houseValue) {
        super(name, id, p, value, rent, mortgageValue, groupID, groubNum);
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

    public int getHouseValue() {
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

class Railroad extends Property {

    public Railroad(String name, int id, Point p, int value, int[] rent, int mortgageValue, int groupID, int groubNum) {
        super(name, id, p, value, rent, mortgageValue, groupID, groubNum);
    }

    public int getRent() {
        return 0;
    }

}

class WaterworksOrElectric extends Property {

    public WaterworksOrElectric(String name, int id, Point p, int value, int[] rent, int mortgageValue, int groupID, int groubNum) {
        super(name, id, p, value, rent, mortgageValue, groupID, groubNum);
    }

    public int getRent() {
        int rent = 0;
        if (this.ownerPlayer != null && this.isMortgaged == false) {
        if (this.ownerPlayer.checkGroup(this) == true) {
            rent = (this.ownerPlayer.getDice()[0] + this.ownerPlayer.getDice()[1]) * 10;
        } else {
            rent = (this.ownerPlayer.getDice()[0] + this.ownerPlayer.getDice()[1]) * 4;
        }
          }
        return rent;
    }
}

class Jail extends BoardObject {

    private Player p = Mainboard_GUI.p;
    private Dice d = Mainboard_GUI.d;
    private CommunityAndChance CC = Mainboard_GUI.CC;

    public Jail(String name, int id, Point p) {
        super(name, id, p);
    }

    public void handleJail(int Choice) {                //0=pay 50  1=try your luck and roll   2=use card
        d.disableRolling();
        switch (Choice) {
            case 0:
                p.payMoney(50);
                p.exitFromJail();
                break;
            case 1:
                d.enableRolling();
                break;
            case 2:
                if (p.hasChanceCard() && !p.hasCommunityCard()) {
                    CC.ReturnChanceJail();
                } else if (!p.hasChanceCard() && p.hasCommunityCard()) {
                    CC.ReturnChestJail();
                } else if (p.hasChanceCard() && p.hasCommunityCard()) {
                    CC.ReturnChestJail();
                }
                p.exitFromJail();
                break;
        }

    }
}

class Tax extends BoardObject {

    private Player p = Mainboard_GUI.p;
    private Dice d = Mainboard_GUI.d;
    private CommunityAndChance CC = Mainboard_GUI.CC;

    public Tax(String name, int id, Point p) {
        super(name, id, p);
    }

    public void handleLuxTax() {    //Function should receive an integer from the choice of the option panal
        p.payMoney(100);
    }

    public void handleIncomeTax(int Choice) {
        if (Choice == 0) {
            p.payMoney(200);
        } else {
            Double d = p.getTotalMoney() * 0.1;
            int P = d.intValue();
            p.payMoney(P);
        }

    }

}
