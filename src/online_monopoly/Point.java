/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

/**
 *
 * @author Kero
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point clone(){
        return new Point(this.x, this.y);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "X : "+this.x+" , Y : "+this.y;
    }
    
    
    
    public static boolean compare(Point[] Ps,Point p){
        for(int i=0;i<Ps.length;i++){
            if(p.getX()==Ps[i].getX())
                if(p.getY()==Ps[i].getY())
                    return true;
        }
        return false;
    }
}
