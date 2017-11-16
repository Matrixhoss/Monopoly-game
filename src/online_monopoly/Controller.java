/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Color;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fadia
 */
public class Controller {
    private static CommunityAndChance CC ;
    private static Dice dice = new Dice();
    private Tax TaxAndIncome=new Tax("TaxAndINcome", -1, new Point(4,0));
    Hashtable<String, Player> players;
    GUIInterface gui;
    Group[] groups;
    int currentPlayer;
    
    //all player names should be initialized here and be consisitent with the hashtable
    String[] playerNames = {"Fadi","Hassan","Hossam"};
    BoardObject[] boardsObjects;

    public Hashtable<String, Player> getPlayers(){
        return players;
    }
    
    public void switchTurn(){
        currentPlayer = (currentPlayer+1)%playerNames.length;
    }
    public Player getCurrentPlayer(){
        return players.get(playerNames[currentPlayer]);
    }
    public Controller() {
        
        currentPlayer=0;
        
        boardsObjects = new BoardObject[40];
        groups = new Group[8];
        int[][] indices = new int[8][];
        
        Color[] colors = {new Color(182, 220, 240), new Color(161, 115, 99), Color.magenta,Color.orange,Color.red,Color.yellow, Color.green, Color.blue};
        for(int i = 0; i < groups.length; i++) groups[i]=new Group(colors[i], i);
        groups[0].setIndices(new int[]{1, 2});
        groups[1].setIndices(new int[]{6,8,9}); 
        groups[2].setIndices(new int[]{11,13,14});
        groups[3].setIndices(new int[]{16,18,19});
        groups[4].setIndices(new int[]{21,23,24});
        groups[5].setIndices(new int[]{26,27,29});
        groups[6].setIndices(new int[]{31,32,34});
        groups[7].setIndices(new int[]{37,39});        
        
        players = new Hashtable<>();
        
        players.put("Fadi", new Player("Fadi", Color.green));
        players.put("Hassan", new Player("Hassan", Color.RED));
        players.put("Hossam", new Player("Hossam", Color.BLUE));
        CC = new CommunityAndChance(players,playerNames);
        
    }
    
    public void addGUI(GUIInterface gui){
        this.gui = gui;
    }
    public  int[] rollDice(){
        return dice.rollDice(getCurrentPlayer());
    }
    public void handleDiceRoll(int diceRoll){
        Player p = getCurrentPlayer();
        gui.animatePlayer(p.name, (diceRoll + p.position)%40, p.position, true);
        players.get(p.name).position=(p.position+diceRoll)%40;
    }
    public int getPlayerPosition(String name){
        return players.get(name).position;
    }
    public ArrayList<Group> getCurrentPlayerGroups(){
        
        ArrayList<Group> resGroups = new ArrayList<>();
        for(int i = 0;i < 8; i++){
            int j = 0;
            for(int x : groups[i].propsIndices){
                if(((Property)boardsObjects[x]).ownerPlayer.name.equals(getCurrentPlayer().name)) j++;
            }
            if(j==groups[i].propsIndices.length) resGroups.add(groups[i]);
        }
        
        return resGroups;
    }
    public void handleNewPosition(int posIndex){
        Player p=players.get(playerNames[currentPlayer]);
        if(posIndex == 7 || posIndex == 22 || posIndex == 36){
            String card=CC.DrawCardPrint("chance",this.currentPlayer);
            gui.pullChanceCard(card);
            printMoney();
        }else if(posIndex == 2 || posIndex == 17 || posIndex == 33){
            String card=CC.DrawCardPrint("chest",this.currentPlayer);
            gui.pullCommunityCard(card);
            printMoney();
        }else if(posIndex == 0){
            p.addMoney(200);
        }else if(posIndex == 4){
            //handle income tax
            TaxOptionPanel taxPanel=new TaxOptionPanel(p,TaxAndIncome);
            taxPanel.setVisible(true);
            printMoney();
        }else if(posIndex == 38){
            //handle luxury tax
            TaxAndIncome.handleLuxTax(p);
            printMoney();
        }else if(posIndex == 30){
            //Go to jail    
        }
        else if(posIndex==3){
            int ch=JOptionPane.showConfirmDialog(null,"Do you want to buy this Property", "Buying Property", JOptionPane.YES_NO_OPTION);
            if(ch==JOptionPane.YES_OPTION){
                p.addMoney(-500);
            }
        }
    
    }
    private void printMoney(){
        for(int i=0;i<3;i++){
          Player p=players.get(playerNames[i]); 
          System.err.println(p.name+" : "+p.getMoney());  
        }
        System.err.println();
    }
    
    public static Point IndexToPoint(int index){
        Point result=new Point(0,0);
        if(index<11){
            result.setX(index);
            result.setY(0);
        }
        else if(index>10&&index<21){
            result.setX(10);
            result.setY((index-10));
        }
        else if(index>20&&index<31){
            result.setX(10-(index-20));
            result.setY(10);
        }
        else{
            result.setX(0);
            result.setY(10-(index-30));
        }
        return result;
    }
    
    public static int PointToIndex(Point p){
        int result=0;
        if(p.getX()>=0&&p.getY()==0)
            result=p.getX();
        else if(p.getX()==10&&p.getY()>0)
            result=p.getX()+p.getY();
        else if(p.getY()==10&&p.getX()>0)
            result=20+(10-p.getX());
        else
            result=30+(10-p.getY());
        return result;
    }
}
