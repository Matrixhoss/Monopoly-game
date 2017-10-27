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
    BoardObject[] boardsObjects;

    public Controller() {
        
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
        players.put("fadi", new Player("Fadi", Color.green));
    }
    
    public void addGUI(GUIInterface gui){
        this.gui = gui;
    }
    public  int[] rollDice(){
        return dice.rollDice(players.get("fadi"));
    }
    public void handleDiceRoll(int diceRoll){
        
        gui.animatePlayer("fadi", (diceRoll + players.get("fadi").position)%40, players.get("fadi").position, true);
        players.get("fadi").position=(players.get("fadi").position+diceRoll)%40;
    }
    public int getPlayerPosition(String name){
        return players.get(name).position;
    }
    public ArrayList<Group> getCurrentPlayerGroups(){
        
        ArrayList<Group> resGroups = new ArrayList<Group>();
        for(int i = 0;i < 8; i++){
            int j = 0;
            for(int x : groups[i].propsIndices){
                if(((Property)boardsObjects[x]).ownerPlayer.name.equals("fadi")) j++;
            }
            if(j==groups[i].propsIndices.length) resGroups.add(groups[i]);
        }
        
        return resGroups;
    }
    public void handleNewPosition(int posIndex){
        if(posIndex == 7 || posIndex == 22 || posIndex == 36){
            gui.pullChanceCard("hello World!");
        }else if(posIndex == 2 || posIndex == 17 || posIndex == 33){
            gui.pullCommunityCard("hello world!");
        }else if(posIndex == 4){
            //handle income tax
        }else if(posIndex == 38){
            //handle luxury tax
        }else if(posIndex == 30){
            //Go to jail
        }
    
    }
}
