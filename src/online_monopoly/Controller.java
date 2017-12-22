/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import com.sun.org.apache.xerces.internal.util.PropertyState;
import java.awt.Color;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author fadia
 */
public class Controller {

    private static CommunityAndChance CC;
    private static Dice dice = new Dice();
    private Tax TaxAndIncome = new Tax("TaxAndINcome", -1, new Point(4, 0));
    Hashtable<String, Player> players;
    GUIInterface gui;
    Group[] groups;
    int currentPlayer;


    //all player names should be initialized here and be consisitent with the hashtable
    String[] playerNames = {};
    BoardObject[] boardsObjects;

    public Hashtable<String, Player> getPlayers() {
        return players;
    }

    public void switchTurn() {
        currentPlayer = (currentPlayer + 1) % playerNames.length;
        gui.activatePlayer(getCurrentPlayer().name);
        dice.resetDice(); 
    }

    public Player getCurrentPlayer() {
        return players.get(playerNames[currentPlayer]);
    }

    public void sendCurrentPlayerTojail() {
        getCurrentPlayer().goToJail();
    }

    public int getDoubleDice() {
        return dice.getDoubleDice();
    }
    public Controller(HashMap<String,String> playersImagesAssociation) {

        currentPlayer = 0;

        boardsObjects = new BoardObject[40];
        PropertyInit(boardsObjects);
        groups = new Group[8];
        int[][] indices = new int[8][];

        Color[] colors = {new Color(182, 220, 240), new Color(161, 115, 99), Color.magenta, Color.orange, Color.red, Color.yellow, Color.green, Color.blue};
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group(colors[i], i);
        }
        groups[0].setIndices(new int[]{1, 2});
        groups[1].setIndices(new int[]{6, 8, 9});
        groups[2].setIndices(new int[]{11, 13, 14});
        groups[3].setIndices(new int[]{16, 18, 19});
        groups[4].setIndices(new int[]{21, 23, 24});
        groups[5].setIndices(new int[]{26, 27, 29});
        groups[6].setIndices(new int[]{31, 32, 34});
        groups[7].setIndices(new int[]{37, 39});

        players = new Hashtable<>();

