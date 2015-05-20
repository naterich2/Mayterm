/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nathanr15979.mayterm.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author nathan richman
 */
public class ButtonListener implements ItemListener, ActionListener {
    InputPanel inputPanel;
    public ButtonListener(InputPanel my){
        inputPanel = my;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItem();
        int id = -1;
        for(int i = 0; i<inputPanel.checkBoxes.length; i++)
            if(inputPanel.checkBoxes[i].equals(source))
                id = i;
        /*(if(e.getStateChange() == ItemEvent.DESELECTED)
            waveGroup.selected(false, InputPanel.ORBITALS[id]);
        else
            waveGroup.selected(true, InputPanel.ORBITALS[id]);*/
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
   
}
