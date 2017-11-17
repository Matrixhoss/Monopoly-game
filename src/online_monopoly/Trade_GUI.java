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
    private JPanel PropertyPanel1 = new JPanel();
    private JScrollPane PropertyScroll1;
    private ArrayList<Property> PlayerProperties;
    private JScrollPane PropertyScroll2;
    private JPanel PropertyPanel2 = new JPanel();
    private ArrayList<JCheckBox> Selected1 = new ArrayList<JCheckBox>();
    private ArrayList<JCheckBox> Selected2 = new ArrayList<JCheckBox>();
    private JLabel CurruntPlayer;
    private JLabel OtherPlayer;
    private JLabel TradingWith;
    private JCheckBox moneycheck;
    private JCheckBox my_moneycheck;

    public Trade_GUI(Hashtable<String, Player> players, String[] Names, Player Me) {
        Players = new ArrayList<Player>();
        this.Names = Names;
        this.setTitle("Trading");
        this.setResizable(false);
        this.setBounds(300, 300, 600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Container c = this.getContentPane();
        c.setLayout(null);

        for (int i = 0; i < Names.length; i++) {    //get Arraylist of players
            if(players.get(Names[i]).name==Me.name)
                continue;
            Players.add(players.get(Names[i]));
        }

        plylist = new JComboBox();                  //Player's Drop box
        plylist.setBounds(230, 50, 120, 40);
        for (int i = 0; i < Players.size(); i++) {
            plylist.addItem(Players.get(i).name);
        }
        c.add(plylist);

        CurruntPlayer = new JLabel("Your items");
        CurruntPlayer.setBounds(50, 10, 100, 50);
        c.add(CurruntPlayer);

        OtherPlayer = new JLabel(plylist.getSelectedItem() + "'s items");
        OtherPlayer.setBounds(400, 10, 150, 50);
        c.add(OtherPlayer);

        TradingWith = new JLabel("TradingWith");
        TradingWith.setBounds(220, 10, 150, 50);
        c.add(TradingWith);
        
        moneycheck = new JCheckBox();
        moneycheck.setBounds(380,266,18,15);
        c.add(moneycheck);
        moneycheck.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(moneycheck.isSelected())
                my_moneycheck.setSelected(false);
            
            }});
        
        money = new JTextField("Enter Amount");
        money.setBounds(400, 260, 120, 30);
        c.add(money);
        money.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                money.setText("");
            }
        });
        
        my_moneycheck = new JCheckBox();
        my_moneycheck.setBounds(30,266,18,15);
        c.add(my_moneycheck);
        my_moneycheck.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(my_moneycheck.isSelected())
                moneycheck.setSelected(false);
            
            }});
        
        my_money = new JTextField("Enter Amount");
        my_money.setBounds(50, 260, 120, 30);
        c.add(my_money);
        my_money.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                my_money.setText("");
            }
        });

        PropertyScroll1 = new JScrollPane(PropertyPanel1);
        PropertyPanel1.setLayout(new BoxLayout(PropertyPanel1, BoxLayout.Y_AXIS));
        PropertyScroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        PropertyScroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        PropertyScroll1.setBounds(380, 50, 150, 200);
        c.add(PropertyScroll1);

        PropertyScroll2 = new JScrollPane(PropertyPanel2);
        PropertyPanel2.setLayout(new BoxLayout(PropertyPanel2, BoxLayout.Y_AXIS));
        PropertyScroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        PropertyScroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        PropertyScroll2.setBounds(30, 50, 150, 200);
        c.add(PropertyScroll2);
        
        for (int i = 0; i < Me.getProperties().size(); i++) {
                    JCheckBox box = new JCheckBox(Me.getProperties().get(i).getPropertyName());
                    y = 1;
                    box.setBounds(0, y + 1, 50, 5000);
                    Selected2.add(box);
                    PropertyPanel2.add(box);}

//        Players.get(0).addProperty(new NormalProperty("MediterraneanAvenue", 1, PropertyStander.P_MediterraneanAvenue, PropertyStander.V_MediterraneanAvenue, PropertyStander.R_MediterraneanAvenue, PropertyStander.M_MediterraneanAvenue, PropertyStander.BrownGroup, PropertyStander.BrownGroupNum, PropertyStander.H_MediterraneanAvenue));
//        Players.get(0).addProperty(new NormalProperty("OrientalAvenue", 6, PropertyStander.P_OrientalAvenue, PropertyStander.V_OrientalAvenue, PropertyStander.R_OrientalAvenue, PropertyStander.M_OrientalAvenue, PropertyStander.LightBlueGroup, PropertyStander.LightBlueGroupNum, PropertyStander.H_OrientalAvenue));
//        Players.get(1).addProperty(new NormalProperty("StJamesPlace", 16, PropertyStander.P_StJamesPlace, PropertyStander.V_StJamesPlace, PropertyStander.R_StJamesPlace, PropertyStander.M_StJamesPlace, PropertyStander.OrangeGroup, PropertyStander.OrangeGroupNum, PropertyStander.H_StJamesPlace));

        plylist.addActionListener(plylist);
        plylist.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PropertyPanel1.removeAll();
                PropertyPanel1.revalidate();
                PropertyPanel1.repaint();
                PropertyScroll1.revalidate();
                PropertyScroll1.repaint();
                for (int i = 0; i < players.get(plylist.getSelectedItem()).getProperties().size(); i++) {
                    OtherPlayer.setText(plylist.getSelectedItem() + "'s items");
                    JCheckBox box = new JCheckBox(players.get(plylist.getSelectedItem()).getProperties().get(i).getPropertyName());
                    y = 1;
                    box.setBounds(0, y + 1, 50, 5000);
                    Selected1.add(box);
                    PropertyPanel1.add(box);
                    PropertyPanel1.revalidate();
                    PropertyPanel1.repaint();
                    PropertyScroll1.revalidate();
                    PropertyScroll1.repaint();

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

        background = new JLabel(trade_logo);
        background.setBounds(0, 0, 600, 400);
        c.add(background);
    }
}
