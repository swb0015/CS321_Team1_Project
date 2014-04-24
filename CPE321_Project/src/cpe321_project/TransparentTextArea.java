/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpe321_project;

import java.awt.*;

/**
 *
 * @author david_b2003
 */
public class TransparentTextArea extends javax.swing.JTextArea {
    
     public TransparentTextArea(){
         
     }
     @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(0, 153, 51));
            Insets insets = getInsets();
            int x = insets.left;
            int y = insets.top;
            int width = getWidth() - (insets.left + insets.right);
            int height = getHeight() - (insets.top + insets.bottom);
            g.fillRect(0, 0, 0, height);
            this.setBackground(new Color(0, 153, 51));
            super.paintComponent(g);
        }

}
