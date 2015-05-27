package nathanr15979.mayterm.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;


import nathanr15979.mayterm.control.ShellGroup;

/**
 *
 * @author nathan richman
 */
public class InputPanel extends FlowPane  {
    public CheckBox [] checkBoxes;
    public static final int [] ORBITALS = {ShellGroup.S,ShellGroup.P1,ShellGroup.P2,ShellGroup.P3,
                                           ShellGroup.D1,ShellGroup.D2,ShellGroup.D3,ShellGroup.D4, ShellGroup.D5};
    private final ShellGroup sg;
    private final RadialPanel rp;
    private final FlowPane s;
    private final FlowPane p;
    private final FlowPane d;
    private final Label sl;
    private final Label pl;
    private final Label dl;
    private final VBox shellPanel;
    private final VBox n;
    public final CheckBox n1;
    public final CheckBox n2;
    public final CheckBox n3;
    private final Label nLabel;
    private int i = 0;
    
    public InputPanel(ShellGroup sg, RadialPanel radial){
        super();
        this.sg = sg;
        rp = radial;
        shellPanel = new VBox();
        //this.setMinimumSize(new Dimension(150,80));

        String [] orbitalOrientations = {"s","px","py","pz","dxy","dyz","dz2","dxz","dxy2"};
        checkBoxes = new CheckBox[orbitalOrientations.length];
        i = 0;
        while(i<orbitalOrientations.length){
            
            checkBoxes[i] = new CheckBox();
            checkBoxes[i].setTooltip(new Tooltip("Turn on "+orbitalOrientations[i]+" orbital"));
            checkBoxes[i].selectedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    sg.setSelected(newValue, ORBITALS[i]);
                    if(i == 0)
                        rp.setSubShellSelected(newValue, 0);
                    else if(i<4)
                        rp.setSubShellSelected(newValue, 1);
                    else
                        rp.setSubShellSelected(newValue, 2);   
                }
            }); 
            i++;
        } 
        s = new FlowPane();
        p = new FlowPane();
        d = new FlowPane();
        sl = new Label("s: ");
        s.getChildren().add(sl);
        s.getChildren().add(checkBoxes[0]);
        pl = new Label("p: ");
        p.getChildren().add(pl);
        p.getChildren().add(checkBoxes[1]);
        p.getChildren().add(checkBoxes[2]);
        p.getChildren().add(checkBoxes[3]);
        dl = new Label("d: ");
        d.getChildren().add(dl);
        d.getChildren().add(checkBoxes[4]);
        d.getChildren().add(checkBoxes[5]);
        d.getChildren().add(checkBoxes[6]);
        d.getChildren().add(checkBoxes[7]);
        d.getChildren().add(checkBoxes[8]);
        shellPanel.getChildren().add(s);
        shellPanel.getChildren().add(p);
        shellPanel.getChildren().add(d);
        
        n = new VBox();
        nLabel = new Label("n: ");
        n1 = new CheckBox("1: ");
        n2 = new CheckBox("2: ");
        n3 = new CheckBox("3: ");
        n1.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                rp.setNShellSelected(newValue, RadialPanel.N1);  
            }
        });
        n2.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                rp.setNShellSelected(newValue, RadialPanel.N2);  
            }
        });
        n3.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                rp.setNShellSelected(newValue, RadialPanel.N3);  
            }
        });
        n.getChildren().add(nLabel);
        n.getChildren().add(n1);
        n.getChildren().add(n2);
        n.getChildren().add(n3);
        this.getChildren().add(n);
        this.getChildren().add(shellPanel);
        
        
    }

    
}
