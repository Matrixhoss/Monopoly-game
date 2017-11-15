package online_monopoly;
import java.awt.Container;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import javafx.scene.layout.Background;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sun.audio.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Trade_GUI extends JFrame{
    public JLabel background;
    public JButton trade;
    public JButton cancel;
    
    ImageIcon trade_logo= new ImageIcon(getClass().getResource("mischd/background.jpg"));
    
    public Trade_GUI(){
        this.setTitle("Trading");
        this.setResizable(false);
        this.setBounds(300, 300, 600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Container c = this.getContentPane();
        c.setLayout(null);
        
        trade = new JButton();
        trade.setText("Trade");
        trade.setBounds(150,300,120,40);
        c.add(trade);
        
        cancel = new JButton();
        cancel.setText("Cancel");
        cancel.setBounds(300,300,120,40);
        cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Trade_GUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        );
        c.add(cancel);
        
        background = new JLabel(trade_logo);
        background.setBounds(0, 0, 600, 400);
        c.add(background);
    }
}