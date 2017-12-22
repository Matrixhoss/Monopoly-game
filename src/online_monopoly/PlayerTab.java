/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 *
 * @author Kero
 */
public class PlayerTab extends javax.swing.JPanel {
    ArrayList<Property> properties = new ArrayList<>();
    /**
     * Creates new form PlayerTab
     */
    
   
    

    PlayerTab(String Name, int Money, ArrayList<Property> prop) {
        try {
            new JScrollPane(this);
            initComponents();
            this.PName.setText(Name);
            this.Pmoney.setText(Money+"");
            this.properties = prop;
            UIManager.setLookAndFeel((UIManager.getInstalledLookAndFeels())[1].getClassName());
        } catch (Exception ex) {}
        
        
        
        
        
    }


    

    
    public String TabName(){
        return this.PName.getText();
        
    }
    
    public void Setmoney(int money)
    {
        this.Pmoney.setText(money+"");
    }
    
    public void UpdatePanel()
    { 
        BlueBoardwalkLbl.setEnabled(false);
        BlueParkLbl.setEnabled(false);
        BrownBalticLbl.setEnabled(false);
        BrownMiditerLbl.setEnabled(false);
        GreenNorthLbl.setEnabled(false);
        GreenPacificLbl.setEnabled(false);
        GreenPennsyLbl.setEnabled(false);
        OrangeNewYork.setEnabled(false);
        OrangeStJameslbl.setEnabled(false);
        OrangeTennesseeLbl.setEnabled(false);
        PinkStCharlesLbl.setEnabled(false);
        PinkStatesLbl.setEnabled(false);
        PinkVirginiaLbl.setEnabled(false);
        RedIllinoisLbl.setEnabled(false);
        RedIndianaLbl.setEnabled(false);
        RedKentuckyLbl.setEnabled(false);
        SkyConnicticutLbl.setEnabled(false);
        SkyOrientalLbl.setEnabled(false);
        SkyVermontLbl.setEnabled(false);
        YellowAtlanticLbl.setEnabled(false);
        YellowMarvinLbl.setEnabled(false);
        YellowVentNor.setEnabled(false);

        for (int i = 0; i < properties.size(); i++) {
            switch(properties.get(i).getGroupID())
            {
                case PropertyStander.BlueGroup:
                    if(properties.get(i).name.equals("ParkPlace"))
                    {
                        BlueParkLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("Boardwalk"))
                    {
                        BlueBoardwalkLbl.setEnabled(true);
                    }
                    break;
                case PropertyStander.LightBlueGroup:
                    if(properties.get(i).name.equals("OrientalAvenue"))
                    {
                        SkyOrientalLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("ConnecticutAvenue"))
                    {
                        SkyConnicticutLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("VermontAvenue"))
                    {
                        SkyVermontLbl.setEnabled(true);
                    }
                    
                    break;
                case PropertyStander.BrownGroup:
                    if(properties.get(i).name.equals("MediterraneanAvenue"))
                    {
                        BrownMiditerLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("BalticAvenue"))
                    {
                        BrownBalticLbl.setEnabled(true);
                    }
                    break;
                case PropertyStander.GreenGroup:
                    if(properties.get(i).name.equals("PacificAvenue"))
                    {
                        GreenPacificLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("NorthCarolinaAvenue"))
                    {
                        GreenNorthLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("PennsylvaniaAvenue"))
                    {
                        GreenPennsyLbl.setEnabled(true);
                    }
                    break;
                    
                case PropertyStander.RedGroup:
                    if(properties.get(i).name.equals("KentuckyAvenue"))
                    {
                        RedKentuckyLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("IndianaAvenue"))
                    {
                        RedIndianaLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("IllinoisAvenue"))
                    {
                        RedIllinoisLbl.setEnabled(true);
                    }
                    break;
                case PropertyStander.YelloGroup:
                    if(properties.get(i).name.equals("AtlanticAvenue"))
                    {
                        YellowAtlanticLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("VentnorAvenue"))
                    {
                        YellowVentNor.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("MarvinGardens"))
                    {
                        YellowMarvinLbl.setEnabled(true);
                    }
                    break;
                    
                case PropertyStander.OrangeGroup: 
                    if(properties.get(i).name.equals("StJamesPlace"))
                    {
                        YellowAtlanticLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("TennesseeAvenue"))
                    {
                        YellowVentNor.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("NewYorkAvenue"))
                    {
                        YellowMarvinLbl.setEnabled(true);
                    }
                    break;
                case PropertyStander.RozeGroup:
                    if(properties.get(i).name.equals("StCharlesPlace"))
                    {
                        PinkStCharlesLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("StatesAvenue"))
                    {
                        PinkStatesLbl.setEnabled(true);
                    }
                    if(properties.get(i).name.equals("VirginiaAvenue"))
                    {
                        PinkVirginiaLbl.setEnabled(true);
                    }
                    break;
                default:
                    break;
            }
            
            
        }
    }

