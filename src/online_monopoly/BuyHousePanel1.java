/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.util.ArrayList;
import online_monopoly.Controller;

/**
 *
 * @author n0krashy
 */
public class BuyHousePanel1 extends javax.swing.JPanel {

    public static Controller c;
    public static BuyHousePanel2 BH2;

    /**
     * Creates new form BuyHousePanel
     */
    public BuyHousePanel1(Controller c) {

        initComponents();
        this.c = c;
        ButtonsInit();

    }

    private void ButtonsInit() {
        ArrayList<Group> ownedGroups = c.getCurrentPlayerGroups();
        int OwnedGroupsN = ownedGroups.size(); //total number of owned Groups by the player
        switch (OwnedGroupsN) {
            case 1:
                jButton1.setText(ownedGroups.get(0).getColorName()); //get First array element & setText To its Color ownedGroups[0].getColor()+"";
                jButton2.setVisible(false);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                break;
            case 2:
                jButton1.setText(ownedGroups.get(0).getColorName()); //get First array element & setText To its Color ownedGroups[0].getColor()+"";
                jButton2.setText(ownedGroups.get(1).getColorName()); //get Second array element & setText To its Color ownedGroups[1].getColor()+"";
                jButton2.setVisible(true);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                break;
            case 3:
                jButton1.setText(ownedGroups.get(0).getColorName());
                jButton2.setText(ownedGroups.get(1).getColorName());
                jButton3.setText(ownedGroups.get(2).getColorName());
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                break;
            case 4:
                jButton1.setText(ownedGroups.get(0).getColorName());
                jButton2.setText(ownedGroups.get(1).getColorName());
                jButton3.setText(ownedGroups.get(2).getColorName());
                jButton4.setText(ownedGroups.get(3).getColorName());
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                break;
            case 5:
                jButton1.setText(ownedGroups.get(0).getColorName());
                jButton2.setText(ownedGroups.get(1).getColorName());
                jButton3.setText(ownedGroups.get(2).getColorName());
                jButton4.setText(ownedGroups.get(3).getColorName());
                jButton5.setText(ownedGroups.get(4).getColorName());
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                break;
            case 6:
                jButton1.setText(ownedGroups.get(0).getColorName());
                jButton2.setText(ownedGroups.get(1).getColorName());
                jButton3.setText(ownedGroups.get(2).getColorName());
                jButton4.setText(ownedGroups.get(3).getColorName());
                jButton5.setText(ownedGroups.get(4).getColorName());
                jButton6.setText(ownedGroups.get(5).getColorName());
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                break;
            case 7:
                jButton1.setText(ownedGroups.get(0).getColorName());
                jButton2.setText(ownedGroups.get(1).getColorName());
                jButton3.setText(ownedGroups.get(2).getColorName());
                jButton4.setText(ownedGroups.get(3).getColorName());
                jButton5.setText(ownedGroups.get(4).getColorName());
                jButton6.setText(ownedGroups.get(5).getColorName());
                jButton7.setText(ownedGroups.get(6).getColorName());
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(true);
                jButton8.setVisible(false);
                break;
            case 8:
                jButton1.setText(ownedGroups.get(0).getColorName());
                jButton2.setText(ownedGroups.get(1).getColorName());
                jButton3.setText(ownedGroups.get(2).getColorName());
                jButton4.setText(ownedGroups.get(3).getColorName());
                jButton5.setText(ownedGroups.get(4).getColorName());
                jButton6.setText(ownedGroups.get(5).getColorName());
                jButton7.setText(ownedGroups.get(6).getColorName());
                jButton8.setText(ownedGroups.get(7).getColorName());
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(true);
                jButton8.setVisible(true);
                break;

        }
    }

    private void close(int i) {
        setVisible(false);
        BH2 = new BuyHousePanel2(i); //ownedGroups[1].getNumber();
        BuyHouseFrame.jPanel1.add(BH2);
        BH2.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(400, 400));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("jButton7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("jButton8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose group Color");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(55, 55, 55)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(55, 55, 55)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(55, 55, 55)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(55, 55, 55)
                                .addComponent(jButton8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(105, 105, 105))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        close(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        close(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        close(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        close(4);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        close(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        close(6);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        close(7);
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
