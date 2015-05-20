/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.control;

/**
 *
 * @author nathan richman
 */
public class Util {
   /**
    * 
    * @param rho
    * @param theta
    * @param phi
    * @return [x,y,z] value of rho,theta, and phi
    */
    public static double[] toCartesian(double rho, double theta, double phi){
        double[] values = new double[3];
        values[0] = rho*Math.sin(phi)*Math.cos(theta);
        values[1] = rho*Math.sin(phi)*Math.sin(theta);
        values[2] = rho*Math.cos(phi);
        return values;
    } 
}
