/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Color;
import java.util.Hashtable;

/**
 *
 * @author fadia
 */
public class Controller {
    private static CommunityAndChance CC = new CommunityAndChance();
    private static Dice dice = new Dice();
    Hashtable<String, Player> players;
    GUIInterface gui;
    

    public Controller() {
        players = new Hashtable<>();
        players.put("fadi", new Player("Fadi", Color.green));
    }
    
    public void addGUI(GUIInterface gui){
        this.gui = gui;
    }
    public int[] rollDice(){
        return dice.rollDice();
    }
    public void handleDiceRoll(int diceRoll){
        
        gui.animatePlayer("fadi", (diceRoll + players.get("fadi").position)%40, players.get("fadi").position, true);
        players.get("fadi").position=(players.get("fadi").position+diceRoll)%40;
    }
    public int getPlayerPosition(String name){
        return players.get(name).position;
    }
}
