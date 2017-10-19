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

    public boolean haveOwner() {
        return this.ownerPlayer != null;
    }

    public int buyProperty(Player p) {

        if (this.checkOwnerPlayerMoney(this.value)) {
            this.setOwner(p);
            return 0;
        }
        return 1; // the player dont have the value of property
    }

    public boolean checkOwner(Player p) {
        return p.equals(this.ownerPlayer);
    }

    // get the rent if the property had been  owned
    abstract public int getRent(Player stopingPlayer);

    // mortgage a property 
    public int mortgage() {
        // if the property is not Mortgaged
        if (this.isMortgaged == false) {
            this.isMortgaged = true;
            this.ownerPlayer.addMoney(this.mortgageValue);
            System.out.println(" Mortgaged");
            return 0;
        } else { // if the property is Mortgaged
            System.out.println("the property is aready Mortgaged");
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

    // the function to check if the player have the this value of money or not 
    public boolean checkOwnerPlayerMoney(int value) {
        if (this.ownerPlayer.getMoney() < value) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkOwnerPlayerAllMoney(int value) {
        if (this.ownerPlayer.getTotalMoney() < value) {
            return false;
        } else {
            return true;
        }
    }

    public void doInStop(Player stopingPlayer) {
        if (this.ownerPlayer == null) {

        } else {
            getRent(stopingPlayer);
        }
    }

    //pay the rent 
    public int rent(Player stopingPlayer) {
        // get the rent value from property 
        int rent = getRent(stopingPlayer);
        // check if the player have a money to pay
        if (this.checkOwnerPlayerMoney(rent)) {
            stopingPlayer.payMoney(rent);
            stopingPlayer.setNoMoney(false);
            return 0; // success
            // check if the player have properties or houses or hotels can sell or mortgage
        } else if (this.checkOwnerPlayerAllMoney(rent)) {
            stopingPlayer.setNoMoney(true); // set the flag true and make player sell sell or mortgage
            return 1;// the player must sell houses or mortgage a property 
        } else {
            return 2; // the player is lose
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
        this.numOfHouses = 0;
        this.numOfHotels = 0;

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
    public int getRent(Player stopingPlayer) {
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

    //completed with testing
    //<editor-fold defaultstate="collapsed" desc="Build and sell houses or hotels">
    public int buildHouse(Bank b) {
        // check if the propery is not Mortgaged
        if (this.isMortgaged == true) {
            return 1; // the property is Mortgaged
        } // check if the player have the property group 
        else if (this.ownerPlayer.checkGroup(this) == false) {
            return 2; // the the player have not the property group 
        } // check the number of houses and hotels //and check if the bank have enough houses    
        else {
            if (numOfHouses < 4 && numOfHotels == 0) {
                if (this.checkOwnerPlayerMoney(houseValue)) {
                    if (b.areHousesAvailable(1) == true) {
                        if (this.checkCanBuildHouse(this.numOfHouses)) {
                            numOfHouses++;
                            b.buyHouse();
                            this.ownerPlayer.payMoney(houseValue);
                        } else {
                            return 7; // the other player properties in the same groub dont have the same number of houses 
                        }
                    } else {
                        return 5; // the bank have not more houses 
                    }

                } else {
                    return 3; // the player have not the value of house or hotel
                }
            } else if (numOfHouses == 4) {
                if (this.checkOwnerPlayerMoney(houseValue)) {
                    if (b.areHotelsAvailable(1) == true) {
                        if (this.checkCabBuildHotel()) {
                            this.numOfHouses = 0;
                            b.sellHouse();
                            b.sellHouse();
                            b.sellHouse();
                            b.sellHouse();
                            this.numOfHotels = 1;
                            b.buyHotel();
                            this.ownerPlayer.payMoney(houseValue);

                        } else {
                            return 7;  // the other player properties in the same groub dont have the same number of houses or hotels
                        }
                    } else {

                        return 6; // the bank have no more hotels
                    }

                } else {

                    return 3;  // the player have not the value of house or hotel
                }
            } else if (numOfHotels == 1) {

                return 4; // return that you cant build her any more
            }

            return 0; // success
        }
    }

    public boolean checkCanBuildHouse(int numOfHouses) {
        NormalProperty n;
        boolean check = true;
        for (int i = 0; i < this.ownerPlayer.getPropertiesInGroup(this).size(); i++) {
            n = (NormalProperty) this.ownerPlayer.getPropertiesInGroup(this).get(i);
            if (n.getNumOfHouses() < numOfHouses) {
                check = false;
            }
        }
        return check;
    }

    public boolean checkCabBuildHotel() {
        NormalProperty n;
        boolean check = true;
        for (int i = 0; i < this.ownerPlayer.getPropertiesInGroup(this).size(); i++) {
            n = (NormalProperty) this.ownerPlayer.getPropertiesInGroup(this).get(i);
            if (!(n.getNumOfHouses() == 4 || n.getNumOfHotels() == 1)) {
                check = false;
            }

        }
        return check;
    }

    public int sellHouse(Bank b) {
        if (this.numOfHouses > 0) {
            this.numOfHouses--;
            b.sellHouse();
            this.ownerPlayer.addMoney(houseValue / 2);
            System.out.println("Success sell house Number of houses = " + this.numOfHouses + " Number of hotels = " + this.numOfHotels + " PlayerMoney = " + this.ownerPlayer.getMoney());
            return 0; // success
        } else if (this.numOfHotels > 0) {
            // frist check the bank aviabalte of houses
            if (b.areHousesAvailable(4) == true) {
                this.numOfHotels = 0;
                b.sellHotel();
                this.numOfHouses = 4;
                b.buyHouse();
                b.buyHouse();
                b.buyHouse();
                b.buyHouse();
                this.ownerPlayer.addMoney(houseValue / 2);
                System.out.println("Success sell hotel Number of houses = " + this.numOfHouses + "Number of hotels = " + this.numOfHotels + " PlayerMoney = " + this.ownerPlayer.getMoney());

                return 0; // success
            } else {
                System.out.println("The banke have not more houses to replace the hotel");
                return 2; // the bank have not the houses to replace the hotel
            }
        } else {
            System.out.println("The player dont have houses or hotels");
            return 1; // the player dont have houses or hotels 
        }
    }
//</editor-fold>
}

class Railroad extends Property {

    public Railroad(String name, int id, Point p, int value, int[] rent, int mortgageValue, int groupID, int groubNum) {
        super(name, id, p, value, rent, mortgageValue, groupID, groubNum);
    }

    public int getRent(Player stopingPlayer) {
        int rent = 0;
        if (this.ownerPlayer != null && this.isMortgaged == false) {  // if the property is owned and not Mortgaged
            rent = this.rent[0] * this.ownerPlayer.getNumOfPropertiesInGroup(this);
        }
        return rent;
    }

}

class WaterworksOrElectric extends Property {

    public WaterworksOrElectric(String name, int id, Point p, int value, int[] rent, int mortgageValue, int groupID, int groubNum) {
        super(name, id, p, value, rent, mortgageValue, groupID, groubNum);
    }

    public int getRent(Player stopingPlayer) {
        int rent = 0;
        if (this.ownerPlayer != null && this.isMortgaged == false) {
            if (this.ownerPlayer.checkGroup(this) == true) {
                rent = (stopingPlayer.getDice()[0] + stopingPlayer.getDice()[1]) * 10;
            } else {
                rent = (stopingPlayer.getDice()[0] + stopingPlayer.getDice()[1]) * 4;
            }
        }
        return rent;
    }
}

class Jail extends BoardObject {

//    private Player p = Mainboard_GUI.p;
//    private Dice d = Mainboard_GUI.d;
//    private CommunityAndChance CC = Mainboard_GUI.CC;
    public Jail(String name, int id, Point p) {
        super(name, id, p);
    }

    public void handleJail(int Choice, Player p, CommunityAndChance CC, Dice d) {                //0=pay 50  1=try your luck and roll   2=use card
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

    public Tax(String name, int id, Point p) {
        super(name, id, p);
    }

    public void handleLuxTax(Player p) {    //Function should receive an integer from the choice of the option panal
        p.payMoney(100);
    }

    public void handleIncomeTax(Player p, int Choice) {
        if (Choice == 0) {
            p.payMoney(200);
        } else {
            Double d = p.getTotalMoney() * 0.1;
            int P = d.intValue();
            p.payMoney(P);
        }

    }

}
