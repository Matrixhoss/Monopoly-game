package online_monopoly;

import java.awt.Container;
import java.awt.FlowLayout;
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
//    public boolean show = true;
    int x = 0;
    int y = 95;
    int v = 0;
    int w = 230;
    public ArrayList<String> myArrayList = new ArrayList<String>();
    public ArrayList<String> myArrayListprop = new ArrayList<String>();
    private ArrayList<Player> Players;
    public String[] Names;
    ImageIcon trade_logo = new ImageIcon(getClass().getResource("mischd/background.jpg"));
    private JPanel PropertyPanel = new JPanel();
    private JScrollPane PropertyScroll;
    private ArrayList<Property> PlayerProperties;
    private ArrayList<JCheckBox> Selected1=new ArrayList<JCheckBox>();
    private ArrayList<JCheckBox> Selected2 =new ArrayList<JCheckBox>();

    public Trade_GUI(Hashtable<String, Player> players, String[] Names,Player Me) {
        Players = new ArrayList<Player>();
        this.Names = Names;
        this.setTitle("Trading");
        this.setResizable(false);
        this.setBounds(300, 300, 600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Container c = this.getContentPane();
        c.setLayout(null);

        for (int i = 0; i < 27; i++) {
            myArrayList.add(i, "train");
        }
//        for (String element : myArrayList) {
//            JCheckBox box = new JCheckBox(element);
//            x = x + 20;
//            box.setBounds(x, y, 20, 20);
//            box.setSelected(false);
//            box.setVisible(true);
//            c.add(box);
//        }
//        for (int i = 0; i < 27; i++) {
//            myArrayListprop.add(i, "train");
//        }
//        for (String element : myArrayListprop) {
//            JCheckBox box = new JCheckBox(element);
//            v = v + 20;
//            box.setBounds(v, w, 20, 20);
//            box.setSelected(false);
//            box.setVisible(true);
//            c.add(box);
//        }

        for (int i = 0; i < Names.length; i++) {
            Players.add(players.get(Names[i]));
        }
        plylist = new JComboBox();
        plylist.setBounds(400, 50, 120, 40);


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
//                    show = false;

                } else {
//                    show = true;
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
        property_money.addActionListener(  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String option = (String) cb.getSelectedItem();
                if (option.equals("Money")) {
                    money.setVisible(true);
//                    show = false;

                } else {
//                    show = true;
                    money.setVisible(false);
                }
            }
        }
        );
        c.add(property_money);

        PropertyScroll = new JScrollPane(PropertyPanel);
        PropertyPanel.setLayout(new BoxLayout(PropertyPanel, BoxLayout.Y_AXIS));
        PropertyScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        PropertyScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        PropertyScroll.setBounds(240, 50, 130, 100);
        c.add(PropertyScroll);


        Players.get(0).addProperty(new NormalProperty("MediterraneanAvenue", 1, PropertyStander.P_MediterraneanAvenue, PropertyStander.V_MediterraneanAvenue, PropertyStander.R_MediterraneanAvenue, PropertyStander.M_MediterraneanAvenue, PropertyStander.BrownGroup, PropertyStander.BrownGroupNum, PropertyStander.H_MediterraneanAvenue));
        Players.get(0).addProperty(new NormalProperty("OrientalAvenue", 6, PropertyStander.P_OrientalAvenue, PropertyStander.V_OrientalAvenue, PropertyStander.R_OrientalAvenue, PropertyStander.M_OrientalAvenue, PropertyStander.LightBlueGroup, PropertyStander.LightBlueGroupNum, PropertyStander.H_OrientalAvenue));
        Players.get(1).addProperty(new NormalProperty("StJamesPlace", 16, PropertyStander.P_StJamesPlace, PropertyStander.V_StJamesPlace, PropertyStander.R_StJamesPlace, PropertyStander.M_StJamesPlace, PropertyStander.OrangeGroup, PropertyStander.OrangeGroupNum, PropertyStander.H_StJamesPlace));

        plylist.addActionListener(plylist);
        plylist.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PropertyPanel.removeAll();
                PropertyPanel.revalidate();
                PropertyPanel.repaint();
                PropertyScroll.revalidate();
                PropertyScroll.repaint();
                for (int i = 0; i < players.get(plylist.getSelectedItem()).getProperties().size(); i++) {
                   JCheckBox box=new JCheckBox(players.get(plylist.getSelectedItem()).getProperties().get(i).getPropertyName());
                    y = 1;
                    box.setBounds(0, y + 1, 50, 5000);
                    Selected1.add(box);
                    PropertyPanel.add(box);
                    PropertyPanel.revalidate();
                    PropertyPanel.repaint();
                    PropertyScroll.revalidate();
                    PropertyScroll.repaint();
                    
                }
            }
        }
        );
        
        
         
      

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
