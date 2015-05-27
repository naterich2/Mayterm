/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
//import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

import nathanr15979.mayterm.control.Util;

/**
 *
 * @author nathan richman
 */
public class RadialPanel extends Group {
    public static final int N1 = 0;
    public static final int N2 = 1;
    public static final int N3 = 2;
    private Graphics g;
    
    private boolean[] nShell = {false, false, false};
    private boolean[] subShell = {false, false, false};
    private Image s1, s2, p2, s3, p3, d3;
    private ArrayList<WritableImage> drawn;
    WritableImage s1fx, s2fx, p2fx, s3fx, p3fx, d3fx;
   
    
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
        drawn = new ArrayList<WritableImage>();
        s1 = Util.makeColorTransparent(s1, Color.WHITE);
        s2 = Util.makeColorTransparent(s2, Color.WHITE);
        p2 = Util.makeColorTransparent(p2, Color.WHITE);
        s3 = Util.makeColorTransparent(s3, Color.WHITE);
        p3 = Util.makeColorTransparent(p3, Color.WHITE);
        d3 = Util.makeColorTransparent(d3, Color.WHITE);
        
        /*s1fx = SwingFXUtils.toFXImage((BufferedImage) s1, s1fx);
        s2fx = SwingFXUtils.toFXImage((BufferedImage) s2, s2fx);
          p2fx = SwingFXUtils.toFXImage((BufferedImage) p2, p2fx);
        s3fx = SwingFXUtils.toFXImage((BufferedImage) s3, s3fx);
        p3fx = SwingFXUtils.toFXImage((BufferedImage) p3, p3fx);
        d3fx = SwingFXUtils.toFXImage((BufferedImage) d3, d3fx);*/
        
        //this.add(new JButton("hello"));
    }
    
    private void repaint(){
        getChildren().clear();
        for(WritableImage i: drawn){
         //   getChildren().add(new ImageView(i));
        }
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
                drawn.add(s1fx);
                repaint();
            } else
                if(drawn.contains(s1fx)){
                    drawn.remove(s1fx);
                    repaint();
                }    
        } else {
            if(drawn.contains(s1fx)){
                drawn.remove(s1fx);
                repaint();
            }
        }
        if(nShell[1]){
            if(subShell[0]){
                drawn.add(s2fx);
                repaint();
            }    
            else
                if(drawn.contains(s2fx)){
                    drawn.remove(s2fx);
                    repaint();
                }    
            if(subShell[1]){
                drawn.add(p2fx);
                repaint();
            }    
            else
                if(drawn.contains(p2fx)){
                    drawn.remove(p2fx);
                    repaint();
                }    
        } else{
            if(drawn.contains(s2fx)){
                drawn.remove(s2fx);
                repaint();
            }    
            if(drawn.contains(p2fx)){
                drawn.remove(p2fx);
                repaint();
            }   
        }
        if(nShell[2]){
            if(subShell[0]){
                drawn.add(s3fx);
                repaint();
            }    
            else
                if(drawn.contains(s3fx)){
                    drawn.remove(s3fx);
                    repaint();
                }    
            if(subShell[1]){
                drawn.add(p3fx);
                repaint();
            }    
            else
                if(drawn.contains(p3fx)){
                    drawn.remove(p3fx);
                    repaint();
                }    
            if(subShell[2]){
                drawn.add(d3fx);
                repaint();
            }    
            else
                if(drawn.contains(d3fx)){
                    drawn.remove(d3fx);
                    repaint();
                }    
        } else {
            if(drawn.contains(s3fx)){
                drawn.remove(s3fx);
                repaint();
            }    
            if(drawn.contains(p3fx)){
                drawn.remove(p3fx);
                repaint();
            }    
            if(drawn.contains(d3fx)){
                drawn.remove(d3fx);
                repaint();
            }    
        }
    }
    
}
