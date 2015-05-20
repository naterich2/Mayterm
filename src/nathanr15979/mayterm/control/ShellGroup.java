/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.control;

import javafx.scene.Group;
import javafx.scene.shape.Box;

/**
 *
 * @author nathan richman
 */
public class ShellGroup extends Group {
    
    public static final int S = 0;
    public static final int P1 = 1;
    public static final int P2 = 2;
    public static final int P3 = 3;
    public static final int D1 = 4;
    public static final int D2 = 5;
    public static final int D3 = 6;
    public static final int D4 = 7;
    public static final int D5 = 8;
    
    private static final double phiChange = Math.PI/30.0;
    private static final double thetaChange = Math.PI/15.0;
    
    private Group current;
    private Group [] shellGroups;
    
    private Wave wave;
    
    public ShellGroup(Wave wave){
        super();
        this.wave = wave;
        current = new Group();
        this.getChildren().add(current);
    }
    
    public void setSelected(boolean selected, int shell){
        switch(shell){
            case 0:
                current = shellGroups[0];
                update();
                break;
            case 1:
                current = shellGroups[1];
                update();
                break;
            case 2:
                current = shellGroups[2];
                update();
                break;
            case 3:  
                current = shellGroups[3];
                update();
                break;
            case 4:
                current = shellGroups[4];
                update();
                break;
            case 5:  
                current = shellGroups[5];
                update();
                break;
            case 6:
                current = shellGroups[6];
                update();
                break;
            case 7:
                current = shellGroups[7];
                update();
                break;
            case 8:
                current = shellGroups[8];
                update();
                break;
        }
    }
    private Group sShell(){
        Group sGroup = new Group();
        double theta = 0;
        double phi = 0;
        while(theta<=2*Math.PI){
            while(phi<=Math.PI){
                double rho = wave.waveEquation(0,0,theta,phi);
                Point point = new Point(Util.toCartesian(rho, theta, phi));
                sGroup.getChildren().add(point);
                phi+=phiChange;
            }
            theta+=thetaChange;
        }
        return sGroup;
    }
    
    private void update(){
        getChildren().clear();
        getChildren().add(current);
    }
    
    class Point extends Group{
        public Point(double[] coords){
            Box box = new Box(1,1,1);
            getChildren().add(box);
            
            setTranslateX(coords[0]);
            setTranslateY(coords[1]);
            setTranslateZ(coords[2]);
        }
    }
}
