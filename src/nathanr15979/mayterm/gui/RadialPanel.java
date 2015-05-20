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
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
        s1 = makeColorTransparent(s1, Color.WHITE);
        s2 = makeColorTransparent(s2, Color.WHITE);
        p2 = makeColorTransparent(p2, Color.WHITE);
        s3 = makeColorTransparent(s3, Color.WHITE);
        p3 = makeColorTransparent(p3, Color.WHITE);
        d3 = makeColorTransparent(d3, Color.WHITE);
        this.setMinimumSize(new Dimension(300,400));
        this.setBackground(Color.WHITE);
        //this.add(new JButton("hello"));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Image drawn1 : drawn) {
            g.drawImage(drawn1, 0, 0, null);
        }
    }
    
    
    public void setNShellSelected(boolean selected, int n){
        nShell[n] = selected;
        System.out.println(nShell[0]+" "+nShell[1]+" "+nShell[2]);
        updateShells();
    }
    public void setSubShellSelected(boolean selected, int sub){
        subShell[sub] = selected;
        System.out.println(subShell[0]+" "+subShell[1]+" "+subShell[2]);
        updateShells();
    }
    private void updateShells(){
        if(nShell[0]){
            if(subShell[0])
                drawn.add(s1);
            else
                if(drawn.contains(s1))
                    drawn.remove(s1);
        } if(nShell[1]){
            if(subShell[0])
                drawn.add(s2);
            else
                if(drawn.contains(s2))
                    drawn.remove(s2);
            if(subShell[1])
                drawn.add(p2);
            else
                if(drawn.contains(p2))
                    drawn.remove(p2);
        } if(nShell[2]){
            if(subShell[0])
                drawn.add(s3);
            else
                if(drawn.contains(s3))
                    drawn.remove(s3);
            if(subShell[1])
                drawn.add(p3);
            else
                if(drawn.contains(p3))
                    drawn.remove(p3);
            if(subShell[2])
                drawn.add(d3);
            else
                if(drawn.contains(d3))
                    drawn.remove(d3);
        }
        repaint();
    }
    private Image makeColorTransparent(Image im, final Color color) {
        ImageFilter filter = new RGBImageFilter() {
            // the color we are looking for... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFF000000;

            @Override
            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                // Mark the alpha bits as zero - transparent
                return 0x00FFFFFF & rgb;
                } else {
                // nothing to do
                return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
    
}
