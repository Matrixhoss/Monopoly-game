package online_monopoly;
import java.awt.*;
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

public class Mainboard_GUI_HD extends JFrame implements GUIInterface{
    
    private Mainboard_GUI_HD _this = this; 
    
    private Controller controller;
    private HashMap<String,Point> playersPos;
    public int x, y;
    public JLabel zoom = new JLabel();
    public JLabel background;
    // public JLabel ff;
    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    public JButton b5;
    public JButton b6;
    public JButton b7;
    public JButton b8;
    public JButton b9;
    public JButton b10;
    public JButton b11;
    public JButton b12;
    public JButton b13;
    public JButton b14;
    public JButton b15;
    public JButton b16;
    public JButton b17;
    public JButton b18;
    public JButton b19;
    public JButton b20;
    public JButton b21;
    public JButton b22;
    public JButton b23;
    public JButton b24;
    public JButton b25;
    public JButton b26;
    public JButton b27;
    public JButton b28;
    public JButton b29;
    public JButton b30;
    public JButton b31;
    public JButton b32;
    public JButton b33;
    public JButton b34;
    public JButton b35;
    public JButton b36;
    public JButton b37;
    public JButton b38;
    public JButton b39;
    public JButton b40;

    ImageIcon board = new ImageIcon(getClass().getResource("mischd/monoi.png"));
    ImageIcon p1 = new ImageIcon(getClass().getResource("mischd/1.png"));
    ImageIcon p2 = new ImageIcon(getClass().getResource("mischd/2.png"));
    ImageIcon p3 = new ImageIcon(getClass().getResource("mischd/3.png"));
    ImageIcon p4 = new ImageIcon(getClass().getResource("mischd/4.png"));
    ImageIcon p5 = new ImageIcon(getClass().getResource("mischd/5.png"));
    ImageIcon p6 = new ImageIcon(getClass().getResource("mischd/6.png"));
    ImageIcon p7 = new ImageIcon(getClass().getResource("mischd/7.png"));
    ImageIcon p8 = new ImageIcon(getClass().getResource("mischd/8.png"));
    ImageIcon p9 = new ImageIcon(getClass().getResource("mischd/9.png"));
    ImageIcon p10 = new ImageIcon(getClass().getResource("mischd/10.png"));
    ImageIcon p11 = new ImageIcon(getClass().getResource("mischd/11.png"));
    ImageIcon p12 = new ImageIcon(getClass().getResource("mischd/12.png"));
    ImageIcon p13 = new ImageIcon(getClass().getResource("mischd/13.png"));
    ImageIcon p14 = new ImageIcon(getClass().getResource("mischd/14.png"));
    ImageIcon p15 = new ImageIcon(getClass().getResource("mischd/15.png"));
    ImageIcon p16 = new ImageIcon(getClass().getResource("mischd/16.png"));
    ImageIcon p17 = new ImageIcon(getClass().getResource("mischd/17.png"));
    ImageIcon p18 = new ImageIcon(getClass().getResource("mischd/18.png"));
    ImageIcon p19 = new ImageIcon(getClass().getResource("mischd/19.png"));
    ImageIcon p20 = new ImageIcon(getClass().getResource("mischd/20.png"));
    ImageIcon p21 = new ImageIcon(getClass().getResource("mischd/21.png"));
    ImageIcon p22 = new ImageIcon(getClass().getResource("mischd/22.png"));
    ImageIcon p23 = new ImageIcon(getClass().getResource("mischd/23.png"));
    ImageIcon p24 = new ImageIcon(getClass().getResource("mischd/24.png"));
    ImageIcon p25 = new ImageIcon(getClass().getResource("mischd/25.png"));
    ImageIcon p26 = new ImageIcon(getClass().getResource("mischd/26.png"));
    ImageIcon p27 = new ImageIcon(getClass().getResource("mischd/27.png"));
    ImageIcon p28 = new ImageIcon(getClass().getResource("mischd/28.png"));
    ImageIcon p29 = new ImageIcon(getClass().getResource("mischd/29.png"));
    ImageIcon p30 = new ImageIcon(getClass().getResource("mischd/30.png"));
    ImageIcon p31 = new ImageIcon(getClass().getResource("mischd/31.png"));
    ImageIcon p32 = new ImageIcon(getClass().getResource("mischd/32.png"));
    ImageIcon p33 = new ImageIcon(getClass().getResource("mischd/33.png"));
    ImageIcon p34 = new ImageIcon(getClass().getResource("mischd/34.png"));
    ImageIcon p35 = new ImageIcon(getClass().getResource("mischd/35.png"));
    ImageIcon p36 = new ImageIcon(getClass().getResource("mischd/36.png"));
    ImageIcon p37 = new ImageIcon(getClass().getResource("mischd/37.png"));
    ImageIcon p38 = new ImageIcon(getClass().getResource("mischd/38.png"));
    ImageIcon p39 = new ImageIcon(getClass().getResource("mischd/39.png"));
    ImageIcon p40 = new ImageIcon(getClass().getResource("mischd/40.png"));

