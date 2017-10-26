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

    public Group(Color c, int i) {
        color = c;
        id = i;
    }
    
    public void setIndices(int[] indices){
        this.propsIndices = indices;
    }
    
    public void addProperty(Property p){
        properties.add(p);
    }

    public Color getColor() {
        return color;
    }

    public long getNumber() {
        return id;
    }

    public List<Property> getProperties() {
        return properties;
    }
    
}