    public void setCommunity(boolean Community) {
        CommunityChestCardLbl.setEnabled(Community);
    }

    public void setChance(boolean Chance) {
        ChanceCardLbl.setEnabled(Chance);
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Pmoney = new javax.swing.JLabel();
        PName = new javax.swing.JLabel();
        Greenpnl = new javax.swing.JPanel();
        GreenPacificLbl = new javax.swing.JLabel();
        GreenNorthLbl = new javax.swing.JLabel();
        GreenPennsyLbl = new javax.swing.JLabel();
        SkyPnl = new javax.swing.JPanel();
        SkyConnicticutLbl = new javax.swing.JLabel();
        SkyOrientalLbl = new javax.swing.JLabel();
        SkyVermontLbl = new javax.swing.JLabel();
        BluePnl = new javax.swing.JPanel();
        BlueParkLbl = new javax.swing.JLabel();
        BlueBoardwalkLbl = new javax.swing.JLabel();
        RedPnl = new javax.swing.JPanel();
        RedKentuckyLbl = new javax.swing.JLabel();
        RedIndianaLbl = new javax.swing.JLabel();
        RedIllinoisLbl = new javax.swing.JLabel();
        OrangePnl = new javax.swing.JPanel();
        OrangeStJameslbl = new javax.swing.JLabel();
        OrangeTennesseeLbl = new javax.swing.JLabel();
        OrangeNewYork = new javax.swing.JLabel();
        PinkPnl = new javax.swing.JPanel();
        PinkStCharlesLbl = new javax.swing.JLabel();
        PinkStatesLbl = new javax.swing.JLabel();
        PinkVirginiaLbl = new javax.swing.JLabel();
        Yellow = new javax.swing.JPanel();
        YellowAtlanticLbl = new javax.swing.JLabel();
        YellowVentNor = new javax.swing.JLabel();
        YellowMarvinLbl = new javax.swing.JLabel();
        BrownPnl = new javax.swing.JPanel();
        BrownMiditerLbl = new javax.swing.JLabel();
        BrownBalticLbl = new javax.swing.JLabel();
        Communitypnl = new javax.swing.JPanel();
        ChanceCardLbl = new javax.swing.JLabel();
        CommunityChestpnel = new javax.swing.JPanel();
        CommunityChestCardLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Player Details"));

        Pmoney.setText("Money");

        PName.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(PName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(Pmoney)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PName)
                    .addComponent(Pmoney))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        Greenpnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Green"));

        GreenPacificLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/green/32.png"))); // NOI18N
        GreenPacificLbl.setEnabled(false);

        GreenNorthLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/green/33.png"))); // NOI18N
        GreenNorthLbl.setEnabled(false);

        GreenPennsyLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/green/35.png"))); // NOI18N
        GreenPennsyLbl.setEnabled(false);

