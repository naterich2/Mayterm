/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nathanr15979.mayterm.control.ShellGroup;

/**
 *
 * @author nathan richman
 */
public class MainView extends JFrame implements Runnable {
    private InputPanel inputPanel;
    private GraphPanel graphPanel;
    private ShellGroup sg;
    private RadialPanel rp;
    JPanel nonInput;
    
    @Override
    public void run(){
        this.pack();
        this.setVisible(true);
    }
    
    public MainView(){
        sg = new ShellGroup();
        rp = new RadialPanel();
        inputPanel = new InputPanel(sg, rp);
        graphPanel = new GraphPanel();
        nonInput = new JPanel();
        nonInput.setLayout(new FlowLayout());
        nonInput.add(graphPanel);
        nonInput.add(rp);
        this.setLayout(new BorderLayout());
        //add(graphPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(nonInput, BorderLayout.CENTER);
        //this.setResizable(false);
        
    }
}
