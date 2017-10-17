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

public class Mainboard_GUI extends JFrame{
    public int x,y;
    public JLabel zoom;
    public JLabel background;
    public JLabel ff;
    public JFrame _this;
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
    
    
    ImageIcon board= new ImageIcon(getClass().getResource("misc/monoi.png"));
    ImageIcon p1= new ImageIcon(getClass().getResource("misc/1.png"));
    ImageIcon p2= new ImageIcon(getClass().getResource("misc/2.png"));
    ImageIcon p3= new ImageIcon(getClass().getResource("misc/3.png"));
    ImageIcon p4= new ImageIcon(getClass().getResource("misc/4.png"));
    ImageIcon p5= new ImageIcon(getClass().getResource("misc/5.png"));
    ImageIcon p6= new ImageIcon(getClass().getResource("misc/6.png"));
    ImageIcon p7= new ImageIcon(getClass().getResource("misc/7.png"));
    ImageIcon p8= new ImageIcon(getClass().getResource("misc/8.png"));
    ImageIcon p9= new ImageIcon(getClass().getResource("misc/9.png"));
    ImageIcon p10= new ImageIcon(getClass().getResource("misc/10.png"));
    ImageIcon p11= new ImageIcon(getClass().getResource("misc/11.png"));
    ImageIcon p12= new ImageIcon(getClass().getResource("misc/12.png"));
    ImageIcon p13= new ImageIcon(getClass().getResource("misc/13.png"));
    ImageIcon p14= new ImageIcon(getClass().getResource("misc/14.png"));
    ImageIcon p15= new ImageIcon(getClass().getResource("misc/15.png"));
    ImageIcon p16= new ImageIcon(getClass().getResource("misc/16.png"));
    ImageIcon p17= new ImageIcon(getClass().getResource("misc/17.png"));
    ImageIcon p18= new ImageIcon(getClass().getResource("misc/18.png"));
    ImageIcon p19= new ImageIcon(getClass().getResource("misc/19.png"));
    ImageIcon p20= new ImageIcon(getClass().getResource("misc/20.png"));
    ImageIcon p21= new ImageIcon(getClass().getResource("misc/21.png"));
    ImageIcon p22= new ImageIcon(getClass().getResource("misc/22.png"));
    ImageIcon p23= new ImageIcon(getClass().getResource("misc/23.png"));
    ImageIcon p24= new ImageIcon(getClass().getResource("misc/24.png"));
    ImageIcon p25= new ImageIcon(getClass().getResource("misc/25.png"));
    ImageIcon p26= new ImageIcon(getClass().getResource("misc/26.png"));
    ImageIcon p27= new ImageIcon(getClass().getResource("misc/27.png"));
    ImageIcon p28= new ImageIcon(getClass().getResource("misc/28.png"));
    ImageIcon p29= new ImageIcon(getClass().getResource("misc/29.png"));
    ImageIcon p30= new ImageIcon(getClass().getResource("misc/30.png"));
    ImageIcon p31= new ImageIcon(getClass().getResource("misc/31.png"));
    ImageIcon p32= new ImageIcon(getClass().getResource("misc/32.png"));
    ImageIcon p33= new ImageIcon(getClass().getResource("misc/33.png"));
    ImageIcon p34= new ImageIcon(getClass().getResource("misc/34.png"));
    ImageIcon p35= new ImageIcon(getClass().getResource("misc/35.png"));
    ImageIcon p36= new ImageIcon(getClass().getResource("misc/36.png"));
    ImageIcon p37= new ImageIcon(getClass().getResource("misc/37.png"));
    ImageIcon p38= new ImageIcon(getClass().getResource("misc/38.png"));
    ImageIcon p39= new ImageIcon(getClass().getResource("misc/39.png"));
    ImageIcon p40= new ImageIcon(getClass().getResource("misc/40.png"));
    ImageIcon t1= new ImageIcon(getClass().getResource("misc/test.jpg"));
    ImageIcon t2= new ImageIcon(getClass().getResource("misc/Go-.gif"));
    
