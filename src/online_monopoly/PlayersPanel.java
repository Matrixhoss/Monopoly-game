/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author Kero
 */
public class PlayersPanel extends javax.swing.JPanel {

    /**
     * Creates new form PlayersPanel
     */
    ArrayList<PlayerTab> Panels = new ArrayList<PlayerTab>();
    Hashtable<String ,Player> PlayersP;
    public PlayersPanel(Hashtable<String ,Player> p) {
        initComponents();
        this.setMaximumSize(new Dimension(200, 700));
        PlayersP = p;
        
        Set<String> keys = PlayersP.keySet();
        for(String key: keys){
            Panels.add(new PlayerTab(PlayersP.get(key).name, PlayersP.get(key).getMoney()));
        }
        for (int i = 0; i < Panels.size(); i++) {
            jTabbedPane1.addTab(Panels.get(i).TabName(), Panels.get(i));
        }
    }
    
    public void ChangePlayer(String Name)
    {
        for (int i = 0; i < Panels.size(); i++) {
            if(Name.equals(Panels.get(i).TabName()))
            {
                jTabbedPane1.setSelectedIndex(i);
            }
        }
    }
    
    public void Update(Hashtable<String ,Player> p)
    {
        int k =0;
        Set<String> keys = PlayersP.keySet();
        for(String key: keys){
            Panels.get(k).Setmoney(PlayersP.get(key).getMoney());
            k++;
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setBorder(new javax.swing.border.MatteBorder(null));

        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
