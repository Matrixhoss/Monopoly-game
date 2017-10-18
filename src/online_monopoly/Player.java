/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author user1
 */
public class Player {
    private final int step = 50;
    private int PositionX;
    private int PositionY;
    private final int StartX=0; //player start with this position (x)
    private final int StartY=0; //player start with this position (y)
    private int money;
    private String name;
    private Color color;
    private boolean ChanceEJail; //player has chance card to exit from jail
    private boolean CommunityEJail; //player has communtiy card to exit from jail
    private boolean InJail;//if player in jail it will be true
    private ArrayList<Property> MyProperties=new ArrayList<Property>(); //properties that player has
    private int[] Dice=new int[2];

    
    public Player(String name, Color c){
        this.name=name;
        color=c;
        PositionX=StartX;
        PositionY=StartY;
        money=1500;     
    }
    
    public void setPosition(int x,int y){
        this.PositionX=x;
        this.PositionY=y;
    }
    
    public int getX(){
        return PositionX;
    }

    public int getY(){
        return PositionY;
    }

    public Color getColor() {
        return color;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void addMoney(int m){
        money+=m;
    }
    
    public void payMoney(int m){
        money-=m;
    }
    
    public void setDice(int[] D){
        this.Dice=D;
    }
    
    public int[] getDice(){
        return this.Dice;
    }
    //add property
    public void addProperty(Property p){
        MyProperties.add(p);
    }
    //check if player has group
    public boolean checkGroup(Property p){
        int count=0;
        for(int i=0;i<MyProperties.size();i++){
            if(MyProperties.get(i).getGroupID()==p.getGroupID())
                count++;
        }
        if(count==p.getGroupNum())
            return true;
        return false;
    }
    //add chance card (exit from jail)
    public void addChanceCard(boolean c){
        this.ChanceEJail=c;
    }
    //add community card (exit from jail)
    public void addCommunityCard(boolean c){
        this.CommunityEJail=c;
    }
    //check if player has chance card for exit from jail
    public boolean hasChanceCard(){
        return this.ChanceEJail;
    }
    //check if player has community card for exit from jail
    public boolean hasCommunityCard(){
        return this.CommunityEJail;
    }
    //check if player in jail
    public boolean checkInJail(){
        return this.InJail;
    }
    //exit from jail
    public void exitFromJail(){
        this.InJail=false;
    }
    //imagine Go in (0,0) and x axis increased when go left and y increased when move up
    public void move(int dice){
        for(int i=0;i<dice;i++){
            if(PositionX<10&&PositionY==0){
                PositionX+=1;
            }else if(PositionX==10&&PositionY<10){
                PositionY+=1;
            }else if(PositionX>0&&PositionY==10){
                PositionX-=1;
            }else if(PositionX==0&&PositionY>0){
                PositionY-=1;
            } 
        }
    }
    //move back
    public void moveBack(int moves){
        
    }
    //set player position in jail
    public void goToJail(){
        PositionX=10;
        PositionY=0;
        this.InJail=true;
    }
    //calculate Total Houses
    public int getTotalHouses(){
        int NumOfHouses=0;
        for(int i=0;i<MyProperties.size();i++){
            NormalProperty p=(NormalProperty)(MyProperties.get(i));
            NumOfHouses+=p.getNumOfHouses(); // Hossam
        }
        return NumOfHouses;
    }
    //calculate Total Hotels
    public int getTotalHotels(){
        int NumOfHotels=0;
        for(int i=0;i<MyProperties.size();i++){
            NormalProperty p=(NormalProperty)(MyProperties.get(i));
            NumOfHotels+=p.getNumOfHotels(); // Hossam
        }
        return NumOfHotels;
    }
    
    //calculate total money with player
    public int getTotalMoney(){
        int TotalM=this.money;
        for(int i=0;i<MyProperties.size();i++){
            NormalProperty p=(NormalProperty)(MyProperties.get(i));
            TotalM+=(p.getNumOfHouses()*50+p.getNumOfHotels()*100);//lsh m5l // Hossam
        }
        return TotalM;
    }
}
