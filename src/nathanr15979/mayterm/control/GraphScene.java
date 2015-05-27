/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.control;


import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author nathan richman
 */
public class GraphScene extends Scene {
    
    private double mouseX, mouseY, oldMouseX, oldMouseY, deltaX, deltaY;
    
    private PerspectiveCamera cam;
    public GraphScene(ShellGroup shellGroup){
        super(shellGroup, 600, 800, Color.GREY);
        cam = new PerspectiveCamera(true);
        
        
        
        
    }
}