        initializePlayers(playersImagesAssociation);
        CC = new CommunityAndChance(players, playerNames);
        //players.get("Hassan").goToJail();

    }

    public final void initializePlayers(HashMap<String,String> playersImagesAssociation){
        Random rand = new Random();
        ArrayList<String> playersnames = new ArrayList<>();
        for(String key: playersImagesAssociation.keySet()){
            
            String name = playersImagesAssociation.get(key);
            if(name != null){
                players.put(name, new Player(name, Integer.parseInt(key), new Color(getConstrainedRandomNumber(100), getConstrainedRandomNumber(200),getConstrainedRandomNumber(256))));
                playersnames.add(name);
            }
        }
        this.playerNames = playersnames.toArray(this.playerNames);
    }
    public int getConstrainedRandomNumber(int num){
        return (Math.abs(new Random().nextInt()))%num;
    }
    public void addGUI(GUIInterface gui) {
        this.gui = gui;
    }

    public int[] rollDice() {
        return dice.rollDice(getCurrentPlayer());
    }

    public void handleDiceRoll(int diceRoll) {
        Player p = getCurrentPlayer();
        gui.animatePlayer(p.name, (diceRoll + p.position) % 40, p.position, true);
        players.get(p.name).position = (p.position + diceRoll) % 40;
    }

    public int getPlayerPosition(String name) {
        return players.get(name).position;
    }

    public ArrayList<Group> getCurrentPlayerGroups() {

        ArrayList<Group> resGroups = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int j = 0;
            for (int x : groups[i].propsIndices) {
                if (((Property) boardsObjects[x]).ownerPlayer.name.equals(getCurrentPlayer().name)) {
                    j++;
                }
            }
            if (j == groups[i].propsIndices.length) {
                resGroups.add(groups[i]);
            }
        }

        return resGroups;
    }

    public void handleNewPosition(int posIndex) {
        Player p = players.get(playerNames[currentPlayer]);
        p.setPosition(IndexToPoint(p.position));
        System.out.println("Name : " + p.name + " , Index : " + p.position + " , " + p.getX() + " , " + p.getY());
        if (posIndex == 7 || posIndex == 22 || posIndex == 36) {
            String card = CC.DrawCardPrint("chance", this.currentPlayer);
            gui.pullChanceCard(card);
            printMoney();
        } else if (posIndex == 2 || posIndex == 17 || posIndex == 33) {
            String card = CC.DrawCardPrint("chest", this.currentPlayer);
            gui.pullCommunityCard(card);
            printMoney();
        } else if (posIndex == 0 || posIndex == 40) {
            p.addMoney(200);
        } else if (posIndex == 4) {
            //handle income tax
            TaxOptionFrame taxPanel = new TaxOptionFrame(p, TaxAndIncome);
            taxPanel.setVisible(true);
            printMoney();
        } else if (posIndex == 38) {
            //handle luxury tax
            TaxAndIncome.handleLuxTax(p);
            printMoney();
        } else if (posIndex == 30 || posIndex == 10 || posIndex == 20) {
            if (posIndex == 30) {
                    sendCurrentPlayerTojail();
            }
        } else {
            Property p1 = (Property) (boardsObjects[posIndex]);
            BuyPropertyOrPay(p1, p);
        }
    }

    private void printMoney() {
        for (int i = 0; i < 3; i++) {
            Player p = players.get(playerNames[i]);
            System.err.println(p.name + " : " + p.getMoney());
        }
        System.err.println();
    }

    public static Point IndexToPoint(int index) {
        Point result = new Point(0, 0);
        if (index < 11) {
            result.setX(index);
            result.setY(0);
        } else if (index > 10 && index < 21) {
            result.setX(10);
            result.setY((index - 10));
        } else if (index > 20 && index < 31) {
            result.setX(10 - (index - 20));
            result.setY(10);
        } else {
            result.setX(0);
            result.setY(10 - (index - 30));
        }
        return result;
    }

    public static int PointToIndex(Point p) {
        int result = 0;
        if (p.getX() >= 0 && p.getY() == 0) {
            result = p.getX();
        } else if (p.getX() == 10 && p.getY() > 0) {
            result = p.getX() + p.getY();
        } else if (p.getY() == 10 && p.getX() > 0) {
            result = 20 + (10 - p.getX());
        } else {
            result = 30 + (10 - p.getY());
        }
        return result;
    }

    private void BuyPropertyOrPay(Property NP, Player p) {
        if (!NP.haveOwner()) {
            int ch = JOptionPane.showConfirmDialog(null, "Do you want to buy this Property", "Buying Property", JOptionPane.YES_NO_OPTION);
            if (ch == JOptionPane.YES_OPTION) {
                NP.buyProperty(p);
                p.payMoney(NP.value);
                p.addProperty(NP);
            }
        } else {
            JOptionPane.showMessageDialog(null, "The Owner need his Rent");
            NP.payRent(p);//make playe pay rent
        }
    }

    public void PropertyInit(BoardObject p[]) {
        //Brown
        p[1] = new NormalProperty("MediterraneanAvenue", 1, PropertyStander.P_MediterraneanAvenue, PropertyStander.V_MediterraneanAvenue, PropertyStander.R_MediterraneanAvenue, PropertyStander.M_MediterraneanAvenue, PropertyStander.BrownGroup, PropertyStander.BrownGroupNum, PropertyStander.H_MediterraneanAvenue);
        p[3] = new NormalProperty("BalticAvenue", 3, PropertyStander.P_BalticAvenue, PropertyStander.V_BalticAvenue, PropertyStander.R_BalticAvenue, PropertyStander.M_BalticAvenue, PropertyStander.BrownGroup, PropertyStander.BrownGroupNum, PropertyStander.H_BalticAvenue);
        //Light Blue
        p[6] = new NormalProperty("OrientalAvenue", 6, PropertyStander.P_OrientalAvenue, PropertyStander.V_OrientalAvenue, PropertyStander.R_OrientalAvenue, PropertyStander.M_OrientalAvenue, PropertyStander.LightBlueGroup, PropertyStander.LightBlueGroupNum, PropertyStander.H_OrientalAvenue);
        p[8] = new NormalProperty("VermontAvenue", 8, PropertyStander.P_VermontAvenue, PropertyStander.V_VermontAvenue, PropertyStander.R_VermontAvenue, PropertyStander.M_VermontAvenue, PropertyStander.LightBlueGroup, PropertyStander.LightBlueGroupNum, PropertyStander.H_VermontAvenue);
        p[9] = new NormalProperty("ConnecticutAvenue", 9, PropertyStander.P_ConnecticutAvenue, PropertyStander.V_ConnecticutAvenue, PropertyStander.R_ConnecticutAvenue, PropertyStander.M_ConnecticutAvenue, PropertyStander.LightBlueGroup, PropertyStander.LightBlueGroupNum, PropertyStander.H_ConnecticutAvenue);
        //roze
        p[11] = new NormalProperty("StCharlesPlace", 11, PropertyStander.P_StCharlesPlace, PropertyStander.V_StCharlesPlace, PropertyStander.R_StCharlesPlace, PropertyStander.M_StCharlesPlace, PropertyStander.RozeGroup, PropertyStander.RozeGroupNum, PropertyStander.H_StCharlesPlace);
        p[13] = new NormalProperty("StatesAvenue", 13, PropertyStander.P_StatesAvenue, PropertyStander.V_StatesAvenue, PropertyStander.R_StatesAvenue, PropertyStander.M_StatesAvenue, PropertyStander.RozeGroup, PropertyStander.RozeGroupNum, PropertyStander.H_StatesAvenue);
        p[14] = new NormalProperty("VirginiaAvenue", 14, PropertyStander.P_VirginiaAvenue, PropertyStander.V_VirginiaAvenue, PropertyStander.R_VirginiaAvenue, PropertyStander.M_VirginiaAvenue, PropertyStander.RozeGroup, PropertyStander.RozeGroupNum, PropertyStander.H_VirginiaAvenue);
        //Orange
        p[16] = new NormalProperty("StJamesPlace", 16, PropertyStander.P_StJamesPlace, PropertyStander.V_StJamesPlace, PropertyStander.R_StJamesPlace, PropertyStander.M_StJamesPlace, PropertyStander.OrangeGroup, PropertyStander.OrangeGroupNum, PropertyStander.H_StJamesPlace);
        p[18] = new NormalProperty("TennesseeAvenue", 18, PropertyStander.P_TennesseeAvenue, PropertyStander.V_TennesseeAvenue, PropertyStander.R_TennesseeAvenue, PropertyStander.M_TennesseeAvenue, PropertyStander.OrangeGroup, PropertyStander.OrangeGroupNum, PropertyStander.H_TennesseeAvenue);
        p[19] = new NormalProperty("NewYorkAvenue", 19, PropertyStander.P_NewYorkAvenue, PropertyStander.V_NewYorkAvenue, PropertyStander.R_NewYorkAvenue, PropertyStander.M_NewYorkAvenue, PropertyStander.OrangeGroup, PropertyStander.OrangeGroupNum, PropertyStander.H_NewYorkAvenue);
        //Red
        p[21] = new NormalProperty("KentuckyAvenue", 21, PropertyStander.P_KentuckyAvenue, PropertyStander.V_KentuckyAvenue, PropertyStander.R_KentuckyAvenue, PropertyStander.M_KentuckyAvenue, PropertyStander.RedGroup, PropertyStander.RedGroupNum, PropertyStander.H_KentuckyAvenue);
        p[23] = new NormalProperty("IndianaAvenue", 23, PropertyStander.P_IndianaAvenue, PropertyStander.V_IndianaAvenue, PropertyStander.R_IndianaAvenue, PropertyStander.M_IndianaAvenue, PropertyStander.RedGroup, PropertyStander.RedGroupNum, PropertyStander.H_IndianaAvenue);
        p[24] = new NormalProperty("IllinoisAvenue", 24, PropertyStander.P_IllinoisAvenue, PropertyStander.V_IllinoisAvenue, PropertyStander.R_IllinoisAvenue, PropertyStander.M_IllinoisAvenue, PropertyStander.RedGroup, PropertyStander.RedGroupNum, PropertyStander.H_IllinoisAvenue);
        //Yellow
        p[26] = new NormalProperty("AtlanticAvenue", 26, PropertyStander.P_AtlanticAvenue, PropertyStander.V_AtlanticAvenue, PropertyStander.R_AtlanticAvenue, PropertyStander.M_AtlanticAvenue, PropertyStander.YelloGroup, PropertyStander.YelloGroupNum, PropertyStander.H_AtlanticAvenue);
        p[27] = new NormalProperty("VentnorAvenue", 27, PropertyStander.P_VentnorAvenue, PropertyStander.V_VentnorAvenue, PropertyStander.R_VentnorAvenue, PropertyStander.M_VentnorAvenue, PropertyStander.YelloGroup, PropertyStander.YelloGroupNum, PropertyStander.H_VentnorAvenue);
        p[29] = new NormalProperty("MarvinGardens", 29, PropertyStander.P_MarvinGardens, PropertyStander.V_MarvinGardens, PropertyStander.R_MarvinGardens, PropertyStander.M_MarvinGardens, PropertyStander.YelloGroup, PropertyStander.YelloGroupNum, PropertyStander.H_MarvinGardens);
        //Green
        p[31] = new NormalProperty("PacificAvenue", 31, PropertyStander.P_PacificAvenue, PropertyStander.V_PacificAvenue, PropertyStander.R_PacificAvenue, PropertyStander.M_PacificAvenue, PropertyStander.GreenGroup, PropertyStander.GreenGroupNum, PropertyStander.H_PacificAvenue);
        p[32] = new NormalProperty("NorthCarolinaAvenue", 32, PropertyStander.P_NorthCarolinaAvenue, PropertyStander.V_NorthCarolinaAvenue, PropertyStander.R_NorthCarolinaAvenue, PropertyStander.M_NorthCarolinaAvenue, PropertyStander.GreenGroup, PropertyStander.GreenGroupNum, PropertyStander.H_NorthCarolinaAvenue);
        p[34] = new NormalProperty("PennsylvaniaAvenue", 34, PropertyStander.P_PennsylvaniaAvenue, PropertyStander.V_PennsylvaniaAvenue, PropertyStander.R_PennsylvaniaAvenue, PropertyStander.M_PennsylvaniaAvenue, PropertyStander.GreenGroup, PropertyStander.GreenGroupNum, PropertyStander.H_PennsylvaniaAvenue);
        //Dark Blue
        p[37] = new NormalProperty("ParkPlace", 37, PropertyStander.P_ParkPlace, PropertyStander.V_ParkPlace, PropertyStander.R_ParkPlace, PropertyStander.M_ParkPlace, PropertyStander.BlueGroup, PropertyStander.BlueGroupNum, PropertyStander.H_ParkPlace);
        p[39] = new NormalProperty("Boardwalk", 39, PropertyStander.P_Boardwalk, PropertyStander.V_Boardwalk, PropertyStander.R_Boardwalk, PropertyStander.M_Boardwalk, PropertyStander.BlueGroup, PropertyStander.BlueGroupNum, PropertyStander.H_Boardwalk);
        //Utilities
        p[12] = new WaterworksOrElectric("ElectricCompany", 12, PropertyStander.P_ElectricCompany, PropertyStander.V_ElectricCompany, PropertyStander.R_ElectricCompany, PropertyStander.M_ElectricCompany, PropertyStander.WaterElectricGroup, PropertyStander.WaterElectricGroupNum);
        p[28] = new WaterworksOrElectric("WaterWorks", 28, PropertyStander.P_WaterWorks, PropertyStander.V_WaterWorks, PropertyStander.R_WaterWorks, PropertyStander.M_WaterWorks, PropertyStander.WaterElectricGroup, PropertyStander.WaterElectricGroupNum);
        // income tax
        p[4] = new Tax("IncomeTax", 4, PropertyStander.P_Tax1);
        p[38] = new Tax("LuxuryTax", 38, PropertyStander.P_Tax2);
        //Stations
        p[5] = new Railroad("ReadingRailroad", 5, PropertyStander.P_ReadingRailroad, 200, PropertyStander.R_ReadingRailroad, PropertyStander.M_ReadingRailroad, PropertyStander.RailRoadGroup, PropertyStander.RailRoadGroupNum);
        p[15] = new Railroad("PennsylvaniaRailroad", 15, PropertyStander.P_PennsylvaniaRailroad, 200, PropertyStander.R_PennsylvaniaRailroad, PropertyStander.M_PennsylvaniaRailroad, PropertyStander.RailRoadGroup, PropertyStander.RailRoadGroupNum);
        p[25] = new Railroad("BORailroad", 25, PropertyStander.P_BORailroad, 200, PropertyStander.R_BORailroad, PropertyStander.M_BORailroad, PropertyStander.RailRoadGroup, PropertyStander.RailRoadGroupNum);
        p[35] = new Railroad("ShortLine", 35, PropertyStander.P_ShortLine, 200, PropertyStander.R_ShortLine, PropertyStander.M_ShortLine, PropertyStander.RailRoadGroup, PropertyStander.RailRoadGroupNum);
        //jail
        p[10] = new Jail("Jail", 10, PropertyStander.P_Jail);

    }
}
