/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import nathanr15979.mayterm.control.Util;

/**
 *
 * @author nathan richman
 */
public class RadialPanel extends JPanel {
    public static final int N1 = 0;
    public static final int N2 = 1;
    public static final int N3 = 2;
    private Graphics g;
    
    private boolean[] nShell = {false, false, false};
    private boolean[] subShell = {false, false, false};
    private Image s1, s2, p2, s3, p3, d3;
    private ArrayList<Image> drawn;
    
    public RadialPanel(){
        super();
        try{
            s1 = ImageIO.read(RadialPanel.class.getResourceAsStream("1S.png"));
            s2 = ImageIO.read(RadialPanel.class.getResourceAsStream("2S.png"));
            p2 = ImageIO.read(RadialPanel.class.getResourceAsStream("2P.png"));
            s3 = ImageIO.read(RadialPanel.class.getResourceAsStream("3S.png"));
            p3 = ImageIO.read(RadialPanel.class.getResourceAsStream("3P.png"));
            d3 = ImageIO.read(RadialPanel.class.getResourceAsStream("3D.png"));
        } catch(IOException e){
            
        }
        drawn = new ArrayList<Image>();
        s1 = Util.makeColorTransparent(s1, Color.WHITE);
        s2 = Util.makeColorTransparent(s2, Color.WHITE);
        p2 = Util.makeColorTransparent(p2, Color.WHITE);
        s3 = Util.makeColorTransparent(s3, Color.WHITE);
        p3 = Util.makeColorTransparent(p3, Color.WHITE);
        d3 = Util.makeColorTransparent(d3, Color.WHITE);
        
        this.setBackground(Color.WHITE);
        //this.add(new JButton("hello"));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawn.stream().forEach((drawn1) -> {
            g.drawImage(drawn1, 0, 0, null);
        });
    }
    
    
    public void setNShellSelected(boolean selected, int n){
        nShell[n] = selected;
        updateShells();
    }
    public void setSubShellSelected(boolean selected, int sub){
        subShell[sub] = selected;
        updateShells();
    }
    private void updateShells(){
        if(nShell[0]){
            if(subShell[0]){
                drawn.add(s1);
                repaint();
            } else
                if(drawn.contains(s1)){
                    drawn.remove(s1);
                    repaint();
                }    
        } else {
            if(drawn.contains(s1)){
                drawn.remove(s1);
                repaint();
            }
        }
        if(nShell[1]){
            if(subShell[0]){
                drawn.add(s2);
                repaint();
            }    
            else
                if(drawn.contains(s2)){
                    drawn.remove(s2);
                    repaint();
                }    
            if(subShell[1]){
                drawn.add(p2);
                repaint();
            }    
            else
                if(drawn.contains(p2)){
                    drawn.remove(p2);
                    repaint();
                }    
        } else{
            if(drawn.contains(s2)){
                drawn.remove(s2);
                repaint();
            }    
            if(drawn.contains(p2)){
                drawn.remove(p2);
                repaint();
            }   
        }
        if(nShell[2]){
            if(subShell[0]){
                drawn.add(s3);
                repaint();
            }    
            else
                if(drawn.contains(s3)){
                    drawn.remove(s3);
                    repaint();
                }    
            if(subShell[1]){
                drawn.add(p3);
                repaint();
            }    
            else
                if(drawn.contains(p3)){
                    drawn.remove(p3);
                    repaint();
                }    
            if(subShell[2]){
                drawn.add(d3);
                repaint();
            }    
            else
                if(drawn.contains(d3)){
                    drawn.remove(d3);
                    repaint();
                }    
        } else {
            if(drawn.contains(s3)){
                drawn.remove(s3);
                repaint();
            }    
            if(drawn.contains(p3)){
                drawn.remove(p3);
                repaint();
            }    
            if(drawn.contains(d3)){
                drawn.remove(d3);
                repaint();
            }    
        }
    }
    
}