        javax.swing.GroupLayout GreenpnlLayout = new javax.swing.GroupLayout(Greenpnl);
        Greenpnl.setLayout(GreenpnlLayout);
        GreenpnlLayout.setHorizontalGroup(
            GreenpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GreenpnlLayout.createSequentialGroup()
                .addComponent(GreenPacificLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GreenNorthLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GreenPennsyLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GreenpnlLayout.setVerticalGroup(
            GreenpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GreenpnlLayout.createSequentialGroup()
                .addGroup(GreenpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GreenPacificLbl)
                    .addComponent(GreenNorthLbl)
                    .addComponent(GreenPennsyLbl))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(Greenpnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 210, 110));

        SkyPnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Sky"));

        SkyConnicticutLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/sky/10.png"))); // NOI18N
        SkyConnicticutLbl.setEnabled(false);

        SkyOrientalLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/sky/7.png"))); // NOI18N
        SkyOrientalLbl.setEnabled(false);

        SkyVermontLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/sky/9.png"))); // NOI18N
        SkyVermontLbl.setEnabled(false);

        javax.swing.GroupLayout SkyPnlLayout = new javax.swing.GroupLayout(SkyPnl);
        SkyPnl.setLayout(SkyPnlLayout);
        SkyPnlLayout.setHorizontalGroup(
            SkyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SkyPnlLayout.createSequentialGroup()
                .addComponent(SkyConnicticutLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SkyOrientalLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SkyVermontLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SkyPnlLayout.setVerticalGroup(
            SkyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SkyPnlLayout.createSequentialGroup()
                .addGroup(SkyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SkyConnicticutLbl)
                    .addComponent(SkyOrientalLbl)
                    .addComponent(SkyVermontLbl))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(SkyPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 110));

        BluePnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Blue"));

        BlueParkLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/blue/38.png"))); // NOI18N
        BlueParkLbl.setEnabled(false);

        BlueBoardwalkLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/blue/40.png"))); // NOI18N
        BlueBoardwalkLbl.setEnabled(false);

        javax.swing.GroupLayout BluePnlLayout = new javax.swing.GroupLayout(BluePnl);
        BluePnl.setLayout(BluePnlLayout);
        BluePnlLayout.setHorizontalGroup(
            BluePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BluePnlLayout.createSequentialGroup()
                .addComponent(BlueParkLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BlueBoardwalkLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BluePnlLayout.setVerticalGroup(
            BluePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BluePnlLayout.createSequentialGroup()
                .addGroup(BluePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BlueParkLbl)
                    .addComponent(BlueBoardwalkLbl))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(BluePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 140, 110));

        RedPnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Red"));

        RedKentuckyLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/red/22.png"))); // NOI18N
        RedKentuckyLbl.setEnabled(false);

        RedIndianaLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/red/24.png"))); // NOI18N
        RedIndianaLbl.setEnabled(false);

        RedIllinoisLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/red/25.png"))); // NOI18N
        RedIllinoisLbl.setEnabled(false);

        javax.swing.GroupLayout RedPnlLayout = new javax.swing.GroupLayout(RedPnl);
        RedPnl.setLayout(RedPnlLayout);
        RedPnlLayout.setHorizontalGroup(
            RedPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RedPnlLayout.createSequentialGroup()
                .addComponent(RedKentuckyLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RedIndianaLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RedIllinoisLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RedPnlLayout.setVerticalGroup(
            RedPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RedPnlLayout.createSequentialGroup()
                .addGroup(RedPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RedKentuckyLbl)
                    .addComponent(RedIndianaLbl)
                    .addComponent(RedIllinoisLbl))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(RedPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 210, 110));

        OrangePnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Orange"));

        OrangeStJameslbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/orange/17.png"))); // NOI18N
        OrangeStJameslbl.setEnabled(false);

        OrangeTennesseeLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/orange/19.png"))); // NOI18N
        OrangeTennesseeLbl.setEnabled(false);

        OrangeNewYork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/orange/20.png"))); // NOI18N
        OrangeNewYork.setEnabled(false);

        javax.swing.GroupLayout OrangePnlLayout = new javax.swing.GroupLayout(OrangePnl);
        OrangePnl.setLayout(OrangePnlLayout);
        OrangePnlLayout.setHorizontalGroup(
            OrangePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrangePnlLayout.createSequentialGroup()
                .addComponent(OrangeStJameslbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrangeTennesseeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrangeNewYork)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OrangePnlLayout.setVerticalGroup(
            OrangePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrangePnlLayout.createSequentialGroup()
                .addGroup(OrangePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OrangeStJameslbl)
                    .addComponent(OrangeTennesseeLbl)
                    .addComponent(OrangeNewYork))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(OrangePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 210, 110));

        PinkPnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Pink"));

        PinkStCharlesLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/pink/12.png"))); // NOI18N
        PinkStCharlesLbl.setEnabled(false);

        PinkStatesLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/pink/14.png"))); // NOI18N
        PinkStatesLbl.setEnabled(false);

        PinkVirginiaLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/pink/15.png"))); // NOI18N
        PinkVirginiaLbl.setEnabled(false);

        javax.swing.GroupLayout PinkPnlLayout = new javax.swing.GroupLayout(PinkPnl);
        PinkPnl.setLayout(PinkPnlLayout);
        PinkPnlLayout.setHorizontalGroup(
            PinkPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PinkPnlLayout.createSequentialGroup()
                .addComponent(PinkStCharlesLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PinkStatesLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PinkVirginiaLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PinkPnlLayout.setVerticalGroup(
            PinkPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PinkPnlLayout.createSequentialGroup()
                .addGroup(PinkPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PinkStCharlesLbl)
                    .addComponent(PinkStatesLbl)
                    .addComponent(PinkVirginiaLbl))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(PinkPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 210, 110));

        Yellow.setBorder(javax.swing.BorderFactory.createTitledBorder("Yellow"));

        YellowAtlanticLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/yellow/27.png"))); // NOI18N
        YellowAtlanticLbl.setEnabled(false);

        YellowVentNor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/yellow/28.png"))); // NOI18N
        YellowVentNor.setEnabled(false);

        YellowMarvinLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/yellow/30.png"))); // NOI18N
        YellowMarvinLbl.setEnabled(false);

        javax.swing.GroupLayout YellowLayout = new javax.swing.GroupLayout(Yellow);
        Yellow.setLayout(YellowLayout);
        YellowLayout.setHorizontalGroup(
            YellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YellowLayout.createSequentialGroup()
                .addComponent(YellowAtlanticLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(YellowVentNor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(YellowMarvinLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        YellowLayout.setVerticalGroup(
            YellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YellowLayout.createSequentialGroup()
                .addGroup(YellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(YellowAtlanticLbl)
                    .addComponent(YellowVentNor)
                    .addComponent(YellowMarvinLbl))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(Yellow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 210, 110));

        BrownPnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Brown"));

        BrownMiditerLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/brown/2.png"))); // NOI18N
        BrownMiditerLbl.setEnabled(false);

        BrownBalticLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/brown/4.png"))); // NOI18N
        BrownBalticLbl.setEnabled(false);

        javax.swing.GroupLayout BrownPnlLayout = new javax.swing.GroupLayout(BrownPnl);
        BrownPnl.setLayout(BrownPnlLayout);
        BrownPnlLayout.setHorizontalGroup(
            BrownPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrownPnlLayout.createSequentialGroup()
                .addComponent(BrownMiditerLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrownBalticLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BrownPnlLayout.setVerticalGroup(
            BrownPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrownPnlLayout.createSequentialGroup()
                .addGroup(BrownPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BrownMiditerLbl)
                    .addComponent(BrownBalticLbl))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(BrownPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 140, 110));

        Communitypnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Chance"));

        ChanceCardLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/community and chance/chance.png"))); // NOI18N
        ChanceCardLbl.setEnabled(false);

        javax.swing.GroupLayout CommunitypnlLayout = new javax.swing.GroupLayout(Communitypnl);
        Communitypnl.setLayout(CommunitypnlLayout);
        CommunitypnlLayout.setHorizontalGroup(
            CommunitypnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CommunitypnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChanceCardLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CommunitypnlLayout.setVerticalGroup(
            CommunitypnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommunitypnlLayout.createSequentialGroup()
                .addComponent(ChanceCardLbl)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(Communitypnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 140, 110));

        CommunityChestpnel.setBorder(javax.swing.BorderFactory.createTitledBorder("Community Chest"));

        CommunityChestCardLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/mischd/community and chance/community.png"))); // NOI18N
        CommunityChestCardLbl.setEnabled(false);

        javax.swing.GroupLayout CommunityChestpnelLayout = new javax.swing.GroupLayout(CommunityChestpnel);
        CommunityChestpnel.setLayout(CommunityChestpnelLayout);
        CommunityChestpnelLayout.setHorizontalGroup(
            CommunityChestpnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommunityChestpnelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CommunityChestCardLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CommunityChestpnelLayout.setVerticalGroup(
            CommunityChestpnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommunityChestpnelLayout.createSequentialGroup()
                .addComponent(CommunityChestCardLbl)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(CommunityChestpnel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 140, 110));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BlueBoardwalkLbl;
    private javax.swing.JLabel BlueParkLbl;
    private javax.swing.JPanel BluePnl;
    private javax.swing.JLabel BrownBalticLbl;
    private javax.swing.JLabel BrownMiditerLbl;
    private javax.swing.JPanel BrownPnl;
    private javax.swing.JLabel ChanceCardLbl;
    private javax.swing.JLabel CommunityChestCardLbl;
    private javax.swing.JPanel CommunityChestpnel;
    private javax.swing.JPanel Communitypnl;
    private javax.swing.JLabel GreenNorthLbl;
    private javax.swing.JLabel GreenPacificLbl;
    private javax.swing.JLabel GreenPennsyLbl;
    private javax.swing.JPanel Greenpnl;
    private javax.swing.JLabel OrangeNewYork;
    private javax.swing.JPanel OrangePnl;
    private javax.swing.JLabel OrangeStJameslbl;
    private javax.swing.JLabel OrangeTennesseeLbl;
    private javax.swing.JLabel PName;
    private javax.swing.JPanel PinkPnl;
    private javax.swing.JLabel PinkStCharlesLbl;
    private javax.swing.JLabel PinkStatesLbl;
    private javax.swing.JLabel PinkVirginiaLbl;
    private javax.swing.JLabel Pmoney;
    private javax.swing.JLabel RedIllinoisLbl;
    private javax.swing.JLabel RedIndianaLbl;
    private javax.swing.JLabel RedKentuckyLbl;
    private javax.swing.JPanel RedPnl;
    private javax.swing.JLabel SkyConnicticutLbl;
    private javax.swing.JLabel SkyOrientalLbl;
    private javax.swing.JPanel SkyPnl;
    private javax.swing.JLabel SkyVermontLbl;
    private javax.swing.JPanel Yellow;
    private javax.swing.JLabel YellowAtlanticLbl;
    private javax.swing.JLabel YellowMarvinLbl;
    private javax.swing.JLabel YellowVentNor;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
