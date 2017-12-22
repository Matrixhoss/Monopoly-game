package online_monopoly;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sun.audio.*;

public class MainMenu extends JFrame{
    public JLabel background;
    public JButton start;
    public JButton option;
    public JButton exit;
    public JLabel logo;
    private MainMenu _this;
    
    ImageIcon main_menu_logo= new ImageIcon(getClass().getResource("misc/Untitled-3.png"));
   // ImageIcon start_logo= new ImageIcon(getClass().getResource("misc/.jpg"));
    ImageIcon start_logo_button= new ImageIcon(getClass().getResource("misc/button_start (1).png"));
    ImageIcon option_button= new ImageIcon(getClass().getResource("misc/button_options.png"));
    ImageIcon exit_button= new ImageIcon(getClass().getResource("misc/button_exit (1).png"));
    ImageIcon theme_button= new ImageIcon(getClass().getResource("misc/Untitled-5.png"));
    public static void music() 
    {       
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            InputStream test = new FileInputStream("misc/Menu_Theme.wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
        MGP.start(loop);
    }
    public MainMenu(){
        _this = this;
        try {
           
           UIManager.setLookAndFeel((UIManager.getInstalledLookAndFeels())[1].getClassName());
       } catch (Exception ex) {}
        this.setTitle("Monopoly");
        this.setResizable(false);
        this.setBounds(250, 250, 800, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);
        
//        logo = new JLabel(start_logo);
//        logo.setBounds(0,0, 800, 200);
//        c.add(logo);
        
        start = new JButton(start_logo_button);
        start.setBounds(280, 220, 251, 61);
        start.setBackground(Color.BLACK);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                _this.setVisible(false);
//                GameFrame gm = new GameFrame();
//                gm.setVisible(true);
//                _this.setVisible(false);
//                Mainboard_GUI mg = new Mainboard_GUI(0, 0);
//                mg.setVisible(true);
////Mainboard_GUI_HD mg = new Mainboard_GUI_HD(0, 0);
////                mg.setVisible(true);
            }
        });
        c.add(start);
        
        option = new JButton(option_button);
        option.setBackground(Color.BLACK);
        option.setBounds(280, 290, 251, 61);
        c.add(option);
        
        exit = new JButton(exit_button);
        exit.setBackground(Color.BLACK);
        exit.setBounds(280, 360, 251, 61);
        c.add(exit);
        
        background = new JLabel(main_menu_logo);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
        
        start.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new PickingNumberOPlayersFrame();
                    MainMenu.this.dispose();
                }
            }
        );
        
        option.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    JLabel theme;
//                    JFrame hx = new JFrame();
//                    hx.setBounds(450, 450, 400, 300);
//                    hx.setVisible(true);
//                    hx.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                    theme = new JLabel(theme_button);
//                    theme.setBounds(0, 0, 400, 300);
//                    c.add(theme);
                }
            }
        );
        
        exit.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setLocationRelativeTo(null);
    }  
   
}