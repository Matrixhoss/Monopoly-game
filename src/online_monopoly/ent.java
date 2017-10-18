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

public class  ent extends JFrame{
    public JFrame test;
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
//        public void mouseMoved(MouseEvent me){
//            int x =me.getX();
//            int y =me.getY();
//            System.out.println("fffff"+x+"   "+y);
//        }
         //JTextField t1;
    JLabel back;
    JButton b;
    JRadioButton r1,r2;
    JLabel l;
    public ent(){
//        test=this;
//        this.setTitle("Monopoly");
//        this.setResizable(false);
//        this.setLayout(new FlowLayout());
//        this.setBounds(200, 200, 400, 400);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Container c = this.getContentPane();
//        c.setLayout(null);
        //t1 = new JTextField(15);
        b = new JButton("OK");
        r1 = new JRadioButton("HD");
        r2 = new JRadioButton("FullHD");
        l = new JLabel("Choose Your Resolution");
        ImageIcon backb = new ImageIcon(getClass().getResource("misc/Untitled-5.png"));
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        
        //add(t1);
        add(l);
        add(b);
        add(r1);
        add(r2);
        add(b);
        
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String name = t1.getText();
                
                if(r1.isSelected()){
                    Mainboard_GUI_HD hd = new Mainboard_GUI_HD(0, 0);
                }
                else{
                    Mainboard_GUI fhd = new Mainboard_GUI(0, 0);
                }
                //l.setText(name);
            }
        });
        setLayout(new FlowLayout());
        setVisible(true);
        setResizable(false);
        setBounds(700, 400, 200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);
        
        back = new JLabel(backb);
        back.setSize(200, 200);
        c.add(back);
    }
        
}