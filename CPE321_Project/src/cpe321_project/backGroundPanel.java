/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

import javax.imageio.ImageIO;

/**
 *
 * @author david_b2003
 */
public class backGroundPanel extends javax.swing.JPanel {

    /**
     * Creates new form backGroundPanel
     */
    public backGroundPanel() {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
     @Override
    public void paintComponent(java.awt.Graphics g) {
        
    super.paintComponents(g);
    GameManager manager = GameManager.getInstance();
    if(manager.getCurrentFloor() != null){
        java.awt.Image bgImage;  
        String url;
        url = manager.getCurrentFloor().getCurrentRoom().getroomPictureURL();
        
        bgImage = new javax.swing.ImageIcon(getClass().getResource(url)).getImage(); // NOI18N
        g.drawImage(bgImage, 0, 0, null);
    }
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}