package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlEvaluation;
import ihm_groupe2.Noyau_fonctionnel.Canvas;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Paul
 */
public class MenuEvaluation extends JPanel{
    
    private ApplicationProf appli;
    private Realisation rea;
    private CtrlEvaluation controleur;
    private JButton butRejouer;
    private JButton butValider;
    private JButton butAnnuler;
    
    private JTextField commExo;
    private ButtonGroup groupe;
    private JRadioButton butRadAcquis;
    private JRadioButton butRadEnCours;
    private JRadioButton butRadNonAcquis;
    
    
    public MenuEvaluation(ApplicationProf lAppli, Realisation laRea){
        appli = lAppli;
        rea = laRea;
        
        // PANEL HAUT 
            // Les boutons
        controleur = new CtrlEvaluation(appli,this);
        butRejouer = new JButton("Rejouer la réalisation");
        butRejouer.addActionListener(controleur);
        butValider = new JButton("Valider cette évaluation");
        butValider.addActionListener(controleur);
        butAnnuler = new JButton("Annuler l'évaluation");
        butAnnuler.addActionListener(controleur);
        JPanel panBut1 = new JPanel();
        panBut1.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panBut1.add(butRejouer);
        JPanel panBut2 = new JPanel();
        panBut2.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panBut2.add(butValider);
        JPanel panBut3 = new JPanel();
        panBut3.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panBut3.add(butAnnuler);

            // Les Labels 
        JPanel panLabHaut1 = new JPanel();
        panLabHaut1.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel label1 = new JLabel("Modèle élève");
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panLabHaut1.add(label1);
        JPanel panLabHaut2 = new JPanel();
        panLabHaut2.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel label2 = new JLabel("Actions élève");
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panLabHaut2.add(label2);
        JPanel panLabHaut3 = new JPanel();
        panLabHaut3.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel label3 = new JLabel("Modèle attendu");
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panLabHaut3.add(label3);

            // regroupement haut
        JPanel panelHaut = new JPanel(new GridLayout(2,3));
        panelHaut.add(panBut1);
        panelHaut.add(panBut2);
        panelHaut.add(panBut3);
        panelHaut.add(panLabHaut1);
        panelHaut.add(panLabHaut2);
        panelHaut.add(panLabHaut3);   
        
        // PANEL CENTRE
            // Modele élève
        JPanel panelModEleve = new JPanel();
        panelModEleve.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        rea.getExercice().getMaTortue().reset();
        panelModEleve.add(Canvas.getCanvasPanel(), BorderLayout.CENTER);
        
            // Actions élève
        JLabel labelAction = new JLabel();
        String lesCmd = "<html>";
        ArrayList<Commande> lesCommandes = rea.getListeCommande();
        int tailleListe = lesCommandes.size();
        for (int i = tailleListe-1; i >= 0 ; i--){
            lesCmd += lesCommandes.get(i).getCommande() + "<br>";
        }
        lesCmd+="</html>";
        labelAction.setText(lesCmd);
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JScrollPane scrollF = new JScrollPane(labelAction,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	    	       JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
            // Modèle attendu
        JPanel panelModProf = new JPanel();
        panelModProf.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        ImageIcon imageExo = new ImageIcon((rea.getExercice().getImage()).getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT));
        JLabel affImageExo = new JLabel();
        affImageExo.setIcon(imageExo);
        panelModProf.add(affImageExo);
        
        JPanel panelCentre = new JPanel(new GridLayout(1,3));
        panelCentre.add(panelModEleve);
        panelCentre.add(scrollF);
        panelCentre.add(panelModProf);
        
        // PANEL BAS
            // Panel Commentaire
        JLabel labelComm = new JLabel("Commentaire : ");
        commExo = new JTextField(70);
        JPanel panelComm = new JPanel();
        panelComm.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panelComm.add(labelComm);
        panelComm.add(commExo);
            
            // Panels Note
        groupe =  new ButtonGroup();
        butRadAcquis = new JRadioButton("ACQUIS");
        JPanel ssPanRad1 = new JPanel(new BorderLayout());
        ssPanRad1.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        ssPanRad1.add(butRadAcquis,BorderLayout.CENTER);
        butRadEnCours = new JRadioButton("EN COURS D'ACQUISITION");
        JPanel ssPanRad2 = new JPanel(new BorderLayout());
        ssPanRad2.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        ssPanRad2.add(butRadEnCours,BorderLayout.CENTER);
        butRadNonAcquis = new JRadioButton("NON ACQUIS");
        JPanel ssPanRad3 = new JPanel(new BorderLayout());
        ssPanRad3.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        ssPanRad3.add(butRadNonAcquis,BorderLayout.CENTER);
        
        groupe.add(butRadAcquis);
        groupe.add(butRadEnCours);
        groupe.add(butRadNonAcquis);
        
        JPanel panelNote = new JPanel(new GridLayout(1,3));
        panelNote.add(ssPanRad3);
        panelNote.add(ssPanRad2);
        panelNote.add(ssPanRad1);
            
            // Regroupement
        JPanel panelBas = new JPanel(new GridLayout(2,1));
        panelBas.add(panelComm);
        panelBas.add(panelNote);
        
        // Regroupement
        this.setLayout(new BorderLayout());
        this.add(panelHaut,BorderLayout.NORTH);
        this.add(panelCentre,BorderLayout.CENTER);
        this.add(panelBas,BorderLayout.SOUTH);
        
    }
    
    public Realisation getLaRea(){
        return rea;
    }
    
    public JButton getButRejouer(){
        return butRejouer;
    }
    
    public JButton getButValider(){
        return butValider;
    }
    
    public JButton getButAnnuler(){
        return butAnnuler;
    }
    
    public JTextField getCommentaire(){
        return commExo;
    }

    public JRadioButton getRadAcquis(){
        return butRadAcquis;
    }
    
    public JRadioButton getRadEnCours(){
        return butRadEnCours;
    }
    
    public JRadioButton getRadNonAcquis(){
        return butRadNonAcquis;
    }
}
