/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author user1
 */
public class Player {
    
    int position;
    private int count=0;
    private int XonBoard = 924, YonBoard = 950; // position of player on gui
    private final int stepX = 84, stepY = 84;   
    private int PositionX;
    private int PositionY;
    private final int StartX = 0; //player start with this position (x)
    private final int StartY = 0; //player start with this position (y)
    private int money;
    private String name;
    private Color color;
    private boolean ChanceEJail; //player has chance card to exit from jail
    private boolean CommunityEJail; //player has communtiy card to exit from jail
    private boolean InJail;//if player in jail it will be true
    private ArrayList<Property> MyProperties = new ArrayList<Property>(); //properties that player has
    private Mainboard_GUI Board;
    private int[] Dice = new int[2];
    private boolean NoMoney=true;//to know if he run out of money
    private boolean Moving=false;

    public Player(String name, Color c) {
        this.name = name;
        color = c;
        PositionX = StartX;
        PositionY = StartY;
        money = 1500;
    }

    public Player(String name, Color c, Mainboard_GUI frame) {
        this.name = name;
        color = c;
        PositionX = StartX;
        PositionY = StartY;
        money = 1500;
        Board=frame;
    }
    
    public Color getColor() {
        return color;
    }   
    //<editor-fold defaultstate="collapsed" desc="control Player Position">
    //return position of player on gui in x
    public int getXonBoard() {
        return XonBoard;
    }
    //return position of player on gui in y
    public int getYonBoard() {
        return YonBoard;
    }
    //set real position of player
    public void setPosition(int x, int y) {
        this.PositionX = x;
        this.PositionY = y;
    }
    
    public void setPosition(Point p) {
        this.PositionX = p.getX();
        this.PositionY = p.getY();
    }
    
    public int getX() {
        return PositionX;
    }
    
