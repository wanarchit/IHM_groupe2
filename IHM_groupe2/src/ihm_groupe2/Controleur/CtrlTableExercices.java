package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.ListeExercices;
import ihm_groupe2.Modele.TableExercices;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe CtrlTableExercices
 * Controleur du tableau contenant la liste des exercices
 * 
 * @author Groupe 2
 */
public class CtrlTableExercices implements ListSelectionListener {
    
    private ListeExercices myTable;
    private ApplicationProf appli;
        
    /**
     * Constructeur du controleur CtrlTableExercices
     * @param myTable : table utilisée
     * @param lAppli : application utilisée
     */
    public CtrlTableExercices(ListeExercices myTable, ApplicationProf lAppli){
        this.myTable = myTable;
        appli = lAppli;
    }
    
    @Override
    /**
     * Méthode valueChanged
     * Permet de renvoyer vers la page de mofication de l'exercice en fonction
     * de l'exercice sélectionné par le professeur
     * Vérifie qu'une ligne est bien sélectionné ET que l'exercice est
     * bien moifiable c'est à dire réaliser par aucun élève pour le moment
     * @param act : list selection event
     */
    public void valueChanged(ListSelectionEvent act) {
        TableExercices modelTable = (TableExercices) myTable.getModele();
        if (act.getValueIsAdjusting())
            return;
        ListSelectionModel lsm = (ListSelectionModel)act.getSource();
        if (!lsm.isSelectionEmpty()) {
            int selectedRow = lsm.getMinSelectionIndex();
            Exercice e = modelTable.getExoRow(selectedRow);
            if (e.isModifiable()){
                appli.modifExercice(e);
            }else{
                //Boîte du message d'information.
               JOptionPane nonModif = new JOptionPane();
               nonModif.showMessageDialog(null, "Vous ne pouvez pas modifier cet exercice. Des élèves l'ont déjà fait.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }   
}   