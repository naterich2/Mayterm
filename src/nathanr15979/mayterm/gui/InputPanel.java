package nathanr15979.mayterm.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import nathanr15979.mayterm.control.ShellGroup;

/**
 *
 * @author nathan richman
 */
public class InputPanel extends JPanel implements ItemListener {
    public JCheckBox [] checkBoxes;
    public static final int [] ORBITALS = {ShellGroup.S,ShellGroup.P1,ShellGroup.P2,ShellGroup.P3,
                                           ShellGroup.D1,ShellGroup.D2,ShellGroup.D3,ShellGroup.D4, ShellGroup.D5};
    private final ShellGroup sg;
    private final RadialPanel rp;
    private final JPanel s;
    private final JPanel p;
    private final JPanel d;
    private final JLabel sl;
    private final JLabel pl;
    private final JLabel dl;
    private final JPanel shellPanel;
    private final JPanel n;
    public final JCheckBox n1;
    public final JCheckBox n2;
    public final JCheckBox n3;
    private final JLabel nLabel;
    
    public InputPanel(ShellGroup sg, RadialPanel radial){
        super();
        this.sg = sg;
        rp = radial;
        this.setLayout(new FlowLayout());
        shellPanel = new JPanel();
        shellPanel.setLayout(new GridLayout(3,1));
        //this.setMinimumSize(new Dimension(150,80));

        String [] orbitalOrientations = {"s","px","py","pz","dxy","dyz","dz2","dxz","dxy2"};
        checkBoxes = new JCheckBox[orbitalOrientations.length];
        for(int i = 0; i<orbitalOrientations.length; i++){
            checkBoxes[i] = new JCheckBox();
            checkBoxes[i].setToolTipText("Turn on "+orbitalOrientations[i]+" orbital");
            checkBoxes[i].addItemListener(this); 
        } 
        s = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        d = new JPanel(new FlowLayout(FlowLayout.LEADING));
        sl = new JLabel("s: ");
        s.add(sl);
        s.add(checkBoxes[0]);
        pl = new JLabel("p: ");
        p.add(pl);
        p.add(checkBoxes[1]);
        p.add(checkBoxes[2]);
        p.add(checkBoxes[3]);
        dl = new JLabel("d: ");
        d.add(dl);
        d.add(checkBoxes[4]);
        d.add(checkBoxes[5]);
        d.add(checkBoxes[6]);
        d.add(checkBoxes[7]);
        d.add(checkBoxes[8]);
        shellPanel.add(s);
        shellPanel.add(p);
        shellPanel.add(d);
        
        n = new JPanel(new GridLayout(4,1));
        nLabel = new JLabel("n: ");
        n1 = new JCheckBox("1: ");
        n2 = new JCheckBox("2: ");
        n3 = new JCheckBox("3: ");
        n1.addItemListener(this);
        n2.addItemListener(this);
        n3.addItemListener(this);
        n.add(nLabel);
        n.add(n1);
        n.add(n2);
        n.add(n3);
        this.add(n);
        this.add(shellPanel);
        
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItem();
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED? true : false);
            if(source == n1)
                rp.setNShellSelected(selected, RadialPanel.N1);   
            else if(source == n2)
                rp.setNShellSelected(selected, RadialPanel.N2);  
            else if(source == n3)
                rp.setNShellSelected(selected, RadialPanel.N3);    
            else{
                int id = -1;
                for(int i = 0; i<checkBoxes.length; i++){
                    if(source.equals(checkBoxes[i])){
                        id = i;
                        break;
                    }  
                }
                if(id == 0)
                    rp.setSubShellSelected(selected, 0);
                else if(id<4)
                    rp.setSubShellSelected(selected, 1);
                else
                    rp.setSubShellSelected(selected, 2);
            }
    }
    
}
