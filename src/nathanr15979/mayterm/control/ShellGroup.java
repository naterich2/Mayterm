/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.control;

import javafx.scene.Group;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

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
    private static final int AXIS_LENGTH = 100;
    
    private Group sShell, p1Shell, p2Shell, p3Shell, d1Shell, d2Shell, d3Shell, d4Shell, d5Shell;
    Sphere sphere = new Sphere("kjhsdf");
    public Translate t;
    public Scale s;
    public Rotate rx;
    public Rotate ry;
    public Rotate rz;
    private Box xAxis, yAxis,zAxis;
    
    public ShellGroup(){
        super();
        t = new Translate();
        s = new Scale();
        rx = new Rotate();
        rx.setAxis(Rotate.X_AXIS);
        ry = new Rotate();
        ry.setAxis(Rotate.Y_AXIS);
        rz = new Rotate();
        rz.setAxis(Rotate.Z_AXIS);
        
        getTransforms().addAll(t,s,rx,ry,rz);
        
        sShell = shell(0,0);
        p1Shell = shell(1,-1);
        p2Shell = shell(1,0);
       // p3Shell, d1Shell, d2Shell, d3Shell, d4Shell, d5Shell
        
    }
    
    public void setSelected(boolean selected, int shell){
        
        switch(shell){
            case 0:
                if(selected)
                    getChildren().add(sShell);
                else
                    getChildren().remove(sShell);
                break;
            case 1:
                if(selected)
                    getChildren().add(p1Shell);
                else
                    getChildren().remove(p1Shell);
                break;
            case 2:
                if(selected)
                    getChildren().add(p2Shell);
                else
                    getChildren().remove(p2Shell);
                break;
            case 3:  
                if(selected)
                    getChildren().add(p3Shell);
                else
                    getChildren().remove(p3Shell);
                break;
            case 4:
                if(selected)
                    getChildren().add(d1Shell);
                else
                    getChildren().remove(d1Shell);
                break;
            case 5:  
                if(selected)
                    getChildren().add(d2Shell);
                else
                    getChildren().remove(d2Shell);
                break;
            case 6:
                if(selected)
                    getChildren().add(d3Shell);
                else
                    getChildren().remove(d3Shell);
                break;
            case 7:
                if(selected)
                    getChildren().add(d4Shell);
                else
                    getChildren().remove(d4Shell);
                break;
            case 8:
                if(selected)
                    getChildren().add(d5Shell);
                else
                    getChildren().remove(d5Shell);
                break;
        }
    }
    private Group shell(int l, int m){
        Group group = new Group();
        double theta = 0;
        double phi = 0;
        while(theta<=2*Math.PI){
            while(phi<=Math.PI){
                double rho = Wave.waveEquation(l,m,theta,phi);
                Point point = new Point(Util.toCartesian(rho, theta, phi));
                group.getChildren().add(point);
                phi+=phiChange;
            }
            theta+=thetaChange;
        }
        return group;
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
