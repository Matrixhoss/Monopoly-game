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
import javafx.scene.control.CheckBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Trade_GUI extends JFrame{
    public JLabel background;
    public JLabel yours;
    public JButton trade;
    public JButton cancel;
    public JComboBox plylist;
    public JTextField money;
    public JComboBox property;
    public JComboBox property_money;
    public JComboBox my_property;
    public JCheckBox box;
    public JCheckBox box1;
    public JCheckBox box2;
    public JCheckBox box3;
    public JCheckBox box4;
    public JCheckBox box5;
    public JCheckBox box6;
    public JCheckBox box7;
    public JCheckBox box8;
    public JCheckBox box9;
    public JCheckBox box10;
    public JCheckBox box11;
    public JCheckBox box12;
    public JCheckBox box13;
    public JCheckBox box14;
    public JCheckBox box15;
    public JCheckBox box16;
    public JCheckBox box17;
    public JCheckBox box18;
    public JCheckBox box19;
    public JCheckBox box20;
    ImageIcon trade_logo= new ImageIcon(getClass().getResource("mischd/background.jpg"));
    
    public Trade_GUI(){
        this.setTitle("Trading");
        this.setResizable(false);
        this.setBounds(300, 300, 600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Container c = this.getContentPane();
        c.setLayout(null);
        
        box = new JCheckBox();
        box.setBounds(100, 100, 20, 20);
        box.setSelected(false);
        c.add(box);
        
        String[] ply = {"player 1", "player 2", "player 3", "player 4"};
        plylist = new JComboBox(ply);
        plylist.setBounds(400, 50, 120, 40);
        plylist.setSelectedIndex(3);
        plylist.addActionListener(plylist);
        c.add(plylist);
        
        my_property = new JComboBox();
        my_property.setBounds(225, 200, 120, 40);
        my_property.addActionListener(my_property);
        c.add(my_property);
        
        property = new JComboBox();
        property.setBounds(250, 50, 120, 40);
        property.setVisible(false);
        property.addActionListener(property);
        c.add(property);
        
        money = new JTextField("Enter amount");
        money.setBounds(250, 50, 120, 40);
        money.setVisible(false);
        c.add(money);
        
        String[] pro_mon = {"Money", "Property"};
        property_money = new JComboBox(pro_mon);
        property_money.setBounds(100, 50, 120, 40);
        property_money.setSelectedIndex(1);
        property_money.addActionListener(property_money);
        property_money.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox)e.getSource();
                    String option = (String)cb.getSelectedItem();
                    if(option.equals("Money")){
                        money.setVisible(true);
                        property.setVisible(false);
                    }
                    else{
                        property.setVisible(true);
                        money.setVisible(false);
                    }
                }
            }
        );
        c.add(property_money);
        
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
        
        yours = new JLabel("Your property to exchange");
        yours.setBounds(50, 200, 180, 40);
        c.add(yours);
        
        background = new JLabel(trade_logo);
        background.setBounds(0, 0, 600, 400);
        c.add(background);
    }
}