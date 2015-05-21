/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.gui;

import javafx.embed.swing.JFXPanel;

import nathanr15979.mayterm.control.GraphScene;
import nathanr15979.mayterm.control.ShellGroup;

/**
 *
 * @author nathan richman
 */
public class GraphPanel extends JFXPanel {
    private GraphScene scene;
    private ShellGroup group;
    public GraphPanel(){
        group = new ShellGroup();
        scene = new GraphScene(group);
        
        
    }
    
}
