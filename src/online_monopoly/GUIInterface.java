/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

/**
 *
 * @author fadia
 */
public interface GUIInterface {
    public void pullChanceCard(String msg);
    public void pullCommunityCard(String msg);
    public void animatePlayer(String playerName, int destination, int origin, boolean clockWise);
    public void activatePlayer(String playerName);
}
