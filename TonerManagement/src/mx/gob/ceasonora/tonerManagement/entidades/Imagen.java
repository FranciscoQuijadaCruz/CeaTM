/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class Imagen extends javax.swing.JPanel{
    int x,y, newY;
    String ruta;
    
    public Imagen(JPanel jPanel, String ruta){
        this.x = jPanel.getWidth();
        this.y = jPanel.getHeight();
        this.setSize(x,y);
        this.ruta = ruta;
    }
    
    public void reescalar(){
        this.setSize(x, newY);
    }
    
    @Override
    public void paint(Graphics g){
        ImageIcon imgIcon = new ImageIcon(ruta);
        Image img = imgIcon.getImage();
        newY = (x*img.getHeight(null))/img.getWidth(null);
        reescalar();
        g.drawImage(img, 0, 0, x, y, Color.white , null);
        
    }
}
