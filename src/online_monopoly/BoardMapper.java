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
import java.awt.Rectangle;
import java.util.ArrayList;
public class BoardMapper {
    double step = 0.0;
    double cellCenterHeight;
    double sideLength;
    
    Point[] positions = new Point[40];
    private void init(){
//        int swAlign = 0;
//        //0
//        double stepX = -step;
//        //1
//        double stepY = -step;
        int sigxright = (int)(sideLength-cellCenterHeight);
        int sigxleft =  (int)(cellCenterHeight*0.5);
        int sigytop = (int)(cellCenterHeight*0.6);
        int sigydown = (int)(sideLength-cellCenterHeight);
        positions[0] = new Point(sigxright, sigydown);
        positions[10] = new Point(sigxleft, sigydown); 
        positions[20] = new Point(sigxleft, sigytop);
        positions[30] = new Point(sigxright, sigytop);
        
        double x = sideLength-cellCenterHeight*2-step/2;
        for(int i = 1; i <= 9; i++){
            positions[i] = new Point((int)x, sigydown);
            x-=step;
        }
        double y = sideLength-cellCenterHeight*2-step/2;
        for(int i = 11; i <= 19; i++){
            positions[i] = new Point(sigxleft, (int)y);
            y-=step;
        }
        x=cellCenterHeight*2 + step;
        for(int i = 21; i <= 29; i++){
            positions[i] = new Point((int)x, sigytop);
            x+=step;
        }
        y = cellCenterHeight+step/2;
        for(int i = 31; i <= 39; i++){
            positions[i] = new Point(sigxright, (int)y);
            y+=step;
        }
    }
    public BoardMapper(int sideLengthInPixels) {
        sideLength = sideLengthInPixels;
        cellCenterHeight = (40.5/600)*sideLengthInPixels;
        step = (49.0/600)*sideLengthInPixels;
        init();
    }
    
    public void print(){
        for(Point p : positions){
            System.out.println(p.getX() + "    " + p.getY());
        }
    }
    
    public ArrayList<Point> getCorners(int origin, int destination, boolean clockWise){
        ArrayList<Point> pathCorners = new ArrayList<>();
        int step = (clockWise)? 1 : -1;
        for(int i = (origin+step); ; i = (i+step)){
            if(clockWise)if(i==40) i=0;
            else if(i==-1) i=39;
            if(i == destination) break;
            if(isCorner(i)) {
                System.out.println("corner "+i+" added, destination : " + destination);
                pathCorners.add(positions[i]);
            }
        }
     
        return pathCorners;
    }
    private boolean isCorner(int index){
        return(index == 0 || index == 10 || index == 20 || index == 30);
    }
    public boolean inBoundary(Point playerPos){
        int x = playerPos.getX(), y = playerPos.getY();
        //int cmpX = positions[10]
        return((x >= cellCenterHeight && x <= sideLength - cellCenterHeight && (y == cellCenterHeight || y == sideLength - cellCenterHeight)) || (y >= cellCenterHeight && y <= sideLength - cellCenterHeight && (x == cellCenterHeight || x == sideLength - cellCenterHeight)));
    }
    //returns steps on x-axis and y-axis base on position and destination
    public int[] getStep(Point pos, Point destination){
        int p = (int)(0.15*step);
        int[] steps = new int[2];
        int xDistance = destination.getX()-pos.getX();
        int yDistance = destination.getY()-pos.getY();
        if(xDistance == 0){
            steps[0]=0;
        }else if(xDistance > 0){
            steps[0]=p;
        }else {
            steps[0]=-p;
        }
        if(yDistance == 0){
            steps[1]=0;
        }else if(yDistance > 0){
            steps[1]=p;
        }else {
            steps[1]=-p;
        }
        if(Math.abs(steps[0]) == p && Math.abs(steps[1]) == p){
            System.out.println("Player X: "+pos.getX()+" Y: "+pos.getY()+", Destination X: "+destination.getX()+" Y: "+destination.getY() );
        }
        return steps;
    }
    Point getMapping(int index){
        return positions[index];
    }
    
}
