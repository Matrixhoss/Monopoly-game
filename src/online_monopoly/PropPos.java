/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Color;


/**
 *
 * @author Kero
 */
public class PropPos {
    Player p = new Player("",Color.BLACK);
    int PX;
    int PY;
    int CX;
    int CY;
    
    public void getProperty()
    {
        PX = p.getX();
        PY = p.getY();
        
        
        
    }
}
