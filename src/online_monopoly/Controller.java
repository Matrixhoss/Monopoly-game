/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Color;
import java.util.Hashtable;
import java.util.ArrayList;

/**
 *
 * @author fadia
 */
public class Controller {
    private static CommunityAndChance CC = new CommunityAndChance();
    private static Dice dice = new Dice();
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
            CC.DrawCard("chance",p);
            gui.pullChanceCard("hello World!");
            System.err.println(p.name+" : "+p.getMoney());
        }else if(posIndex == 2 || posIndex == 17 || posIndex == 33){
            CC.DrawCard("chest",p);
            gui.pullCommunityCard("hello world!");
            System.err.println(p.name+" : "+p.getMoney());
        }else if(posIndex == 4){
            //handle income tax
        }else if(posIndex == 38){
            //handle luxury tax
        }else if(posIndex == 30){
            //Go to jail
        }
    
    }
}
