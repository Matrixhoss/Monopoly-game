/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author n0krashy
 */
public class Group {

    private Color color;
    private long id;
    private List<Property> properties = new ArrayList<Property>();
    public int[] propsIndices;
    private String colorName;

    public Group(Color c, int i) {
        color = c;
        id = i;
    }

    public void setIndices(int[] indices) {
        this.propsIndices = indices;
    }

    public void addProperty(Property p) {
        properties.add(p);
    }

    public Color getColor() {
        return color;
    }

    public String getColorName() {
        if (Color.red.equals(color)) {
            colorName = "Red";
        } else if(Color.green.equals(color)){
            colorName = "Green";
        } else if(Color.orange.equals(color)){
            colorName = "Orange";
        } else if(Color.yellow.equals(color)){
            colorName = "Yellow";
        } else if(Color.blue.equals(color)){
            colorName = "Blue";
        } else if(Color.magenta.equals(color)){
            colorName = "Magenta";
        } else if(color.equals(new Color(161, 115, 99))){
            colorName = "Cyan";
        } else if(color.equals(new Color(182, 220, 240))){
            colorName = "Brown";
        }
        return colorName;
    }

    public long getNumber() {
        return id;
    }

    public List<Property> getProperties() {
        return properties;
    }

}
