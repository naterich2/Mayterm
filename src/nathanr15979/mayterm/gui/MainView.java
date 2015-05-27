/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
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
    private PerspectiveCamera cam; 
    
    
    public MainView(){
       super();
       sg = new ShellGroup();
       rp = new RadialPanel();
       ip = new InputPanel(sg, rp);
      // cam = new PerspectiveCamera();
       //cam.setFieldOfView(40);
       myScene = new Scene(new BorderPane(), 1000, 800, true);
      // myScene.setCamera(cam);
       
       myScene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                mouseX = me.getX();
                mouseY = me.getY();
                oldMouseX = me.getX();
                oldMouseY = me.getY();
                //System.out.println("scene.setOnMousePressed " + me);
            }
        });
        myScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                oldMouseX = mouseX;
                oldMouseY = mouseY;
                mouseX = me.getX();
                mouseY = me.getY();
                deltaX = mouseX - oldMouseX;
                deltaY = mouseY - oldMouseY;
                if (me.isShiftDown() && me.isPrimaryButtonDown()) {
                    double rzAngle = sg.rz.getAngle();
                    sg.rz.setAngle(rzAngle - deltaX);
                }
                else if (me.isPrimaryButtonDown()) {
                    double ryAngle = sg.ry.getAngle();
                    sg.ry.setAngle(ryAngle - deltaX);
                    double rxAngle = sg.rx.getAngle();
                    sg.rx.setAngle(rxAngle + deltaY);
                }
                else if (me.isControlDown() && me.isPrimaryButtonDown()) {
                    double scale = sg.s.getX();
                    double newScale = scale + deltaX*0.01;
                    sg.s.setX(newScale);
                    sg.s.setY(newScale);
                    sg.s.setZ(newScale);
                }
                else if (me.isAltDown() && me.isPrimaryButtonDown()) {
                    double tx = sg.t.getX();
                    double ty = sg.t.getY();
                    sg.t.setX(tx + deltaX);
                    sg.t.setY(ty + deltaY);
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
    public static void main(String [] args){
        launch(args);
    }
}
