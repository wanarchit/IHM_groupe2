package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlRejouerReaEleve;
import ihm_groupe2.Noyau_fonctionnel.Canvas;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe RejouerReaEleve
 * Permet au professeur de visualiser la réalisation d'un exercice
 * Dans une JFrame générée par cette classe
 * @author Groupe 2
 */
public class RejouerReaEleve extends JFrame {
    
    private Realisation rea;
    private int tour;
    private JButton butAvance,butRecule,butRetour;
    private CtrlRejouerReaEleve controleur;
    private ArrayList<Commande> listActionActu;     // permet de savoir qu'elle action a a déjà fait
    /**
     * Constructeur de la classe RejouerReaEleve
     * @param laRea Réalisation concernée par la correction
     */
    public RejouerReaEleve(Realisation laRea){
        rea = laRea;
        tour = 0;
        listActionActu = new ArrayList();
        resetDessin();
        
        controleur = new CtrlRejouerReaEleve(this);
        butAvance = new JButton(new ImageIcon(getClass().getResource("/Images/avancer.png")));
        butAvance.setBackground(Color.white);
        butAvance.setBorderPainted(false);
        butAvance.setPreferredSize(new Dimension(200,75));
        butAvance.addActionListener(controleur);
        JPanel panelBut1 = new JPanel(new BorderLayout());
        panelBut1.setBackground(Color.white);
        panelBut1.add(butAvance,BorderLayout.CENTER);
        butRecule = new JButton(new ImageIcon(getClass().getResource("/Images/reculer.png")));
        butRecule.setBackground(Color.white);
        butRecule.setBorderPainted(false);
        butRecule.setPreferredSize(new Dimension(200,75));
        butRecule.addActionListener(controleur);
        JPanel panelBut2 = new JPanel(new BorderLayout());
        panelBut2.setBackground(Color.white);
        panelBut2.add(butRecule,BorderLayout.CENTER);
        butRetour = new JButton(new ImageIcon(getClass().getResource("/Images/but_quitter.png")));
        butRetour.setBackground(Color.white);
        butRetour.setBorderPainted(false);
        butRetour.setPreferredSize(new Dimension(200,75));
        butRetour.addActionListener(controleur);
        JPanel panelBut3 = new JPanel(new BorderLayout());
        panelBut3.setBackground(Color.white);
        panelBut3.add(butRetour,BorderLayout.CENTER);
        
        JPanel globalPanel = new JPanel(new BorderLayout());
        globalPanel.setBackground(Color.white);
        globalPanel.add(panelBut1,BorderLayout.EAST);
        globalPanel.add(panelBut2,BorderLayout.WEST);
        globalPanel.add(panelBut3,BorderLayout.SOUTH);
        globalPanel.add(Canvas.getCanvasPanel(),BorderLayout.CENTER);
        

        this.add(globalPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Affichage réalisation");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    /**
     * Méthode getTour
     * @return tour:int
     */
    public int getTour(){
        return tour;
    }
    /**
     * Méthode getButAvance
     * @return butAvance:JButton
     */
    public JButton getButAvance(){
        return butAvance;
    }
    /**
     * Méthode getButRecule
     * @return butRecule:JButton
     */
    public JButton getButRecule(){
        return butRecule;
    }
    /**
     * Méthode getButRetour
     * @return butRetour:JButton
     */
    public JButton getButRetour(){
        return butRetour;
    }
    /**
     * Méthode getLaReaActu
     * @return listActionActu:ArrayList<Commande>
     */
    public ArrayList<Commande> getLaReaActu(){
        return listActionActu;
    }
    /**
     * Méthode getLaRea
     * @return rea:Realisation
     */
    public Realisation getLaRea(){
        return rea;
    }
    /**
     * Méthode doActions
     * Permet d'affecter l'action de la réalisation dans la JFrame lors de la relecture 
     */
    public void doActions(){
        resetDessin();
        for(Commande cmd : this.listActionActu){
            if(cmd.getCommande().equals("Avance")){
                cmd.getTortue().avancer();
            }else if(cmd.getCommande().equals("Tourne")){
                cmd.getTortue().tourner();
            }else if(cmd.getCommande().equals("N'écrit plus")){
                cmd.getTortue().tracer(false);
            }else if(cmd.getCommande().equals("Ecrit")){
                cmd.getTortue().tracer(true);
            }else if(cmd.getCommande().equals("Ralentie")){
                ((TortueRapide) cmd.getTortue()).ralentir();
            }else if(cmd.getCommande().equals("Accélère")){
                ((TortueRapide) cmd.getTortue()).accelerer();
            }else if(cmd.getCommande().equals("Ecrit en noir")){
                ((TortueCouleur) cmd.getTortue()).setCouleur("black");
            }else if(cmd.getCommande().equals("Ecrit en rouge")){
                ((TortueCouleur) cmd.getTortue()).setCouleur("red");
            }else if(cmd.getCommande().equals("Ecrit en vert")){
                ((TortueCouleur) cmd.getTortue()).setCouleur("green");
            }else if(cmd.getCommande().equals("Ecrit en rose")){
                ((TortueCouleur) cmd.getTortue()).setCouleur("magenta");
            }else if(cmd.getCommande().equals("Ecrit en bleu")){
                ((TortueCouleur) cmd.getTortue()).setCouleur("blue");
            }else if(cmd.getCommande().equals("Ecrit en jaune")){
                ((TortueCouleur) cmd.getTortue()).setCouleur("yellow");
            }
        }
    }
    /**
     * Méthode resetDessin
     * Permet de reset la visualisation dans la JFrame
     */
    public void resetDessin(){
        rea.getExercice().getMaTortue().reset();
        if (rea.getExercice().getMaTortue().getClass() == TortueCouleur.class){
            ((TortueCouleur)rea.getExercice().getMaTortue()).setCouleur("black");
        }else if(rea.getExercice().getMaTortue().getClass() == TortueRapide.class){
            ((TortueRapide)rea.getExercice().getMaTortue()).setVitesse(1);
        }
    }
    /**
     * Méthode annuler
     * Permet d'annuler toutes les actions et également de réinisialiser le dessin
     * Dans la JFrame
     */
    public void annuler(){
        if (listActionActu.size() != 0){
                listActionActu.remove(listActionActu.size()-1);
                resetDessin();
                tour-=1;
                doActions();
            }
    }
    
    /**
     * Méthode avancer
     * Permet d'effectuer l'action enregistrée suivante
     */
    public void avancer(){
        if (this.rea.getListeCommande().size() != tour){
            listActionActu.add(this.rea.getCommandeInListe(this.tour));
            doActions();
            this.tour+=1;
        }
       
        
        
        
    }
    

}
