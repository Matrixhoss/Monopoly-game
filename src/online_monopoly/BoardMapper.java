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
import sun.misc.Queue;
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
        
        double x = sideLength-cellCenterHeight;
        double y = sideLength-cellCenterHeight;
        positions[0] = new Point((int)x, (int)y);
        x-=sideLength-2*cellCenterHeight;
        positions[10] = new Point((int)x, (int)y); 
        y-=sideLength-2*cellCenterHeight;
        positions[20] = new Point((int)x, (int)y);
        x+=sideLength-2*cellCenterHeight;
        positions[30] = new Point((int)x, (int)y);
        
        x = sideLength-cellCenterHeight*2-step/2;
        for(int i = 1; i <= 9; i++){
            positions[i] = new Point((int)x, (int)(sideLength-cellCenterHeight));
            x-=step;
        }
        y = sideLength-cellCenterHeight*2-step/2;
        for(int i = 11; i <= 19; i++){
            positions[i] = new Point((int)cellCenterHeight, (int)y);
            y-=step;
        }
        x=cellCenterHeight*2 + step;
        for(int i = 21; i <= 29; i++){
            positions[i] = new Point((int)x, (int)cellCenterHeight);
            x+=step;
        }
        y = sideLength-2*cellCenterHeight-step/2;
        for(int i = 31; i <= 39; i++){
            positions[i] = new Point((int)(sideLength-cellCenterHeight), (int)y);
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
    
    public Queue<Point> getCorners(int origin, int destination){
        Queue<Point> pathCorners = new Queue<>();
        for(int i = origin+1; i != destination; i = (i+1) % 40){
            if(isCorner(i)) pathCorners.enqueue(positions[i]);
        }
     
        return pathCorners;
    }
    private boolean isCorner(int index){
        return(index == 0 || index == 10 || index == 20 || index == 30);
    }
    Point getMapping(int index){
        return positions[index];
    }
    
}
