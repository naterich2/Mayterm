/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import nathanr15979.mayterm.control.ShellGroup;

/**
 *
 * @author nathan richman
 */
public class MainView extends Application {
    
    private InputPanel ip;
    private ShellGroup sg;
    private RadialPanel rp;
    private Scene myScene;
    
    private double oldMouseX;
    private double oldMouseY;
    private double mouseX;
    private double mouseY;
    private double deltaX;
    private double deltaY;
    
    
    public MainView(){
       sg = new ShellGroup();
       rp = new RadialPanel();
       ip = new InputPanel(sg, rp);
       
       myScene = new Scene(new BorderPane(), 1000, 800, true);
       
       myScene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                oldMouseX = event.getX();
                oldMouseY = event.getY();
            }
        });
       myScene.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
                deltaX = mouseX-oldMouseX;
                deltaY = mouseY-oldMouseY;
                if(e.isShiftDown()){
                    double scale = sg.s.getX();
                    double newScale = scale + deltaY*.01;
                    sg.s.setX(newScale);
                    sg.s.setY(newScale);
                    sg.s.setZ(newScale);
                } else if(e.isControlDown()){
                    double tx = sg.t.getX();
                    double ty = sg.t.getY();
                    sg.t.setX(tx + deltaX);
                    sg.t.setY(ty + deltaY);
                } else {
                    
                }
            }
        });
       
       BorderPane myGridPane = (BorderPane) myScene.getRoot();
       myGridPane.setLeft(sg);
       myGridPane.setRight(rp);
       myGridPane.setBottom(ip);
       
        
    }
    
    @Override
    public void start(Stage st){
        st.setScene(myScene);
        st.setTitle("Orbital Viewer");
        st.show();
    }
}
