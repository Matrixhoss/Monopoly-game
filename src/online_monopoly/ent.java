package online_monopoly;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javafx.scene.layout.Background;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sun.audio.*;

public abstract class  ent extends JFrame implements MouseMotionListener{
    /*public JFrame _this;
    public JLabel ff;
     final ImageIcon icon1 = new ImageIcon("misc/13.png");
   JButton button = new JButton(icon1);
        final int width = icon1.getIconWidth();
        final int height = icon1.getIconHeight();
        public ent(){
    _this=this;
        this.setTitle("Monopoly");
        this.setResizable(false);
        this.setBounds(0,0, 1317, 1037);
//        this.setSize( Toolkit.getDefaultToolkit().getScreenSize() );
//        this.setUndecorated(true);
//        this.setAlwaysOnTop(true);
//        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);
        button.setBounds(200, 200, 400, 500);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        icon1.setImage((icon1.getImage().getScaledInstance(width + 10, height,Image.SCALE_SMOOTH)));
    }
//    public void mousePressed(MouseEvent evt)
//            {
//                ff = new JLabel(icon1);
//        
//        ff.setText("Right");
//        ff.setBounds(0, 0, 120, 120);
//        ff.setVisible(true);
//        c.add(ff);
//                icon1.setImage((icon1.getImage().getScaledInstance(width + 5, height,Image.SCALE_SMOOTH)));
//            }
});
        c.add(button);
}*/
        public void mouseMoved(MouseEvent me){
            int x =me.getX();
            int y =me.getY();
            System.out.println("fffff"+x+"   "+y);
        }
        
        
}