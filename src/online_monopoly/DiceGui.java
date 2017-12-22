/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Kero
 */
public class DiceGui extends javax.swing.JPanel {
    private boolean rollEnabled;
    Controller controller;
    Random rand = new Random();
    /**
     * Creates new form DiceGui
     * @return 
     */
    public boolean currentPlayerHasRolled(){
        return !rollEnabled;
    }
    public DiceGui(Controller controller) {
        this.rollEnabled = true;
        this.controller = controller;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RollBtn = new javax.swing.JButton();
        DiceLbl2 = new javax.swing.JLabel();
        DiceLbl1 = new javax.swing.JLabel();

        setNextFocusableComponent(this);
        setOpaque(false);

        RollBtn.setText("Roll!!");
        RollBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RollBtnActionPerformed(evt);
            }
        });

        DiceLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/misc/zero.png"))); // NOI18N

        DiceLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_monopoly/misc/zero.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(DiceLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DiceLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(RollBtn)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DiceLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiceLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RollBtn)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RollBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RollBtnActionPerformed
        // TODO add your handling code here:
        ChangeDicesIfApplicaple();
    }//GEN-LAST:event_RollBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DiceLbl1;
    private javax.swing.JLabel DiceLbl2;
    private javax.swing.JButton RollBtn;
    // End of variables declaration//GEN-END:variables

    public void enableDiceRoll(){
        this.rollEnabled = true;
          RollBtn.setEnabled(true);
    }
    public void disableDiceRoll(){
        this.rollEnabled = false;
        RollBtn.setEnabled(false);
    }
    

public void ChangeDicesIfApplicaple() {

    if(controller.getDoubleDice() == 3){
        controller.sendCurrentPlayerTojail();
        disableDiceRoll();
    }
    
    if(rollEnabled){
        
        int roll[] = controller.rollDice();
        if(roll[0] != roll[1]){
           disableDiceRoll();
       }
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {
            int secondsToWait = 1000;
            @Override
            public void run() {
                secondsToWait -= 100;
                DiceLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("misc/dice" + (rand.nextInt(6) + 1) + ".png")));
                DiceLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("misc/dice" + (rand.nextInt(6) + 1) + ".png")));
                if (secondsToWait == 0) {
                    exec.shutdown();
                    DiceLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("misc/dice" + roll[0] + ".png")));
                    DiceLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("misc/dice" + roll[1] + ".png")));
//                    Mainboard_GUI.p.move(roll[0]+roll[1]);
                    controller.handleDiceRoll(roll[0]+roll[1]);
                }
            }
        };
        exec.scheduleAtFixedRate(task, 100, 100, TimeUnit.MILLISECONDS);
       
        
    }
    
}

}
