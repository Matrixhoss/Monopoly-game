//Hossam
package online_monopoly;

import javax.swing.*;

//<editor-fold defaultstate="collapsed" desc="Property class">
public abstract class Property extends BoardObject {

    public Player ownerPlayer;        // the player how own the Property
    protected int value;                 // the value of the property 
    protected int[] rent;                // all rent of the property (with and without houses and hotel)
    protected int mortgageValue;         // the value of mortgage
    protected boolean isMortgaged;       // the property is Mortgaged or not
    private final int groupID;               // the id of the group of the property
    private final int groubNum;              // the number of the porperties within this property 

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

    //<editor-fold defaultstate="collapsed" desc="setters and geters">
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
        public String getPropertyName() {
        return this.name;
    }
    

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="buy property">
    public boolean haveOwner() {
        return this.ownerPlayer != null;
    }

    public int buyProperty(Player p) {

        if (this.checkStopingPlayerAllMoney(p, this.value)) {
            this.setOwner(p);
            return 0;
        }
        return 1; // the player dont have the value of property
    }

    public boolean checkOwner(Player p) {
        return p.equals(this.ownerPlayer);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="mortgage">
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="check player money and total money">
    // the function to check if the player have the this value of money or not 
    public boolean checkOwnerPlayerMoney(int value) {
        if (this.ownerPlayer.getMoney() < value) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkStopingPlayerMoney(Player stopingPlayer, int value) {
        if (stopingPlayer.getMoney() < value) {
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

    public boolean checkStopingPlayerAllMoney(Player stopingPlayer, int value) {
        if (stopingPlayer.getTotalMoney() < value) {
            return false;
        } else {
            return true;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Rent">
    //pay the rent 
    public int payRent(Player stopingPlayer) {
        // get the rent value from property 
        int rent = getRent(stopingPlayer);
        // check if the player have a money to pay
        if(this.ownerPlayer.equals(stopingPlayer)){
        return 0 ; 
        }
        if (this.checkStopingPlayerMoney(stopingPlayer, rent)) {
            stopingPlayer.payMoney(rent);
            this.ownerPlayer.addMoney(rent);
            stopingPlayer.setNoMoney(false);
            return 0; // success
            // check if the player have properties or houses or hotels can sell or mortgage
        } else if (this.checkStopingPlayerAllMoney(stopingPlayer, rent)) {
            stopingPlayer.setNoMoney(true); // set the flag true and make player sell sell or mortgage
            return 1;// the player must sell houses or mortgage a property 
        } else {
            return 2; // the player is lose
        }
    }
    // get the rent if the property had been  owned

    abstract public int getRent(Player stopingPlayer);
    //</editor-fold>
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="NormalProperty class">
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

    //<editor-fold defaultstate="collapsed" desc="setters and geters">
    public int getNumOfHouses() {
        return this.numOfHouses;
    }

    public int getNumOfHotels() {
        return this.numOfHotels;
    }

    public int getHouseValue() {
        return this.houseValue;
    }
//</editor-fold>

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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Railroad class">
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="WaterworksOrElectric class">
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Jail class">
class Jail extends BoardObject {

//    private Player p = Mainboard_GUI.p;
//    private Dice d = Mainboard_GUI.d;
//    private CommunityAndChance CC = Mainboard_GUI.CC;
    public Jail(String name, int id, Point p) {
        super(name, id, p);
    }

    

    
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tax class">
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="PropertyStander Class">
class PropertyStander {

    // Names 
    //<editor-fold defaultstate="collapsed" desc="Groups">
    final public static int BrownGroup = 1;
    final public static int LightBlueGroup = 2;
    final public static int RozeGroup = 3;
    final public static int OrangeGroup = 4;
    final public static int RedGroup = 5;
    final public static int YelloGroup = 6;
    final public static int GreenGroup = 7;
    final public static int BlueGroup = 8;
    final public static int RailRoadGroup = 9;
    final public static int WaterElectricGroup = 10;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Groups (Number of properties in group)">
    final public static int BrownGroupNum = 2;
    final public static int LightBlueGroupNum = 3;
    final public static int RozeGroupNum = 3;
    final public static int OrangeGroupNum = 3;
    final public static int RedGroupNum = 3;
    final public static int YelloGroupNum = 3;
    final public static int GreenGroupNum = 3;
    final public static int BlueGroupNum = 2;
    final public static int RailRoadGroupNum = 4;
    final public static int WaterElectricGroupNum = 2;

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Value of properties">
    //Brown
    final public static int V_MediterraneanAvenue = 60;
    final public static int V_BalticAvenue = 60;
    //Light Blue
    final public static int V_OrientalAvenue = 100;
    final public static int V_VermontAvenue = 100;
    final public static int V_ConnecticutAvenue = 120;
    //Pink
    final public static int V_StCharlesPlace = 140;
    final public static int V_StatesAvenue = 140;
    final public static int V_VirginiaAvenue = 160;
    //Orange
    final public static int V_StJamesPlace = 180;
    final public static int V_TennesseeAvenue = 180;
    final public static int V_NewYorkAvenue = 200;
    //Red
    final public static int V_KentuckyAvenue = 220;
    final public static int V_IndianaAvenue = 220;
    final public static int V_IllinoisAvenue = 240;
    //Yellow
    final public static int V_AtlanticAvenue = 260;
    final public static int V_VentnorAvenue = 260;
    final public static int V_MarvinGardens = 280;
    //Green
    final public static int V_PacificAvenue = 300;
    final public static int V_NorthCarolinaAvenue = 300;
    final public static int V_PennsylvaniaAvenue = 320;
    //Dark Blue
    final public static int V_ParkPlace = 350;
    final public static int V_Boardwalk = 400;
    //Stations
    final public static int V_ReadingRailroad = 200;
    final public static int V_PennsylvaniaRailroad = 200;
    final public static int V_BORailroad = 200;
    final public static int V_ShortLine = 200;
    //Utilities
    final public static int V_ElectricCompany = 150;
    final public static int V_WaterWorks = 150;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mortgage of properties">
    //Brown
    final public static int M_MediterraneanAvenue = 30;
    final public static int M_BalticAvenue = 30;
    //Light Blue
    final public static int M_OrientalAvenue = 50;
    final public static int M_VermontAvenue = 50;
    final public static int M_ConnecticutAvenue = 60;
    //Pink
    final public static int M_StCharlesPlace = 70;
    final public static int M_StatesAvenue = 70;
    final public static int M_VirginiaAvenue = 80;
    //Orange
    final public static int M_StJamesPlace = 90;
    final public static int M_TennesseeAvenue = 90;
    final public static int M_NewYorkAvenue = 100;
    //Red
    final public static int M_KentuckyAvenue = 110;
    final public static int M_IndianaAvenue = 100;
    final public static int M_IllinoisAvenue = 120;
    //Yellow
    final public static int M_AtlanticAvenue = 130;
    final public static int M_VentnorAvenue = 130;
    final public static int M_MarvinGardens = 140;
    //Green
    final public static int M_PacificAvenue = 150;
    final public static int M_NorthCarolinaAvenue = 150;
    final public static int M_PennsylvaniaAvenue = 160;
    //Dark Blue
    final public static int M_ParkPlace = 175;
    final public static int M_Boardwalk = 200;
    //Stations
    final public static int M_ReadingRailroad = 100;
    final public static int M_PennsylvaniaRailroad = 100;
    final public static int M_BORailroad = 100;
    final public static int M_ShortLine = 100;
    //Utilities
    final public static int M_ElectricCompany = 75;
    final public static int M_WaterWorks = 75;
    //</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Rent of properties">
    //Brown
    final public static int[] R_MediterraneanAvenue = {4,10,30,90,160,250};
    final public static int[] R_BalticAvenue = {8,20,60,180,230,450};
    //Light Blue
    final public static int[] R_OrientalAvenue = {6,30,90,270,400,550};
    final public static int[] R_VermontAvenue = {6,30,90,270,400,550};
    final public static int[] R_ConnecticutAvenue = {8,40,100,300,450,600};
    //Pink
    final public static int[] R_StCharlesPlace = {10,50,150,450,625,750};
    final public static int[] R_StatesAvenue = {10,50,150,450,625,750};
    final public static int[] R_VirginiaAvenue = {12,60,180,500,700,900};
    //Orange
    final public static int[] R_StJamesPlace = {14,70,200,550,750,950};
    final public static int[] R_TennesseeAvenue = {14,70,200,550,750,950};
    final public static int[] R_NewYorkAvenue = {16,80,220,600,800,1000};
    //Red
    final public static int[] R_KentuckyAvenue = {18,90,250,700,875,1050};
    final public static int[] R_IndianaAvenue = {18,90,250,700,875,1050};
    final public static int[] R_IllinoisAvenue = {20,100,300,750,925,1100};
    //Yellow
    final public static int[] R_AtlanticAvenue = {22,110,330,800,975,1150};
    final public static int[] R_VentnorAvenue = {22,110,330,800,975,1150};
    final public static int[] R_MarvinGardens = {24,120,360,850,1025,1200};
    //Green
    final public static int[] R_PacificAvenue = {26,130,390,900,1100,1275};
    final public static int[] R_NorthCarolinaAvenue = {26,52,120,390,900,1100,1275};
    final public static int[] R_PennsylvaniaAvenue = {28,150,450,1000,1200,1400};
    //Dark Blue
    final public static int[] R_ParkPlace = {35,175,500,1100,1300,1500};
    final public static int[] R_Boardwalk = {50,200,600,1400,1700,2000};
    //Stations
    final public static int[] R_ReadingRailroad = {25};
    final public static int[] R_PennsylvaniaRailroad = {25};
    final public static int[] R_BORailroad = {25};
    final public static int[] R_ShortLine = {25};
    //Utilities
    final public static int[] R_ElectricCompany = {0};
    final public static int[] R_WaterWorks = {0};
    //</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="HouseValue of properties">
    //Brown
    final public static int H_MediterraneanAvenue = 50;
    final public static int H_BalticAvenue = 50;
    //Light Blue
    final public static int H_OrientalAvenue = 50;
    final public static int H_VermontAvenue = 50;
    final public static int H_ConnecticutAvenue = 50;
    //Pink
    final public static int H_StCharlesPlace = 100;
    final public static int H_StatesAvenue = 100;
    final public static int H_VirginiaAvenue = 100;
    //Orange
    final public static int H_StJamesPlace = 100;
    final public static int H_TennesseeAvenue = 100;
    final public static int H_NewYorkAvenue = 100;
    //Red
    final public static int H_KentuckyAvenue = 150;
    final public static int H_IndianaAvenue = 150;
    final public static int H_IllinoisAvenue = 150;
    //Yellow
    final public static int H_AtlanticAvenue = 150;
    final public static int H_VentnorAvenue = 150;
    final public static int H_MarvinGardens = 150;
    //Green
    final public static int H_PacificAvenue = 200;
    final public static int H_NorthCarolinaAvenue = 200;
    final public static int H_PennsylvaniaAvenue = 200;
    //Dark Blue
    final public static int H_ParkPlace = 200;
    final public static int H_Boardwalk = 200;

    //</editor-fold>     
    
    //<editor-fold defaultstate="collapsed" desc="Position">
    final public static Point P_MediterraneanAvenue = new Point(1,0);
    final public static Point P_BalticAvenue = new Point(3,0);
    //Light Blue
    final public static Point P_OrientalAvenue = new Point(6,0);
    final public static Point P_VermontAvenue = new Point(8,0);
    final public static Point P_ConnecticutAvenue = new Point(9,0);
    //Pink
    final public static Point P_StCharlesPlace = new Point(10,1);
    final public static Point P_StatesAvenue = new Point(10,3);
    final public static Point P_VirginiaAvenue = new Point(10,4);
    //Orange
    final public static Point P_StJamesPlace = new Point(10,6);
    final public static Point P_TennesseeAvenue = new Point(10,8);
    final public static Point P_NewYorkAvenue = new Point(10,9);
    //Red
    final public static Point P_KentuckyAvenue = new Point(9,10);
    final public static Point P_IndianaAvenue = new Point(7,10);
    final public static Point P_IllinoisAvenue = new Point(6,10);
    //Yellow
    final public static Point P_AtlanticAvenue = new Point(4,10);
    final public static Point P_VentnorAvenue = new Point(3,10);
    final public static Point P_MarvinGardens = new Point(1,10);
    //Green
    final public static Point P_PacificAvenue = new Point(0,9);
    final public static Point P_NorthCarolinaAvenue = new Point(0,8);
    final public static Point P_PennsylvaniaAvenue = new Point(0,6);
    //Dark Blue
    final public static Point P_ParkPlace = new Point(0,3);
    final public static Point P_Boardwalk = new Point(0,1);
    //Stations
    final public static Point P_ReadingRailroad = new Point(5,0);
    final public static Point P_PennsylvaniaRailroad = new Point(10,5);
    final public static Point P_BORailroad = new Point(5,10);
    final public static Point P_ShortLine = new Point(0,5);
    //Utilities
    final public static Point P_ElectricCompany = new Point(10,2);
    final public static Point P_WaterWorks = new Point(2,10);
    //Chance and comm
    final public static Point P_Chance1 = new Point(7,0);
    final public static Point P_Chance2 = new Point(8,10);
    final public static Point P_Chance3 = new Point(0,4);
    final public static Point P_CommunityChest1  = new Point(2,0);
    final public static Point P_CommunityChest2  = new Point(10,7);
    final public static Point P_CommunityChest3  = new Point(0,7);
    //Jail , Go To Jail , Free Parking , GO
    final public static Point P_Go = new Point(0,0);
    final public static Point P_Jail = new Point(10,0);
    final public static Point P_FreeParking = new Point(10,10);
    final public static Point P_GoToJail  = new Point(0,10);   
    // income tax
    final public static Point P_Tax1 = new Point(4,0);
    final public static Point P_Tax2 = new Point(0,2);
    
    //</editor-fold> 
    
}
    //</editor-fold> 
