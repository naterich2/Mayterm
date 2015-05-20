/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author nathan richman
 */
public class MainView extends JFrame implements Runnable {
    private InputPanel inputPanel;
    private GraphPanel graphPanel;
    
    @Override
    public void run(){
        this.pack();
        this.setVisible(true);
    }
    
    public MainView(){
        inputPanel = new InputPanel();
        graphPanel = new GraphPanel();
        this.setLayout(new BorderLayout());
        add(graphPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        this.setResizable(false);
    }
}
