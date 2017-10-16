/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Color;

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

    
    public Player(String name, Color c){
        name=name;
        color=c;
        PositionX=StartX;
        PositionY=StartY;
        money=1500;
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
    //set player position in jail
    public void goToJail(){
        PositionX=10;
        PositionY=0;
    }
}
