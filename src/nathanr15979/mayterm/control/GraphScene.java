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
        
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                oldMouseX = event.getX();
                oldMouseY = event.getY();
            }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
                deltaX = mouseX-oldMouseX;
                deltaY = mouseY-oldMouseY;
                if(e.isShiftDown()){
                    double scale = shellGroup.s.getX();
                    double newScale = scale + deltaY*.01;
                    shellGroup.s.setX(newScale);
                    shellGroup.s.setY(newScale);
                    shellGroup.s.setZ(newScale);
                } else if(e.isControlDown()){
                    double tx = shellGroup.t.getX();
                    double ty = shellGroup.t.getY();
                    shellGroup.t.setX(tx + deltaX);
                    shellGroup.t.setY(ty + deltaY);
                } else {
                    
                }
            }
        });
        
    }
}