    ImageIcon z1 = new ImageIcon(getClass().getResource("mischd/z1.gif"));
    ImageIcon z2 = new ImageIcon(getClass().getResource("mischd/z2.png"));
    ImageIcon z3 = new ImageIcon(getClass().getResource("mischd/z3.jpg"));
    ImageIcon z4 = new ImageIcon(getClass().getResource("mischd/z4.jpg"));
    ImageIcon z5 = new ImageIcon(getClass().getResource("mischd/z5.jpg"));
    ImageIcon z6 = new ImageIcon(getClass().getResource("mischd/z6.jpg"));
    ImageIcon z7 = new ImageIcon(getClass().getResource("mischd/z7.JPG"));
    ImageIcon z8 = new ImageIcon(getClass().getResource("mischd/z8.jpg"));
    ImageIcon z9 = new ImageIcon(getClass().getResource("mischd/z9.jpg"));
    ImageIcon z10 = new ImageIcon(getClass().getResource("mischd/z10.jpg"));
    ImageIcon z11 = new ImageIcon(getClass().getResource("mischd/z11.jpg"));
    ImageIcon z12 = new ImageIcon(getClass().getResource("mischd/z12.jpg"));
    ImageIcon z13 = new ImageIcon(getClass().getResource("mischd/z13.jpg"));
    ImageIcon z14 = new ImageIcon(getClass().getResource("mischd/z14.jpeg"));
    ImageIcon z15 = new ImageIcon(getClass().getResource("mischd/z15.jpg"));
    ImageIcon z16 = new ImageIcon(getClass().getResource("mischd/z16.jpg"));
    ImageIcon z17 = new ImageIcon(getClass().getResource("mischd/z17.jpeg"));
    ImageIcon z18 = new ImageIcon(getClass().getResource("mischd/z3.jpg"));
    ImageIcon z19 = new ImageIcon(getClass().getResource("mischd/z19.jpg"));
    ImageIcon z20 = new ImageIcon(getClass().getResource("mischd/z20.jpg"));
    ImageIcon z21 = new ImageIcon(getClass().getResource("mischd/z21.jpg"));
    ImageIcon z22 = new ImageIcon(getClass().getResource("mischd/z22.jpg"));
    ImageIcon z23 = new ImageIcon(getClass().getResource("mischd/z8.jpg"));
    ImageIcon z24 = new ImageIcon(getClass().getResource("mischd/z24.jpg"));
    ImageIcon z25 = new ImageIcon(getClass().getResource("mischd/z25.jpg"));
    ImageIcon z26 = new ImageIcon(getClass().getResource("mischd/z26.jpg"));
    ImageIcon z27 = new ImageIcon(getClass().getResource("mischd/z27.jpg"));
    ImageIcon z28 = new ImageIcon(getClass().getResource("mischd/z28.jpeg"));
    ImageIcon z29 = new ImageIcon(getClass().getResource("mischd/z29.jpg"));
    ImageIcon z30 = new ImageIcon(getClass().getResource("mischd/z30.jpg"));
    ImageIcon z31 = new ImageIcon(getClass().getResource("mischd/z31.jpg"));
    ImageIcon z32 = new ImageIcon(getClass().getResource("mischd/z32.jpg"));
    ImageIcon z33 = new ImageIcon(getClass().getResource("mischd/z33.jpg"));
    ImageIcon z34 = new ImageIcon(getClass().getResource("mischd/z3.jpg"));
    ImageIcon z35 = new ImageIcon(getClass().getResource("mischd/z35.jpg"));
    ImageIcon z36 = new ImageIcon(getClass().getResource("mischd/z36.jpg"));
    ImageIcon z37 = new ImageIcon(getClass().getResource("mischd/z8.jpg"));
    ImageIcon z38 = new ImageIcon(getClass().getResource("mischd/z38.jpg"));
    ImageIcon z39 = new ImageIcon(getClass().getResource("mischd/z39.jpg"));
    ImageIcon z40 = new ImageIcon(getClass().getResource("mischd/z40.jpg"));

    
    public JLabel CommunityLbl;
    ImageIcon communi_s = new ImageIcon(getClass().getResource("mischd/community_shd.png"));

