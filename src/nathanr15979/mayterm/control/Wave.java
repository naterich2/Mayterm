/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.control;

import java.lang.Math;

/**
 *
 * @author nathan richman
 */
public class Wave {

	public static double waveEquation(int l, int m, double theta, double psi){
		double wave = (m>0? Math.cos(m*psi) : Math.sin(Math.abs(m)*psi));
		double coefficient = normalization(l,m);
		double legendrePart = legendre(l, Math.abs(m),theta,psi);
		return coefficient*legendrePart*wave;
	}

	private static double normalization(int l, int m){
		if(m>0|| m<0){
			double firstQuotient = (2*l+1)/Math.PI;
			double secondQuotient = factorial(l - Math.abs(m))/factorial(l + Math.abs(m));
			return Math.sqrt(2)*Math.sqrt(firstQuotient*secondQuotient);
		} else{
			double firstQuotient = (2*l+1)/Math.PI;
			double secondQuotient = factorial(l)/factorial(l);
			return Math.sqrt(firstQuotient*secondQuotient);
		}
	}
	private static double legendre(int l, int m, double theta, double phi){
            double part = 0.0;
            if( l == 0 && m == 0){
			part = 1;
		} else if(l == m){
			part = (double) (doubleFactorial(2*m-1))*Math.pow((1-Math.pow(Math.cos(phi),2)),(double)m/2);
		} else if((m+1) == l){
			part = Math.cos(phi)*(2*m+1)*legendre(m,m,theta,phi);
		} else {
			part = ((Math.cos(phi)*(2*l-1))/(l-m))*legendre(l-1,m,theta,phi)-((l+m-1)/(l-m))*legendre(l-2,m,theta,phi);
		}
            return part;
	}

	private static int factorial(int n){
		if(n == 0)
			return 1;
		return factorial(n-1)*n;
	}

	private static int doubleFactorial(int n){
		int total=1;
		for(int i = n; i>0;i-=2){
			total *= i;
		}
		return total;
	}
}
