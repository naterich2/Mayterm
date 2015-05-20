package nathanr15979.mayterm.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;

import nathanr15979.mayterm.control.ShellGroup;

/**
 *
 * @author nathan richman
 */
public class InputPanel extends JPanel {
    public JCheckBox [] checkBoxes;
    public static final int [] ORBITALS = {ShellGroup.S,ShellGroup.P1,ShellGroup.P2,ShellGroup.P3,
                                           ShellGroup.D1,ShellGroup.D2,ShellGroup.D3,ShellGroup.D4, ShellGroup.D5};
    private ShellGroup sg;
    private JPanel s;
    private JPanel p;
    private JPanel d;
    private JLabel sl;
    private JLabel pl;
    private JLabel dl;
    private JPanel shellPanel;
    private JPanel n;
    private JCheckBox n1;
    private JCheckBox n2;
    private JCheckBox n3;
    private JLabel nLabel;
    
    public InputPanel(ShellGroup sg){
        super();
        this.sg = sg;
        this.setLayout(new FlowLayout());
        shellPanel = new JPanel();
        shellPanel.setLayout(new GridLayout(3,1));
        //this.setMinimumSize(new Dimension(150,80));

        String [] orbitalOrientations = {"s","px","py","pz","dxy","dyz","dz2","dxz","dxy2"};
        checkBoxes = new JCheckBox[orbitalOrientations.length];
        for(int i = 0; i<orbitalOrientations.length; i++){
            checkBoxes[i] = new JCheckBox();
            checkBoxes[i].setToolTipText("Turn on "+orbitalOrientations[i]+" orbital");
            checkBoxes[i].addItemListener(new ButtonListener(this,sg)); 
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
        n.add(nLabel);
        n.add(n1);
        n.add(n2);
        n.add(n3);
        this.add(n);
        this.add(shellPanel);
        
        
    }
    
}