    public JLabel CommunityCard;
    ImageIcon communi_1 = new ImageIcon(getClass().getResource("mischd/communtiy_cardhs.png"));

    boolean moveComm = false;
    boolean backcomm = false;
    int countCommmoves = 0;
    
    
    public JLabel ChanceLbl;
    ImageIcon chance_s = new ImageIcon(getClass().getResource("mischd/chance_hdgrop.png"));

    public JLabel chanceCard;
    ImageIcon chance_1 = new ImageIcon(getClass().getResource("mischd/chance_hd.png"));

    boolean moveChance = false;
    boolean backChance = false;
    int countChancemoves = 0;
    
    public Mainboard_GUI_HD(int x, int y) {
        this.x = x;
        this.y = y;
        
        
        controller = new Controller();
        controller.addGUI(this);
        
        playersPos = new HashMap<String, Point>();
        
        playersPos.put("fadi", new Point(0, 0));
        
        _this = this;
        this.setTitle("Monopoly");
        this.setResizable(false);
        this.setBounds(0, 0, 700, 725);
//        this.setSize( Toolkit.getDefaultToolkit().getScreenSize() );
//        this.setUndecorated(true);
//        this.setAlwaysOnTop(true);
//        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);

        zoom.setBounds(190, 100, 199, 300);
        zoom.setVisible(true);

        b1 = new JButton(p1);
        b1.setBackground(Color.BLACK);
        b1.setBounds(620, 620, 80, 80);
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });

        c.add(b1);

        b2 = new JButton(p2);
        b2.setBackground(Color.BLACK);
        b2.setBounds(560, 620, 60, 80);
        b2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b2);

        b3 = new JButton(p3);
        b3.setBackground(Color.BLACK);
        b3.setBounds(500, 620, 60, 80);
        b3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z3);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b3);

        b4 = new JButton(p4);
        b4.setBackground(Color.BLACK);
        b4.setBounds(440, 620, 60, 80);
        b4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z4);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b4);

        b5 = new JButton(p5);
        b5.setBackground(Color.BLACK);
        b5.setBounds(380, 620, 60, 80);
        b5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z5);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b5);

        b6 = new JButton(p6);
        b6.setBackground(Color.BLACK);
        b6.setBounds(320, 620, 60, 80);
        b6.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z6);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b6);

        b7 = new JButton(p7);
        b7.setBackground(Color.BLACK);
        b7.setBounds(260, 620, 60, 80);
        b7.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z7);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b7);

        b8 = new JButton(p8);
        b8.setBackground(Color.BLACK);
        b8.setBounds(200, 620, 60, 80);
        b8.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z8);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b8);

        b9 = new JButton(p9);
        b9.setBackground(Color.BLACK);
        b9.setBounds(140, 620, 60, 80);
        b9.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z9);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b9);

        b10 = new JButton(p10);
        b10.setBackground(Color.BLACK);
        b10.setBounds(80, 620, 60, 80);
        b10.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z10);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b10);

        b11 = new JButton(p11);
        b11.setBackground(Color.BLACK);
        b11.setBounds(0, 620, 80, 80);
        b11.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z11);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b11);

        b12 = new JButton(p12);
        b12.setBackground(Color.BLACK);
        b12.setBounds(0, 560, 80, 60);
        b12.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z12);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b12);

        b13 = new JButton(p13);
        b13.setBackground(Color.BLACK);
        b13.setBounds(0, 500, 80, 60);
        b13.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z13);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b13);

        b14 = new JButton(p14);
        b14.setBackground(Color.BLACK);
        b14.setBounds(0, 440, 80, 60);
        b14.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z14);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b14);

        b15 = new JButton(p15);
        b15.setBackground(Color.BLACK);
        b15.setBounds(0, 380, 80, 60);
        b15.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z15);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b15);

        b16 = new JButton(p16);
        b16.setBackground(Color.BLACK);
        b16.setBounds(0, 320, 80, 60);
        b16.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z16);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b16);

        b17 = new JButton(p17);
        b17.setBackground(Color.BLACK);
        b17.setBounds(0, 260, 80, 60);
        b17.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z17);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b17);

        b18 = new JButton(p18);
        b18.setBackground(Color.BLACK);
        b18.setBounds(0, 200, 80, 60);
        b18.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z18);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b18);

        b19 = new JButton(p19);
        b19.setBackground(Color.BLACK);
        b19.setBounds(0, 140, 80, 60);
        b19.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z19);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b19);

        b20 = new JButton(p20);
        b20.setBackground(Color.BLACK);
        b20.setBounds(0, 80, 80, 60);
        b20.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z20);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b20);

        b21 = new JButton(p21);
        b21.setBackground(Color.BLACK);
        b21.setBounds(0, 0, 80, 80);
        b21.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z21);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b21);

        b22 = new JButton(p22);
        b22.setBackground(Color.BLACK);
        b22.setBounds(80, 0, 60, 80);
        b22.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z22);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b22);

        b23 = new JButton(p23);
        b23.setBackground(Color.BLACK);
        b23.setBounds(140, 0, 60, 80);
        b23.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z23);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b23);

        b24 = new JButton(p24);
        b24.setBackground(Color.BLACK);
        b24.setBounds(200, 0, 60, 80);
        b24.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z24);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b24);

        b25 = new JButton(p25);
        b25.setBackground(Color.BLACK);
        b25.setBounds(260, 0, 60, 80);
        b25.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z25);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b25);

        b26 = new JButton(p26);
        b26.setBackground(Color.BLACK);
        b26.setBounds(320, 0, 60, 80);
        b26.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z26);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b26);

        b27 = new JButton(p27);
        b27.setBackground(Color.BLACK);
        b27.setBounds(380, 0, 60, 80);
        b27.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z27);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b27);

        b28 = new JButton(p28);
        b28.setBackground(Color.BLACK);
        b28.setBounds(440, 0, 60, 80);
        b28.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z28);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b28);

        b29 = new JButton(p29);
        b29.setBackground(Color.BLACK);
        b29.setBounds(500, 0, 60, 80);
        b29.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z29);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b29);

        b30 = new JButton(p30);
        b30.setBackground(Color.BLACK);
        b30.setBounds(560, 0, 60, 80);
        b30.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z30);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b30);

        b31 = new JButton(p31);
        b31.setBackground(Color.BLACK);
        b31.setBounds(620, 0, 80, 80);
        b31.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z31);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b31);

        b32 = new JButton(p32);
        b32.setBackground(Color.BLACK);
        b32.setBounds(620, 80, 80, 60);
        b32.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z32);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b32);

        b33 = new JButton(p33);
        b33.setBackground(Color.BLACK);
        b33.setBounds(620, 140, 80, 60);
        b33.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z33);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b33);

        b34 = new JButton(p34);
        b34.setBackground(Color.BLACK);
        b34.setBounds(620, 200, 80, 60);
        b34.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z34);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b34);

        b35 = new JButton(p35);
        b35.setBackground(Color.BLACK);
        b35.setBounds(620, 260, 80, 60);
        b35.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z35);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b35);

        b36 = new JButton(p36);
        b36.setBackground(Color.BLACK);
        b36.setBounds(620, 320, 80, 60);
        b36.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z36);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b36);

        b37 = new JButton(p37);
        b37.setBackground(Color.BLACK);
        b37.setBounds(620, 380, 80, 60);
        b37.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z37);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b37);

        b38 = new JButton(p38);
        b38.setBackground(Color.BLACK);
        b38.setBounds(620, 440, 80, 60);
        b38.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z38);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b38);

        b39 = new JButton(p39);
        b39.setBackground(Color.BLACK);
        b39.setBounds(620, 500, 80, 60);
        b39.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z39);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b39);

        b40 = new JButton(p40);
        b40.setBackground(Color.BLACK);
        b40.setBounds(620, 560, 80, 60);
        b40.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent mEvt) {
                //System.out.println("mouse entered");
                ZoomButton(mEvt, z40);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton(e);
            }
        });
        c.add(b40);
 
        //community lbl
        chanceCard = new JLabel(chance_1);
        chanceCard.setBounds(275, 640, 202, 201);
        c.add(chanceCard);
        ChanceLbl = new JLabel(chance_s);
        ChanceLbl.setBounds(220, 640, 151, 145);
        c.add(ChanceLbl);
        
        //community lbl
        CommunityCard = new JLabel(communi_1);
        CommunityCard.setBounds(135, 155, 202, 201);
        c.add(CommunityCard);
        CommunityLbl = new JLabel(communi_s);
        CommunityLbl.setBounds(135, 155, 240, 203);
        c.add(CommunityLbl);
        
        //dice panel
        DiceGui diceGui = new DiceGui(controller);
        diceGui.setBounds(475, 80, 150, 120);
        c.add(diceGui);

        background = new JLabel(board);
        background.setBounds(80, 80, 540, 540);
        c.add(background);
        background.add(zoom);
        this.setLocationRelativeTo(c);
    }

    private Image ScaledImage(Image img, int w, int h) {
        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizedImage;
    }

    //This returns the Point2D that corresponds to the location to draw the characters on the map
    public Mainboard_GUI getpoint(int location) {
        Mainboard_GUI pt = new Mainboard_GUI(x, y);
        switch (location) {
            case 0:
                pt = new Mainboard_GUI(900, 900);
                break;
            case 1:
                pt = new Mainboard_GUI(800, 900);
                break;
            case 2:
                pt = new Mainboard_GUI(700, 900);
                break;
            case 3:
                pt = new Mainboard_GUI(1005, 1415);
                break;
            case 4:
                pt = new Mainboard_GUI(870, 1415);
                break;
            case 5:
                pt = new Mainboard_GUI(750, 1415);
                break;
            case 6:
                pt = new Mainboard_GUI(630, 1415);
                break;
            case 7:
                pt = new Mainboard_GUI(500, 1415);
                break;
            case 8:
                pt = new Mainboard_GUI(380, 1415);
                break;
            case 9:
                pt = new Mainboard_GUI(260, 1415);
                break;
            case 10:
                pt = new Mainboard_GUI(30, 1470);
                break;
            case 11:
                pt = new Mainboard_GUI(75, 1240);
                break;
            case 12:
                pt = new Mainboard_GUI(75, 1120);
                break;
            case 13:
                pt = new Mainboard_GUI(75, 1000);
                break;
            case 14:
                pt = new Mainboard_GUI(75, 880);
                break;
            case 15:
                pt = new Mainboard_GUI(75, 750);
                break;
            case 16:
                pt = new Mainboard_GUI(75, 630);
                break;
            case 17:
                pt = new Mainboard_GUI(75, 510);
                break;
            case 18:
                pt = new Mainboard_GUI(75, 390);
                break;
            case 19:
                pt = new Mainboard_GUI(75, 260);
                break;
            case 20:
                pt = new Mainboard_GUI(100, 100);
                break;
            case 21:
                pt = new Mainboard_GUI(260, 75);
                break;
            case 22:
                pt = new Mainboard_GUI(380, 75);
                break;
            case 23:
                pt = new Mainboard_GUI(500, 75);
                break;
            case 24:
                pt = new Mainboard_GUI(630, 75);
                break;
            case 25:
                pt = new Mainboard_GUI(750, 75);
                break;
            case 26:
                pt = new Mainboard_GUI(870, 75);
                break;
            case 27:
                pt = new Mainboard_GUI(1005, 75);
                break;
            case 28:
                pt = new Mainboard_GUI(1125, 75);
                break;
            case 29:
                pt = new Mainboard_GUI(1245, 75);
                break;
            case 30:
                pt = new Mainboard_GUI(130, 1370);
                break;
            case 31:
                pt = new Mainboard_GUI(1415, 260);
                break;
            case 32:
                pt = new Mainboard_GUI(1415, 390);
                break;
            case 33:
                pt = new Mainboard_GUI(1415, 510);
                break;
            case 34:
                pt = new Mainboard_GUI(1415, 630);
                break;
            case 35:
                pt = new Mainboard_GUI(1415, 750);
                break;
            case 36:
                pt = new Mainboard_GUI(1415, 880);
                break;
            case 37:
                pt = new Mainboard_GUI(1415, 1000);
                break;
            case 38:
                pt = new Mainboard_GUI(1415, 1120);
                break;
            case 39:
                pt = new Mainboard_GUI(1415, 1240);
                break;
        }
        return pt;
    }

    public static String getName(int location) {
        String rtn = "";
        switch (location) {
            case 0:
                rtn = "Go";
                break;
            case 1:
                rtn = "Mediterranean Avenue";
                break;
            case 2:
                rtn = "Community Chest";
                break;
            case 3:
                rtn = "Baltic Avenue";
                break;
            case 4:
                rtn = "Income Tax";
                break;
            case 5:
                rtn = "Reading Railroad";
                break;
            case 6:
                rtn = "Oriental Avenue";
                break;
            case 7:
                rtn = "Chance";
                break;
            case 8:
                rtn = "Vermont Avenue";
                break;
            case 9:
                rtn = "Connecticut Avenue";
                break;
            case 10:
                rtn = "Just Visiting";
                break;
            case 11:
                rtn = "St. Charles Place";
                break;
            case 12:
                rtn = "Electric Company";
                break;
            case 13:
                rtn = "States Avenue";
                break;
            case 14:
                rtn = "Virginia Avenue";
                break;
            case 15:
                rtn = "Pennsylvania Railroad";
                break;
            case 16:
                rtn = "St. James Place";
                break;
            case 17:
                rtn = "Community Chest";
                break;
            case 18:
                rtn = "Tennessee Avenue";
                break;
            case 19:
                rtn = "New York Avenue";
                break;
            case 20:
                rtn = "Free Parking";
                break;
            case 21:
                rtn = "Kentucky Avenue";
                break;
            case 22:
                rtn = "Chance";
                break;
            case 23:
                rtn = "Indiana Avenue";
                break;
            case 24:
                rtn = "Illinois Avenue";
                break;
            case 25:
                rtn = "B. & O. Railroad";
                break;
            case 26:
                rtn = "Atlantic Avenue";
                break;
            case 27:
                rtn = "Ventnor Avenue";
                break;
            case 28:
                rtn = "Water Works";
                break;
            case 29:
                rtn = "Marvin Gardens";
                break;
            case 30:
                rtn = "Jail";
                break;
            case 31:
                rtn = "Pacific Avenue";
                break;
            case 32:
                rtn = "North Carolina Avenue";
                break;
            case 33:
                rtn = "Community Chest";
                break;
            case 34:
                rtn = "Pennsylvania Avenue";
                break;
            case 35:
                rtn = "Short Line";
                break;
            case 36:
                rtn = "Chance";
                break;
            case 37:
                rtn = "Park Place";
                break;
            case 38:
                rtn = "Luxury Tax";
                break;
            case 39:
                rtn = "Boardwalk";
                break;
        }
        return rtn;
    }

    public void ZoomButton(MouseEvent mEvt, ImageIcon z) {
        zoom.setIcon(z);
        zoom.repaint();
        if (mEvt.getModifiers() == MouseEvent.BUTTON1_MASK) {
            System.out.println("Mouse dragging as entered");
        }
    }

    public void exitButton(MouseEvent mExt) {
        zoom.setIcon(null);
        zoom.repaint();
        if (mExt.getModifiers() == MouseEvent.BUTTON1_MASK) {
            System.out.println("Mouse dragging as entered");
        }
    }
    
    public void pullCommunityCard(String card) {
        moveComm = true;
        repaint();
        Component ff = this;
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(ff, card);
                CommunityCard.setVisible(true);
                backcomm = true;
                repaint();

            }
        },
                1000
        );
    }
    
    public void pullChanceCard(String card) {
        moveChance = true;
        repaint();
        Component ff = this;
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(ff, card);
                chanceCard.setVisible(true);
                backChance = true;
                repaint();

            }
        },
                1000
        );
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 50, 50);
        //keroo
        if (moveComm) {
            CommunityCard.setBounds(CommunityCard.getBounds().x + 2, CommunityCard.getBounds().y + 2, 143, 139);
            if (CommunityCard.getBounds().x < 390) {
                countCommmoves++;
                repaint();
            } else {
                CommunityCard.setVisible(false);
                moveComm = false;
                System.out.println(countCommmoves);
            }
        }
        if (backcomm) {
            CommunityCard.setBounds(CommunityCard.getBounds().x - 2, CommunityCard.getBounds().y - 2, 143, 139);

            if (countCommmoves > 0) {
                countCommmoves--;
                repaint();

            } else {
                backcomm = false;

            }
        }
        
        
        if (moveChance) {
            chanceCard.setBounds(chanceCard.getBounds().x - 2, chanceCard.getBounds().y - 2, 151, 145);
            if (chanceCard.getBounds().x > 425) {
                countChancemoves++;
                repaint();
            } else {
                chanceCard.setVisible(false);
                moveChance = false;
                System.out.println(countChancemoves);
            }
        }
        if (backChance) {
            chanceCard.setBounds(chanceCard.getBounds().x + 2, chanceCard.getBounds().y + 2, 151, 145);

            if (countChancemoves > 0) {
                countChancemoves--;
                repaint();

            } else {
                backChance = false;

            }
        }
    }
    
   
    
    @Override
    public void animatePlayer(String name, int destination, int origin){
        javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
}