    public int getY() {
        return PositionY;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Money">
//calculate total money with player
    public int getTotalMoney() {
        int TotalM = this.money;
        for (int i = 0; i < MyProperties.size(); i++) {
            NormalProperty p = (NormalProperty) (MyProperties.get(i));
            TotalM += (p.getNumOfHouses() * 50 + p.getNumOfHotels() * 100);//lsh m5l // Hossam
        }
        return TotalM;
    }
    //return money with player
    public int getMoney() {
        return money;
    }
    //to add money to player
    public void addMoney(int m) {
        money += m;
    }
    //make player pay money
    public void payMoney(int m) {
        money -= m;
    }
    //
    public boolean getNoMoney(){
        return this.NoMoney;
    }
    //
    public void setNoMoney(boolean N){
        this.NoMoney=N;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="set and get dice">
    public void setDice(int[] D) {
        this.Dice = D;
    }
    
    public int[] getDice() {
        return this.Dice;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="community and chance">
    
    //add chance card (exit from jail)
    public void addChanceCard(boolean c) {
        this.ChanceEJail = c;
    }
    
    //add community card (exit from jail)
    public void addCommunityCard(boolean c) {
        this.CommunityEJail = c;
    }
    
    //check if player has chance card for exit from jail
    public boolean hasChanceCard() {
        return this.ChanceEJail;
    }
    
    //check if player has community card for exit from jail
    public boolean hasCommunityCard() {
        return this.CommunityEJail;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Jail">
    
    //check if player in jail
    public boolean checkInJail() {
        return this.InJail;
    }
    
    //exit from jail
    public void exitFromJail() {
        this.InJail = false;
    }
    
    //set player position in jail
    public void goToJail() {
        PositionX = 10;
        PositionY = 0;
        this.InJail = true;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="control player's properties">

    //add property
    public void addProperty(Property p) {
        MyProperties.add(p);
    }
    
    //check if player has group
    public boolean checkGroup(Property p) {
        int count = 0;
        for (int i = 0; i < MyProperties.size(); i++) {
            if (MyProperties.get(i).getGroupID() == p.getGroupID()) {
                count++;
            }
        }
        if (count == p.getGroupNum()) {
            return true;
        }
        return false;
    }
    
    //return number of properties in group
    public int getNumOfPropertiesInGroup(Property p) {
        int count=0;
        for(int i=0;i<MyProperties.size();i++)
            if (MyProperties.get(i).getGroupID() == p.getGroupID()) {
                count++;
            }
        return count;
    }
    
    //return all of properties in group
    public ArrayList<Property> getPropertiesInGroup(Property p) {
        ArrayList<Property> PS=new ArrayList<Property>();
        for(int i=0;i<MyProperties.size();i++)
            if (MyProperties.get(i).getGroupID() == p.getGroupID()) {
                PS.add(MyProperties.get(i));
            }
        return PS;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Houses and Hotels">
    //calculate Total Houses
    public int getTotalHouses() {
        int NumOfHouses = 0;
        for (int i = 0; i < MyProperties.size(); i++) {
            NormalProperty p = (NormalProperty) (MyProperties.get(i));
            NumOfHouses += p.getNumOfHouses(); // Hossam
        }
        return NumOfHouses;
    }
    
    //calculate Total Hotels
    public int getTotalHotels() {
        int NumOfHotels = 0;
        for (int i = 0; i < MyProperties.size(); i++) {
            NormalProperty p = (NormalProperty) (MyProperties.get(i));
            NumOfHotels += p.getNumOfHotels(); // Hossam
        }
        return NumOfHotels;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Move player in any direction">
    
    //check if player moving or not
    public boolean IsMoving(){
        return this.Moving;
    }
    //imagine Go in (0,0) and x axis increased when go left and y increased when move up
    public void move(int dice) {
        Moving=true;
        count=0;
        final javax.swing.Timer timer = new javax.swing.Timer(500, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("X :" + XonBoard + ", X' :" + (PositionX * Fx + Sx) + ",Y :" + YonBoard + ", Y' :" + (PositionY * Fy + Sy));
                if (count == dice) {
                    System.out.println("finish");
                    Moving=false;
                    timer.stop();
                    return;
                }
                if(PositionX ==0 && PositionY == 1){//Go point
                    PositionY--;
                    XonBoard= 924;
                    YonBoard=950;
                }else if(PositionX ==9 && PositionY == 0){//Jail point
                    PositionX++;
                    YonBoard = 950;
                    XonBoard =84;
                }else if(PositionX ==10 && PositionY == 9){//free parking
                    PositionY++;
                    XonBoard=84;
                    YonBoard=100;
                }else if(PositionX ==1 && PositionY == 10){//Go to jail
                    PositionX--;
                    XonBoard =924;
                    YonBoard =100;
                }else if (PositionX < 10 && PositionY == 0) {
                    PositionX++;
                    XonBoard  -=stepX;
                } else if (PositionX == 10 && PositionY < 10) {
                    PositionY += 1;
                    YonBoard -=stepY;
                } else if (PositionX > 0 && PositionY == 10) {
                    PositionX -= 1;
                    XonBoard +=stepX;
                } else if (PositionX == 0 && PositionY > 0) {
                    PositionY -= 1;
                    YonBoard +=stepY;
                }
                Board.repaint();
                System.out.println("x : "+PositionX+" , y : "+PositionY);
                count++;
                Moving=true;
            }
        });
        timer.start();
        
    }
    
    //move player to spacific position
    public void move(Point p) {
        Moving=true;
        final javax.swing.Timer timer = new javax.swing.Timer(500, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("X :" + XonBoard + ", X' :" + (PositionX * Fx + Sx) + ",Y :" + YonBoard + ", Y' :" + (PositionY * Fy + Sy));
                if (PositionX==p.getX()&&PositionY==p.getY()) {
                    System.out.println("finish");
                    Moving=false;
                    timer.stop();
                    return;
                }
                if(PositionX ==0 && PositionY == 1){//Go point
                    PositionY--;
                    XonBoard= 924;
                    YonBoard=950;
                }else if(PositionX ==9 && PositionY == 0){//Jail point
                    PositionX++;
                    YonBoard = 950;
                    XonBoard =84;
                }else if(PositionX ==10 && PositionY == 9){//free parking
                    PositionY++;
                    XonBoard=84;
                    YonBoard=100;
                }else if(PositionX ==1 && PositionY == 10){//Go to jail
                    PositionX--;
                    XonBoard =924;
                    YonBoard =100;
                }else if (PositionX < 10 && PositionY == 0) {
                    PositionX++;
                    XonBoard  -=stepX;
                } else if (PositionX == 10 && PositionY < 10) {
                    PositionY += 1;
                    YonBoard -=stepY;
                } else if (PositionX > 0 && PositionY == 10) {
                    PositionX -= 1;
                    XonBoard +=stepX;
                } else if (PositionX == 0 && PositionY > 0) {
                    PositionY -= 1;
                    YonBoard +=stepY;
                }
                Board.repaint();
                Moving=true;
                System.out.println("x : "+PositionX+" , y : "+PositionY);
            }
        });
        timer.start();
    }
    //move back
    public void moveBack(int moves) {
        
    }
//</editor-fold>
}
