package Applications;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author Paul
 */
public class FenetreLoad extends JFrame{
    

    private JLabel labelText;
    
    public FenetreLoad(String monString){

        
        labelText = new JLabel(monString);
        labelText.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        labelText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPanel panelText = new JPanel();
        panelText.add(labelText);

        
        JPanel panelGlobal = new JPanel(new BorderLayout());
        panelGlobal.add(panelText,BorderLayout.CENTER);
        
        this.add(panelGlobal);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Chargement ...");
        this.setSize(500, 120);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void closeFrameLoad(){
        this.dispose();
    }

}