    public Mainboard_GUI(int x, int y){
        this.x=x;
        this.y=y;
        
        _this=this;
        this.setTitle("Monopoly");
        this.setResizable(false);
        this.setBounds(0,0, 1017, 1037);
//        this.setSize( Toolkit.getDefaultToolkit().getScreenSize() );
//        this.setUndecorated(true);
//        this.setAlwaysOnTop(true);
//        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);
        
        b1 = new JButton(p1);
        b1.setBackground(Color.BLACK);
        b1.setBounds(884, 882, 128, 128);
        b1.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //ScaledImage(p40.getImage(), zoom.getWidth(), zoom.getHeight());
//                    zoom = new JLabel(board);
//                    zoom.setBounds(1017, 1017, 200, 200);
//                    c.add(zoom);
                    //String backupDir = "/Users/al/backups";
    
                    // create a jframe
                    JFrame frame = new JFrame("misc/Go");
                    // show a joptionpane dialog using showMessageDialog
                    JOptionPane.showMessageDialog(frame,"Player recieve 200$ as he pass","GO",JOptionPane.INFORMATION_MESSAGE, t2);

                }
            }
        );
        c.add(b1);
        
        b2 = new JButton(p2);
        b2.setBackground(Color.BLACK);
        b2.setBounds(800, 882, 84, 128);
        c.add(b2);
        
        b3 = new JButton(p3);
        b3.setBackground(Color.BLACK);
        b3.setBounds(716, 882, 84, 128);
        c.add(b3);
        
        b4 = new JButton(p4);
        b4.setBackground(Color.BLACK);
        b4.setBounds(632, 882, 84, 128);
        c.add(b4);
        
        b5 = new JButton(p5);
        b5.setBackground(Color.BLACK);
        b5.setBounds(548, 882, 84, 128);
        c.add(b5);
        
        b6 = new JButton(p6);
        b6.setBackground(Color.BLACK);
        b6.setBounds(464, 882, 84, 128);
        c.add(b6);
        
        b7 = new JButton(p7);
        b7.setBackground(Color.BLACK);
        b7.setBounds(380, 882, 84, 128);
        c.add(b7);
        
        b8 = new JButton(p8);
        b8.setBackground(Color.BLACK);
        b8.setBounds(296, 882, 84, 128);
        c.add(b8);
        
        b9 = new JButton(p9);
        b9.setBackground(Color.BLACK);
        b9.setBounds(212, 882, 84, 128);
        c.add(b9);
        
        b10 = new JButton(p10);
        b10.setBackground(Color.BLACK);
        b10.setBounds(128, 882, 84, 128);
        c.add(b10);
        
        b11 = new JButton(p11);
        b11.setBackground(Color.BLACK);
        b11.setBounds(0, 882, 128, 128);
        c.add(b11);
        
        b12 = new JButton(p12);
        b12.setBackground(Color.BLACK);
        b12.setBounds(0, 798, 128, 84);
        c.add(b12);
        
        b13 = new JButton(p13);
        b13.setBackground(Color.BLACK);
        b13.setBounds(0, 714, 128, 84);
        c.add(b13);
        
        b14 = new JButton(p14);
        b14.setBackground(Color.BLACK);
        b14.setBounds(0, 630, 128, 84);
        c.add(b14);
        
        b15 = new JButton(p15);
        b15.setBackground(Color.BLACK);
        b15.setBounds(0, 546, 128, 84);
        c.add(b15);
        
        b16 = new JButton(p16);
        b16.setBackground(Color.BLACK);
        b16.setBounds(0, 462, 128, 84);
        c.add(b16);
        
        b17 = new JButton(p17);
        b17.setBackground(Color.BLACK);
        b17.setBounds(0, 378, 128, 84);
        c.add(b17);
        
        b18 = new JButton(p18);
        b18.setBackground(Color.BLACK);
        b18.setBounds(0, 294, 128, 84);
        c.add(b18);
        
        b19 = new JButton(p19);
        b19.setBackground(Color.BLACK);
        b19.setBounds(0, 210, 128, 84);
        c.add(b19);
        
        b20 = new JButton(p20);
        b20.setBackground(Color.BLACK);
        b20.setBounds(0, 126, 128, 84);
        c.add(b20);
        
        b21 = new JButton(p21);
        b21.setBackground(Color.BLACK);
        b21.setBounds(0, 0, 128, 128);
        c.add(b21);
        
        b22 = new JButton(p22);
        b22.setBackground(Color.BLACK);
        b22.setBounds(128, 0, 84, 128);
        c.add(b22);
        
        b23 = new JButton(p23);
        b23.setBackground(Color.BLACK);
        b23.setBounds(212, 0, 84, 128);
        c.add(b23);
        
        b24 = new JButton(p24);
        b24.setBackground(Color.BLACK);
        b24.setBounds(296, 0, 84, 128);
        c.add(b24);
        
        b25 = new JButton(p25);
        b25.setBackground(Color.BLACK);
        b25.setBounds(380, 0, 84, 128);
        c.add(b25);
        
        b26 = new JButton(p26);
        b26.setBackground(Color.BLACK);
        b26.setBounds(464, 0, 84, 128);
        c.add(b26);
        
        b27 = new JButton(p27);
        b27.setBackground(Color.BLACK);
        b27.setBounds(548, 0, 84, 128);
        c.add(b27);
        
        b28 = new JButton(p28);
        b28.setBackground(Color.BLACK);
        b28.setBounds(632, 0, 84, 128);
        c.add(b28);
        
        b29 = new JButton(p29);
        b29.setBackground(Color.BLACK);
        b29.setBounds(716, 0, 84, 128);
        c.add(b29);
        
        b30 = new JButton(p30);
        b30.setBackground(Color.BLACK);
        b30.setBounds(800, 0, 84, 128);
        c.add(b30);
        
        b31 = new JButton(p31);
        b31.setBackground(Color.BLACK);
        b31.setBounds(884, 0, 128, 128);
        c.add(b31);
        
        b32 = new JButton(p32);
        b32.setBackground(Color.BLACK);
        b32.setBounds(884, 128, 128, 84);
        c.add(b32);
        
        b33 = new JButton(p33);
        b33.setBackground(Color.BLACK);
        b33.setBounds(884, 212, 128, 84);
        c.add(b33);
        
        b34 = new JButton(p34);
        b34.setBackground(Color.BLACK);
        b34.setBounds(884, 296, 128, 84);
        c.add(b34);
        
        b35 = new JButton(p35);
        b35.setBackground(Color.BLACK);
        b35.setBounds(884, 380, 128, 84);
        c.add(b35);
        
        b36 = new JButton(p36);
        b36.setBackground(Color.BLACK);
        b36.setBounds(884, 464, 128, 84);
        c.add(b36);
        
        b37 = new JButton(p37);
        b37.setBackground(Color.BLACK);
        b37.setBounds(884, 548, 128, 84);
        c.add(b37);
        
        b38 = new JButton(p38);
        b38.setBackground(Color.BLACK);
        b38.setBounds(884, 632, 128, 84);
        c.add(b38);
        
        b39 = new JButton(p39);
        b39.setBackground(Color.BLACK);
        b39.setBounds(884, 716, 128, 84);
        c.add(b39);
        
        b40 = new JButton(p40);
        b40.setBackground(Color.BLACK);
        b40.setBounds(884, 800, 128, 84);
