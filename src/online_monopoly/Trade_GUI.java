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
import java.util.logging.ConsoleHandler;
import javafx.scene.control.CheckBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Trade_GUI extends JFrame {

    public JLabel background;
    public JLabel yours;
    public JButton trade;
    public JButton cancel;
    public JComboBox plylist;
    public JTextField money;
    public JTextField my_money;
    public JComboBox property;
    public JComboBox property_money;
    public JComboBox myproperty_money;
    public JComboBox my_property;
    public boolean show = true;
    int x = 0;
    int y = 95;
    int v = 0;
    int w = 230;
    public ArrayList<String> myArrayList = new ArrayList<String>();
    public ArrayList<String> myArrayListprop = new ArrayList<String>();
    private  ArrayList<Player> Players ;
    public  String[] Names;
    ImageIcon trade_logo = new ImageIcon(getClass().getResource("mischd/background.jpg"));

    public Trade_GUI(Hashtable<String, Player> players ,String[] Names) {
        Players = new ArrayList<Player>();
        this.Names=Names;
        this.setTitle("Trading");
        this.setResizable(false);
        this.setBounds(300, 300, 600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Container c = this.getContentPane();
        c.setLayout(null);
        
        if (show == false) {
            
        }
        else {
            for (int i = 0; i < 27; i++) {
                myArrayList.add(i, "train");
            }
            for (String element : myArrayList) {
                JCheckBox box = new JCheckBox(element);
                x = x + 20;
                box.setBounds(x, y, 20, 20);
                box.setSelected(false);
                box.setVisible(true);
                c.add(box);
            }
        }
            for (int i = 0; i < 27; i++) {
                myArrayListprop.add(i, "train");
            }
            for (String element : myArrayListprop) {
                JCheckBox box = new JCheckBox(element);
                v = v + 20;
                box.setBounds(v, w, 20, 20);
                box.setSelected(false);
                box.setVisible(true);
                c.add(box);
            }

        for (int i = 0; i < Names.length; i++) {
            Players.add(players.get(Names[i]));
        }
        //String[] ply = {"player 1", "player 2", "player 3", "player 4"};
        plylist = new JComboBox();
        plylist.setBounds(400, 50, 120, 40);
        plylist.addActionListener(plylist);
        
        for (int i = 0; i < Names.length; i++) {
            plylist.addItem(Names[i]);
        }
        c.add(plylist);

//        my_property = new JComboBox();
//        my_property.setBounds(225, 190, 120, 40);
//        my_property.addActionListener(my_property);
//        c.add(my_property);

        String[] mypro_mon = {"Money", "Property"};
        myproperty_money = new JComboBox(mypro_mon);
        myproperty_money.setBounds(225, 190, 120, 40);
        myproperty_money.setSelectedIndex(1);
        myproperty_money.addActionListener(myproperty_money);
        myproperty_money.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cbx = (JComboBox) e.getSource();
                String option = (String) cbx.getSelectedItem();
                if (option.equals("Money")) {
                    my_money.setVisible(true);
                    show = false;
                    
                } else {
                    show = true;
                    my_money.setVisible(false);
                }
            }
        }
        );
        c.add(myproperty_money);
        
        property = new JComboBox();
        property.setBounds(250, 50, 120, 40);
        property.setVisible(false);
        property.addActionListener(property);
        c.add(property);

        money = new JTextField("Enter amount");
        money.setBounds(250, 50, 120, 40);
        money.setVisible(false);
        c.add(money);

        my_money = new JTextField("Enter amount");
        my_money.setBounds(355, 190, 120, 40);
        my_money.setVisible(false);
        c.add(my_money);
        
        String[] pro_mon = {"Money", "Property"};
        property_money = new JComboBox(pro_mon);
        property_money.setBounds(100, 50, 120, 40);
        property_money.setSelectedIndex(1);
        property_money.addActionListener(property_money);
        property_money.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String option = (String) cb.getSelectedItem();
                if (option.equals("Money")) {
                    money.setVisible(true);
                    show = false;
                    
                } else {
                    show = true;
                    money.setVisible(false);
                }
            }
        }
        );
        c.add(property_money);

        trade = new JButton();
        trade.setText("Trade");
        trade.setBounds(150, 300, 120, 40);
        c.add(trade);

        cancel = new JButton();
        cancel.setText("Cancel");
        cancel.setBounds(300, 300, 120, 40);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Trade_GUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        }
        );
        c.add(cancel);

        yours = new JLabel("Your property/money to exchange");
        yours.setBounds(20, 200, 200, 40);
        c.add(yours);

        background = new JLabel(trade_logo);
        background.setBounds(0, 0, 600, 400);
        c.add(background);
    }
}