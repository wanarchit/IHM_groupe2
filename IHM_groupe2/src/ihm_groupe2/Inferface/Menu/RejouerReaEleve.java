package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlRejouerReaEleve;
import ihm_groupe2.Noyau_fonctionnel.Canvas;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Groupe 2
 */
public class RejouerReaEleve extends JFrame {
    
    private Realisation rea;
    private int tour;
    private JButton butAvance,butRecule,butRetour;
    private CtrlRejouerReaEleve controleur;
    private ArrayList<Commande> listActionActu;     // permet de savoir qu'elle action a a déjà fait
    
    public RejouerReaEleve(Realisation laRea){
        rea = laRea;
        tour = 0;
        listActionActu = new ArrayList();
        resetDessin();
        
        controleur = new CtrlRejouerReaEleve(this);
        butAvance = new JButton("Avancer");
        butAvance.addActionListener(controleur);
        butRecule = new JButton("Reculer");
        butRecule.addActionListener(controleur);
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        
        JPanel globalPanel = new JPanel(new BorderLayout());
        globalPanel.add(butAvance,BorderLayout.EAST);
        globalPanel.add(butRecule,BorderLayout.WEST);
        globalPanel.add(butRetour,BorderLayout.SOUTH);
        globalPanel.add(Canvas.getCanvasPanel(),BorderLayout.CENTER);
        
        
        
        
        this.add(globalPanel);
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Affichage réalisation");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public int getTour(){
        return tour;
    }
    
    public JButton getButAvance(){
        return butAvance;
    }
    
    public JButton getButRecule(){
        return butRecule;
    }
    
    public JButton getButRetour(){
        return butRetour;
    }
    
    public ArrayList<Commande> getLaReaActu(){
        return listActionActu;
    }
    
    public Realisation getLaRea(){
        return rea;
    }
    
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
    
    public void resetDessin(){
        rea.getExercice().getMaTortue().reset();
        if (rea.getExercice().getMaTortue().getClass() == TortueCouleur.class){
            ((TortueCouleur)rea.getExercice().getMaTortue()).setCouleur("black");
        }else if(rea.getExercice().getMaTortue().getClass() == TortueRapide.class){
            ((TortueRapide)rea.getExercice().getMaTortue()).setVitesse(1);
        }
    }
    
    public void annuler(){
        if (listActionActu.size() != 0){
                listActionActu.remove(listActionActu.size()-1);
                resetDessin();
                tour-=1;
                doActions();
            }
    }
    
    
    public void avancer(){
        if (this.rea.getListeCommande().size() != tour){
            listActionActu.add(this.rea.getCommandeInListe(this.tour));
            doActions();
            this.tour+=1;
        }
       
        
        
        
    }
    

}