//        b40.addMouseMotionListener(new MouseAdapter() {
//            public void mouseEntered(MouseEvent e){
//                int x=e.getX();
//                int y=e.getY();
//                
//                JFrame g = new JFrame();
//                g.setBounds(x, y, 265, 400);
//                g.setVisible(true);
//                c.add(g);
//                
//                JLabel f = new JLabel(t2);
//                f.setBounds(x, y, 265, 400);
//                c.add(f);
//            }
//        });
        b40.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        ff = new JLabel(t2);
        
        ff.setText("Right");
        ff.setBounds(1000, 800, 120, 120);
        c.add(ff);
    }
});
        b40.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //ScaledImage(p40.getImage(), zoom.getWidth(), zoom.getHeight());
//                    zoom = new JLabel(board);
//                    zoom.setBounds(1017, 1017, 200, 200);
//                    c.add(zoom);
                    //String backupDir = "/Users/al/backups";

                            // create a jframe
                            //JFrame frame = new JFrame("misc/40.png");
                            // show a joptionpane dialog using showMessageDialog
                            //JOptionPane.showMessageDialog(frame,"Price: 400","BOARDWALK",JOptionPane.INFORMATION_MESSAGE, t1);
                        }  
                }
        );
        c.add(b40);
        
        background = new JLabel(board);
        background.setBounds(128, 128, 756, 756);
        c.add(background);
    }
    private Image ScaledImage(Image img, int w, int h){
        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizedImage;
    }
    //This returns the Point2D that corresponds to the location to draw the characters on the map
    public Mainboard_GUI getpoint(int location){
        Mainboard_GUI pt = new Mainboard_GUI(x, y);
        switch(location){
            case 0: pt = new Mainboard_GUI(900, 900); break;
		case 1: pt = new Mainboard_GUI(800, 900); break;
		case 2: pt = new Mainboard_GUI(700, 900); break;
		case 3: pt = new Mainboard_GUI(1005, 1415); break;
		case 4: pt = new Mainboard_GUI(870, 1415); break;
		case 5: pt = new Mainboard_GUI(750, 1415); break;
		case 6: pt = new Mainboard_GUI(630, 1415); break;
		case 7: pt = new Mainboard_GUI(500, 1415); break;
		case 8: pt = new Mainboard_GUI(380, 1415); break;
		case 9: pt = new Mainboard_GUI(260, 1415); break;
		case 10: pt = new Mainboard_GUI(30, 1470); break;
		case 11: pt = new Mainboard_GUI(75, 1240); break;
		case 12: pt = new Mainboard_GUI(75, 1120); break;
		case 13: pt = new Mainboard_GUI(75, 1000); break;
		case 14: pt = new Mainboard_GUI(75, 880); break;
		case 15: pt = new Mainboard_GUI(75, 750); break;
		case 16: pt = new Mainboard_GUI(75, 630); break;
		case 17: pt = new Mainboard_GUI(75, 510); break;
		case 18: pt = new Mainboard_GUI(75, 390); break;
		case 19: pt = new Mainboard_GUI(75, 260); break;
		case 20: pt = new Mainboard_GUI(100, 100); break;
		case 21: pt = new Mainboard_GUI(260, 75); break;
		case 22: pt = new Mainboard_GUI(380, 75); break;
		case 23: pt = new Mainboard_GUI(500, 75); break;
		case 24: pt = new Mainboard_GUI(630, 75); break;
		case 25: pt = new Mainboard_GUI(750, 75); break;
		case 26: pt = new Mainboard_GUI(870, 75); break;
		case 27: pt = new Mainboard_GUI(1005, 75); break;
		case 28: pt = new Mainboard_GUI(1125, 75); break;
		case 29: pt = new Mainboard_GUI(1245, 75); break;
		case 30: pt = new Mainboard_GUI(130, 1370); break;
		case 31: pt = new Mainboard_GUI(1415, 260); break;
		case 32: pt = new Mainboard_GUI(1415, 390); break;
		case 33: pt = new Mainboard_GUI(1415, 510); break;
		case 34: pt = new Mainboard_GUI(1415, 630); break;
		case 35: pt = new Mainboard_GUI(1415, 750); break;
		case 36: pt = new Mainboard_GUI(1415, 880); break;
		case 37: pt = new Mainboard_GUI(1415, 1000); break;
		case 38: pt = new Mainboard_GUI(1415, 1120); break;
		case 39: pt = new Mainboard_GUI(1415, 1240); break;
        }
        return pt;
    }
    public static String getName(int location) {
		String rtn = "";
		switch (location) {
		case 0: rtn = "Go"; break;
		case 1: rtn = "Mediterranean Avenue"; break;
		case 2: rtn = "Community Chest"; break;
		case 3: rtn = "Baltic Avenue"; break;
		case 4: rtn = "Income Tax"; break;
		case 5: rtn = "Reading Railroad"; break;
		case 6: rtn = "Oriental Avenue"; break;
		case 7: rtn = "Chance"; break;
		case 8: rtn = "Vermont Avenue"; break;
		case 9: rtn = "Connecticut Avenue"; break;
		case 10: rtn = "Just Visiting"; break;
		case 11: rtn = "St. Charles Place"; break;
		case 12: rtn = "Electric Company"; break;
		case 13: rtn = "States Avenue"; break;
		case 14: rtn = "Virginia Avenue"; break;
		case 15: rtn = "Pennsylvania Railroad"; break;
		case 16: rtn = "St. James Place"; break;
		case 17: rtn = "Community Chest"; break;
		case 18: rtn = "Tennessee Avenue"; break;
		case 19: rtn = "New York Avenue"; break;
		case 20: rtn = "Free Parking"; break;
		case 21: rtn = "Kentucky Avenue"; break;
		case 22: rtn = "Chance"; break;
		case 23: rtn = "Indiana Avenue"; break;
		case 24: rtn = "Illinois Avenue"; break;
		case 25: rtn = "B. & O. Railroad"; break;
		case 26: rtn = "Atlantic Avenue"; break;
		case 27: rtn = "Ventnor Avenue"; break;
		case 28: rtn = "Water Works"; break;
		case 29: rtn = "Marvin Gardens"; break;
		case 30: rtn = "Jail"; break;
		case 31: rtn = "Pacific Avenue"; break;
		case 32: rtn = "North Carolina Avenue"; break;
		case 33: rtn = "Community Chest"; break;
		case 34: rtn = "Pennsylvania Avenue"; break;
		case 35: rtn = "Short Line"; break;
		case 36: rtn = "Chance"; break;
		case 37: rtn = "Park Place"; break;
		case 38: rtn = "Luxury Tax"; break;
		case 39: rtn = "Boardwalk"; break;
		}
		return rtn;
	}
}